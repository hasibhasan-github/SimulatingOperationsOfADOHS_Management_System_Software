/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DataReadWrite;
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
    
    public static void planOrAddNewDevelopementProject(developementProject newDevProject){
        // Writing the new Developement Data in File.
        DataReadWrite.writeObjectToFile("DevelopmentProjects.bin", newDevProject);
        // Generating successful Alert.
        GenerateAlerts.successfulAlert("New Project added Successfully.");
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
        
}
