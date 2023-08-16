/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
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
    private RadioButton visitorMaleRadioBtn;
    @FXML
    private RadioButton visitorFemaleRadioBtn;
    @FXML
    private ComboBox<String> selectPurposeOfVisitComboBox;
    ToggleGroup tg;
    @FXML
    private ComboBox<?> selectPurposeOfVisitComboBox1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tg = new ToggleGroup();
        visitorMaleRadioBtn.setToggleGroup(tg);
        visitorFemaleRadioBtn.setToggleGroup(tg);
        
        selectPurposeOfVisitComboBox.getItems().addAll("Guest of Resident",
                                                        "Delivery/Pickup",                                 
                                                        "Meeting with resident",
                                                        "Official Business",
                                                        "Social Gathering/Event Participation",                                                        
                                                        "Contractor/Service Provider",
                                                        "Vendor/Supplier");
        
        
    }    

    @FXML
    private void sendAccessRequestBtnOnClick(ActionEvent event) {
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage,"/simulatingoperationsofdohs_management_system_software/login.fxml" );
    }
    
}
