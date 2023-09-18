/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;

import MdHasibHasan.CantonmentBoardMember.sendNotice;
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
import java.io.FileOutputStream;
import javafx.stage.FileChooser;

/**
 *
 * @author Hasib
 */

public  class downloadNoticePDF {
    public static void downloadNoticePDF( sendNotice pdfNotice){
            try {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
            fc.setInitialFileName(pdfNotice.getNoticeName());
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
                
                Text titleText = new Text(pdfNotice.getNoticeName());
                titleText.setFontSize(18f);
                
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();
                
                
                Text titleText1 = new Text( "Notice Date: " + String.valueOf(pdfNotice.getNoticeDate()) 
                                + "\n" + "Subject: " + pdfNotice.getNoticeSubject() );
                
                Paragraph pageTitle1 = new Paragraph(titleText1);
                pageTitle.setBold();
                
                
                String paraText1 = "";
                for ( int i = 0; i < pdfNotice.getNoticeDescription().size(); ++i ){
                    paraText1 += pdfNotice.getNoticeDescription().get(i) + "\n" + "\n";
                }
                Paragraph mainParagraph = new Paragraph(paraText1);
                Paragraph signature = new Paragraph().add("Md Hasib Hasan\nPresident, Cantonment Board\n"+
                        pdfNotice.getNoticeDate() + "\nMIRPUR DOHS").setTextAlignment(TextAlignment.RIGHT).setMarginTop(30);
                
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
