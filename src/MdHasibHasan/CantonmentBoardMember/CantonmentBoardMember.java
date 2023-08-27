/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.DummyUser.Resident;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.User;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 *
 * @author Hasib
 */
public class CantonmentBoardMember extends User implements Serializable {
    private String militaryRank;

    public CantonmentBoardMember(String militaryRank, int id, String name, String gender, String email, String userType, LocalDate deathOfBirth, long contactNo) {
        super(id, name, gender, email, userType, deathOfBirth, contactNo);
        this.militaryRank = militaryRank;
    }
    
    public static void implyNewPoliciesAndGuidelines(dohsPolicies policy){
        DataReadWrite.writeObjectToFile("DOHSPOLICIES.bin", policy);
        // Generating successful Alert.
        GenerateAlerts.successfulAlert("Policy added Successfully.");
    }
    
    public static ObservableList<dohsPolicies> deleteAnOldPolicy(dohsPolicies policy){ 
        // Creating Dummy Instance
        dohsPolicies dummyInstance = new dohsPolicies("", LocalDate.of(2023, 02, 02),
                                                LocalDate.of(2023, 02, 02), new ArrayList<String>());
        ObservableList<dohsPolicies> policyListOfDohs = (ObservableList<dohsPolicies>) DataReadWrite.readObjectToFile("DOHSPOLICIES.bin", dummyInstance);
        
        ObservableList<dohsPolicies> updatedPolicyListOfDohs = FXCollections.observableArrayList();
        // Updating the data in a new list.
        for ( dohsPolicies policyData : policyListOfDohs ){
            if (policyData.getPolicyName().equals(policy.getPolicyName())) continue;
            else updatedPolicyListOfDohs.add(policyData);
        }
        // Writing the new List Data to Binary File 
        for ( int i = 0; i < updatedPolicyListOfDohs.size(); i++ ){
            if ( i == 0 ) DataReadWrite.overWriteObjectToFile("DOHSPOLICIES.bin", updatedPolicyListOfDohs.get(i));
            else DataReadWrite.writeObjectToFile("DOHSPOLICIES.bin", updatedPolicyListOfDohs.get(i));
        }
        // Returning the updated List
        return updatedPolicyListOfDohs;
    }
    
    public static ObservableList<loadResidentData> viewAllResidentDataAndMaleFemaleRatio(Resident people){
        // Reading all Resident data from Resident.bin 
        ObservableList<Resident> residentData = (ObservableList<Resident>) DataReadWrite.readObjectToFile("Resident.bin", people);
        // Instantiating dataForTableView ObservableList for storing the data to show Cantonment Board Member.
        ObservableList<loadResidentData> dataForTableView = FXCollections.observableArrayList();
        // Storing all the resident Data into loadResidentData class instance.
        for ( Resident tmpResidentData : residentData ){
            dataForTableView.add(new loadResidentData(tmpResidentData.getName(), tmpResidentData.getPlotNo(),
                                tmpResidentData.getGender(), tmpResidentData.getHoldingOrFlatNo(), tmpResidentData.getId()));
        }
        return dataForTableView;
    }
    
    public static void planOrAddNewDevelopementProject(developementProject newDevProject){
        // Writing the new Developement Data in File.
        DataReadWrite.writeObjectToFile("DevelopmentProjects.bin", newDevProject);
        // Generating successful Alert.
        GenerateAlerts.successfulAlert("New Project added Successfully.");
    }
    
    public static ObservableList<crucialTaskPermissionRequest> acceptOrRejectPendingPermission(ObservableList<crucialTaskPermissionRequest> crucTaskReq ){
        for ( int i = 0; i < crucTaskReq.size(); ++i ){
            if ( i == 0 ) DataReadWrite.overWriteObjectToFile("CrucialTaskPermissionRequest.bin", crucTaskReq.get(i));
            else DataReadWrite.writeObjectToFile("CrucialTaskPermissionRequest.bin", crucTaskReq.get(i));
        }
        //
        crucTaskReq.clear();
        crucialTaskPermissionRequest dummyInstance = new crucialTaskPermissionRequest(1, "", "", LocalDate.of(2023, 02, 02),
        LocalDate.of(2023, 02, 02), new ArrayList<String>());
        
        crucTaskReq = (ObservableList<crucialTaskPermissionRequest>) DataReadWrite.readObjectToFile("CrucialTaskPermissionRequest.bin", dummyInstance);
        //
        return crucTaskReq;
    }
    
    public static void organizeNewVote(String projName, LocalDate startDate){
        developementProject dummyInstance = new developementProject("", LocalDate.of(2023, 03, 10), new ArrayList<String>());
        // Reading the data From File.
        ObservableList<developementProject> projectDevPlan = (ObservableList<developementProject>) DataReadWrite.readObjectToFile("DevelopmentProjects.bin", dummyInstance);
        
        developementProject votingInstance = null;
        
        for ( developementProject comboBoxData : projectDevPlan ){
            if ( comboBoxData.getProjectName().equals(projName) ){
                votingInstance = comboBoxData;
            }
        }
        
        developementProjectVoting newVoteProj = new developementProjectVoting(projName, votingInstance, startDate);
        
        DataReadWrite.overWriteObjectToFile("developementProjectVoting.bin", newVoteProj);
    }
    
    public static void sendImportantNotice(sendNotice newNotice){
        DataReadWrite.writeObjectToFile("DOHSNotice.bin", newNotice);
        
        GenerateAlerts.successfulAlert("Notice has been published.");
    }
    
