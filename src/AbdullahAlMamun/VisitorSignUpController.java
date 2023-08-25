/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
        
        
    }    

    @FXML
    private void sendAccessRequestBtnOnClick(ActionEvent event) {
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
        
         }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage,"/simulatingoperationsofdohs_management_system_software/login.fxml" );
    }
    
}
