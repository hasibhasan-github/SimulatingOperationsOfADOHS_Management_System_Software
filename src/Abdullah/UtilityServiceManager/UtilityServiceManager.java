/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abdullah.UtilityServiceManager;

import AbdullahAlMamun.Announcement;
import MdHasibHasan.DataReadWrite;
import MdHasibHasan.Employee;
import MdHasibHasan.GenerateAlerts;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Div;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.TextAlignment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

/**
 *
 * @author user
 */
public class UtilityServiceManager extends Employee implements Serializable{

    public UtilityServiceManager(LocalDate dateOoJoin, float salary, String department, String designation, int id, String name, String gender, String email, String userType, LocalDate deathOfBirth, long contactNo) {
        super(dateOoJoin, salary, department, designation, id, name, gender, email, userType, deathOfBirth, contactNo);
    }

    @Override
    protected void applyForLeave() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public static void addNewServiceProvider(ServiceProvider sp){
        DataReadWrite.writeObjectToFile("ServiceProviders.bin", sp);
        GenerateAlerts.successfulAlert("New Provider Added");
    }
    
    public static void sentAnnouncementToResident(Announcement ann){
        DataReadWrite.writeObjectToFile("Announcements.bin", ann);
        GenerateAlerts.successfulAlert("Your Announce has been sended");
        
    }
    
    
    public static void crreatePdfReport(ObservableList<ServiceProvider> spList){
        
        try{
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            fc.setInitialFileName("ProviderList");
            File f = fc.showSaveDialog(null);
            
            if(f!=null){
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                PdfDocument pdf = new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
                
                String newline = "\n";
                Paragraph linspace = new Paragraph(newline);
                linspace.setHeight(3);
                
                Text titleText = new Text("DOHS");
                titleText.setFontSize(18f);
                
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();
                
                Text titleText1 = new Text("All Providers List");
                
                Paragraph pageTitle1 = new Paragraph(titleText1);
                pageTitle.setBold();
                
                String plist = "";
                for(ServiceProvider x : spList){
                    plist+= x.toString() + "\n" + "\n";
                }
                Paragraph mainParagraph = new Paragraph(plist);
                
                Paragraph signature = new Paragraph().add("Md Abdullah"+ "\n"+ "Utility Service Manager"+ "\n").setTextAlignment(TextAlignment.RIGHT).setMarginTop(30);;
                
                Div headerContainer = new Div().setBackgroundColor(
                        Color.LIGHT_GRAY).setPadding(5).setHeight(40);
                headerContainer.add(pageTitle);
                headerContainer.add(pageTitle1);
                
                doc.add(headerContainer);
                doc.add(linspace);
                doc.add(mainParagraph);
                doc.add(linspace);
                doc.add(signature);
                doc.close();
                
                
            }
            
            
        }
        catch(Exception e){
            GenerateAlerts.unsuccessfulAlert("Oops! Exception: " + e.toString()+ " occured.");
        }
        
    }
    
    
}