    public static ObservableList<sendNotice> deleteNotice(sendNotice delNotice){
        ObservableList<sendNotice> noticeList = (ObservableList<sendNotice>) DataReadWrite.readObjectToFile("DOHSNotice.bin", delNotice);
        
        ObservableList<sendNotice> updateNoticeList = FXCollections.observableArrayList();
        
        for ( sendNotice noticeData1 : noticeList  ){
            if ( noticeData1.getNoticeName().equals(delNotice.getNoticeName()) && noticeData1.getNoticeSubject().equals(delNotice.getNoticeSubject()) ) continue;
            else updateNoticeList.add(noticeData1);
        }
        
        for ( int i = 0; i < updateNoticeList.size(); ++i ){
            if ( i == 0 ) DataReadWrite.overWriteObjectToFile("DOHSNotice.bin", updateNoticeList.get(i));
            else DataReadWrite.writeObjectToFile("DOHSNotice.bin", updateNoticeList.get(i));
        }
        GenerateAlerts.successfulAlert("Deletion has been successful.");
        return updateNoticeList;
    }
    
    
    public static void generateDevelopementProjectPDF(developementProject devProjectPDF){
        try {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new ExtensionFilter("PDF Files", "*.pdf"));
            fc.setInitialFileName(devProjectPDF.getProjectName());
            File f = fc.showSaveDialog(null);
            if (f != null){
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                PdfDocument pdf = new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
                
                String newline = "\n";
                Paragraph linspace = new Paragraph(newline);
                linspace.setHeight(3);
                
                Text titleText = new Text(devProjectPDF.getProjectName());
                titleText.setFontSize(18f);
                
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();
                
                String paraText1 = "";
                for ( int i = 0; i < devProjectPDF.getProjectDescription().size(); ++i ){
                    paraText1 += devProjectPDF.getProjectDescription().get(i) + "\n" + "\n";
                }
                Paragraph mainParagraph = new Paragraph(paraText1);
                
                Paragraph signature = new Paragraph().add("Md Hasib Hasan\nPresident, Cantonment Board\n"+
                        devProjectPDF.getProjectStartDate() + "\nMIRPUR DOHS").setTextAlignment(TextAlignment.RIGHT).setMarginTop(30);
                
                String logoImagePath = "mirpurdohslogo.png";
                Image logoImage = new Image(ImageDataFactory.create(logoImagePath));
                logoImage.setWidth(30); 
                logoImage.setHeight(30);

                Div headerContainer = new Div().setBackgroundColor(
                        Color.LIGHT_GRAY).setPadding(5).setHeight(40);
                headerContainer.add(pageTitle);
                headerContainer.add(logoImage).setTextAlignment(TextAlignment.RIGHT);

                doc.add(headerContainer);
                
                doc.add(linspace);
                doc.add(mainParagraph);
                doc.add(linspace);
                doc.add(signature);
                doc.close();
            }
            else{
                GenerateAlerts.unsuccessfulAlert("Saving as PDF: cancelled!");
            }
        }
        catch (Exception e){
            GenerateAlerts.unsuccessfulAlert("Oops! Exception: " + e.toString()+ " occured.");
        }
        
    }
    
    public static void viewPendingPermissionPDF(crucialTaskPermissionRequest devProjectPDF){
            try {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            fc.setInitialFileName(devProjectPDF.getEventNamme());
            File f = fc.showSaveDialog(null);
            if (f != null){
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                PdfDocument pdf = new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
                
                String newline = "\n";
                Paragraph linspace = new Paragraph(newline);
                linspace.setHeight(3);
                
                Text titleText = new Text(devProjectPDF.getEventNamme());
                titleText.setFontSize(18f);
                
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();
                
                
                Text titleText1 = new Text( "Event Date: " + String.valueOf(devProjectPDF.getEventDate()) 
                                + "\n" + "Application Status: " + devProjectPDF.getPermissionStatus() );
                
                Paragraph pageTitle1 = new Paragraph(titleText1);
                pageTitle.setBold();
                
                
                String paraText1 = "";
                for ( int i = 0; i < devProjectPDF.getEventDescription().size(); ++i ){
                    paraText1 += devProjectPDF.getEventDescription().get(i) + "\n" + "\n";
                }
                Paragraph mainParagraph = new Paragraph(paraText1);
                Paragraph signature = new Paragraph().add( devProjectPDF.getEventNamme() + "\n" + devProjectPDF.getDepartment() + "Department" + "\n"+
                        "Application Date: " + devProjectPDF.getApplicationDate() + "\nMIRPUR DOHS").setTextAlignment(TextAlignment.RIGHT).setMarginTop(30);
                
                String logoImagePath = "mirpurdohslogo.png";
                Image logoImage = new Image(ImageDataFactory.create(logoImagePath));
                logoImage.setWidth(30); 
                logoImage.setHeight(30);

                Div headerContainer = new Div().setBackgroundColor(
                        Color.LIGHT_GRAY).setPadding(5).setHeight(40);
                headerContainer.add(pageTitle);
                headerContainer.add(logoImage).setTextAlignment(TextAlignment.RIGHT);
                headerContainer.add(pageTitle1);

                doc.add(headerContainer);
                
                doc.add(linspace);
                doc.add(mainParagraph);
                doc.add(linspace);
                doc.add(signature);
                doc.close();
            }
            else{
                GenerateAlerts.unsuccessfulAlert("Saving as PDF: cancelled!");
            }
        }
        catch (Exception e){
            GenerateAlerts.unsuccessfulAlert("Oops! Exception: " + e.toString()+ " occured.");
        }
    }
        
}
