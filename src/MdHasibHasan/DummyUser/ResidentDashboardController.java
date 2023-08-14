/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.DummyUser;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.MaintenanceOfficer.carStickerRequest;
import MdHasibHasan.sceneChanging;
import MdHasibHasan.signUpData;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class ResidentDashboardController implements Initializable {
    
    @FXML
    private TextField applicationStatusLabel;
    
    private signUpData currentlyLoggedInUserInfo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //System.out.println(currentlyLoggedInUserInfo.getEmail());
                
    }

    public void helperOfDataPassing(signUpData userDetails){
        //resident = people;
        //System.out.println("Hasib");
        System.out.println(userDetails.getEmail());
        currentlyLoggedInUserInfo = new signUpData(userDetails.getId(),userDetails.getEmail(), 
                                        userDetails.getPassword(), userDetails.getUserType());
    }


    @FXML
    private void applyForCarStickerOnClick(ActionEvent event) {
        // System.out.println(currentlyLoggedInUserInfo.getEmail());
        carStickerRequest application = new carStickerRequest(currentlyLoggedInUserInfo.getId(), "NO",
                                            currentlyLoggedInUserInfo.getEmail(), "Done");
        System.out.println(application.getEmail());
        DataReadWrite.writeObjectToFile("CarStickerRequestData.bin", application);
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/simulatingoperationsofdohs_management_system_software/login.fxml");
        GenerateAlerts.successfulAlert("Have good day!" + "\n" + "Please visit Again");
    }
    
}
