/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class VisitorSignUpController implements Initializable {

    @FXML
    private TextField visitorNamefxid;
    @FXML
    private TextField visitorNidfxid;
    @FXML
    private TextField visitorContactNofxid;
    @FXML
    private ComboBox<String> selectPurposeOfVisitComboBox;
    
    @FXML
    private DatePicker selectDateLocalDate;
    @FXML
    private ComboBox<String> selectTimeSlotComboBox;
    @FXML
    private ComboBox<String> selectGenderComboBox;
    @FXML
    private Button gaBackButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        selectPurposeOfVisitComboBox.getItems().addAll("Guest of Resident",
                                                        "Delivery/Pickup",                                 
                                                        "Meeting with resident",
                                                        "Official Business",
                                                        "Social Gathering/Event Participation",                                                        
                                                        "Contractor/Service Provider",
                                                        "Vendor/Supplier");
        selectTimeSlotComboBox.getItems().addAll("8.00-10.00 am",
                                                 "10.00-12.00 am",
                                                 "12.00-2.00 pm",
                                                 "2.00-4.00 pm",
                                                 "4.00-6.00 pm",
                                                 "6.00-8.00 pm",
                                                 "8.00-10.00 pm");
        selectGenderComboBox.getItems().addAll("Male","Female");
        
        
    }    

    @FXML
    private void sendAccessRequestBtnOnClick(ActionEvent event) {
        String visitorName = visitorNamefxid.getText();
        String visitorNid = visitorNidfxid.getText();
        String visitorContactNo = visitorContactNofxid.getText();
        String purposeOfVisit = selectPurposeOfVisitComboBox.getValue();
        String timeSlot = selectTimeSlotComboBox.getValue();
        String gender = selectGenderComboBox.getValue();
        LocalDate date = selectDateLocalDate.getValue();
        try{
            if (visitorName.isEmpty() || visitorNid.isEmpty() || visitorContactNo.isEmpty() ||
            purposeOfVisit == null || timeSlot == null || gender == null || date == null) {
            GenerateAlerts.unsuccessfulAlert("Please fill in all fields.");
            return; 
            }
            Visitor visitor = new Visitor(visitorNamefxid.getText(),
                                      visitorNidfxid.getText(), 
                                      visitorContactNofxid.getText(),
                                      selectPurposeOfVisitComboBox.getValue(),
                                      selectTimeSlotComboBox.getValue(),
                                      selectGenderComboBox.getValue(),
                                      selectDateLocalDate.getValue());
        
        DataReadWrite.writeObjectToFile("Visitor.bin", visitor);
        
        VisitorRequest visitorReq = new VisitorRequest(visitorNamefxid.getText(),
                                                     visitorContactNofxid.getText(),
                                               selectPurposeOfVisitComboBox.getValue(), 
                                                    selectTimeSlotComboBox.getValue(),
                                             "Pending");
        
        DataReadWrite.writeObjectToFile("VisitorRequest.bin", visitorReq);
        GenerateAlerts.successfulAlert("Your Request has been sent");
        gaBackButton.setDisable(true);
        }
        catch(Exception ee){
            GenerateAlerts.unsuccessfulAlert("An error occurred. Please try again.");
        }
        
         }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newwscene.logOutSceneSwitching(stage);
    }
    
}
