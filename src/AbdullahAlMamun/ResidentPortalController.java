/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.GenerateAlerts;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ResidentPortalController implements Initializable {

    @FXML
    private ComboBox<String> announcementTypeComboBox;
    @FXML
    private TextArea writeAnnTextArea;
    @FXML
    private DatePicker dateLocalDate;
    @FXML
    private Button annSentBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        announcementTypeComboBox.getItems().addAll("Security Update","Emergency Alert","Lost and Found","Community Event");
        
        String annType = announcementTypeComboBox.getValue();
        String annText = writeAnnTextArea.getText();
        LocalDate date = dateLocalDate.getValue();
        
        
        
    }    

    @FXML
    private void sentAnnouncementButtonOnClick(ActionEvent event) {
        try{
            String annType = announcementTypeComboBox.getValue();
            String annText = writeAnnTextArea.getText();
            LocalDate date = dateLocalDate.getValue();
            
            if(annType == null || annText == null || date == null){
                GenerateAlerts.unsuccessfulAlert("Please fill in all fields.");
                return; 
        }
            Announcement ann = new Announcement(annType, annText, date);

            SecurityCheif.sentAnnouncementToResident(ann);
            annSentBtn.setDisable(true);
        
        
    }
        catch(Exception ee){
             GenerateAlerts.unsuccessfulAlert("An error occurred. Please try again.");
        }
    
}



}
