/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    @FXML
    private TextArea feedbackShowTextArea;
    @FXML
    private ComboBox<String> selectFeedbackTypeComboBoxfxid;
    @FXML
    private Button loadFeedBackBtnFxid;
    
    private ObservableList<FeedBack> fbList;
    @FXML
    private TableView<?> feedbackTableView;
    @FXML
    private TableColumn<?, ?> dateTableCol;
    @FXML
    private TableColumn<?, ?> residentIdTableCol;
    @FXML
    private TableColumn<?, ?> feedBackTableCol;
    @FXML
    private Button loadToTextAreaBtn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        announcementTypeComboBox.getItems().addAll("Security Update","Emergency Alert","Lost and Found","Community Event","Parking Update");
        
        String annType = announcementTypeComboBox.getValue();
        String annText = writeAnnTextArea.getText();
        LocalDate date = dateLocalDate.getValue();
        
        
        selectFeedbackTypeComboBoxfxid.getItems().addAll("Security Concerns","Emergency Response","Access Issues","Suggestions for Improvement","Incidents Reporting","New connection", "Connectivity Isue");
        
        
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

    @FXML
    private void loadFeedbackButtonOnClick(ActionEvent event) {
        FeedBack fb = new FeedBack("","","","","",LocalDate.of(2023,07,07));
        fbList = (ObservableList<FeedBack>) DataReadWrite.readObjectToFile("FeedBack.bin", fb);
        for(FeedBack x : fbList){
            if(x.getDept().equals("Security Cheif")){
                if(x.getAnnType().equals(selectFeedbackTypeComboBoxfxid.getValue())){
                    feedbackShowTextArea.appendText(x.toString());
                    loadFeedBackBtnFxid.setDisable(true);
                }
            }
            else{
                GenerateAlerts.unsuccessfulAlert("No feedback to load");
            }
        }
        
        
        
    }

    @FXML
    private void loadToTextAreaButtonOnClick(ActionEvent event) {
    }



}
