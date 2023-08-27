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
import javafx.scene.control.cell.PropertyValueFactory;

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
    private Button loadFeedBackBtnFxid;
    
    private ObservableList<FeedBack> fbList;
    @FXML
    private TableView<FeedBack> feedbackTableView;
    @FXML
    private TableColumn<FeedBack, String> residentIdTableCol;
    @FXML
    private Button loadToTextAreaBtn;
    @FXML
    private TableColumn<FeedBack, String> deptTableCol;
    @FXML
    private TableColumn<FeedBack, String> houseNoTableViewfxid;
    @FXML
    private TableColumn<FeedBack, String> announcementTypeTableViewfxid;
    @FXML
    private TableColumn<FeedBack, String> announcementTextTableViewfxid;
    @FXML
    private TableColumn<FeedBack, LocalDate> dateTableViewfxid;
    @FXML
    private Button loadTTableBtnFxid;

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
        
        // For Table
        deptTableCol.setCellValueFactory(new PropertyValueFactory<FeedBack, String>("Dept"));
        residentIdTableCol.setCellValueFactory(new PropertyValueFactory<FeedBack, String>("residentId"));
        houseNoTableViewfxid.setCellValueFactory(new PropertyValueFactory<FeedBack, String>("houseNo"));
        announcementTypeTableViewfxid.setCellValueFactory(new PropertyValueFactory<FeedBack, String>("annType"));
        announcementTextTableViewfxid.setCellValueFactory(new PropertyValueFactory<FeedBack, String>("announceText"));
        dateTableViewfxid.setCellValueFactory(new PropertyValueFactory<FeedBack, LocalDate>("date"));
        
        
        
        
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
    private void loadToTextAreaButtonOnClick(ActionEvent event) {
        try{
            if ( feedbackTableView.getSelectionModel().getSelectedItem() == null ) throw new RuntimeException("Exception");
             for(FeedBack y : fbList){
                 if(y == feedbackTableView.getSelectionModel().getSelectedItem()){
                     feedbackShowTextArea.appendText(y.toString());
                 }
             }
        }
        catch( RuntimeException e ) {
            GenerateAlerts.unsuccessfulAlert("Please Select the File from Table to Load.");
        }
    }

    @FXML
    private void loadToTableButtonOnClick(ActionEvent event) {
        FeedBack fb = new FeedBack("","","","","",LocalDate.of(2023,07,07));
        fbList = (ObservableList<FeedBack>) DataReadWrite.readObjectToFile("FeedBack.bin", fb);
        
        for(FeedBack x : fbList){
            if(x.getDept().equals("Security Cheif")){
                if(x.getAnnType().equals(selectFeedbackTypeComboBoxfxid.getValue())){
                    feedbackTableView.getItems().add(x);
                }
                else{
                GenerateAlerts.unsuccessfulAlert("No Feedback for this Type");
            }
            }
            else{
                GenerateAlerts.unsuccessfulAlert("No Feedback for the user Security cheif");
            }
        }
        
        
        
    }



}
