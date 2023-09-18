/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */

public class LogOutSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        // Creating new Scene and Loading the Stage
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        // Generating Confirmation Alert. If confirmation is true Log out & go to dashboard. 
        if (GenerateAlerts.confirmationAlert()) newwscene.logOutSceneSwitching(stage);
        
    }

    @FXML
    private void seeServiceLifeHHistoryButtonOnClick(ActionEvent event) {
    }
    
}
