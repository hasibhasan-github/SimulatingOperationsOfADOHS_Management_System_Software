/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.DummyUser;

import MdHasibHasan.signUpData;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class ResidentDashboardController implements Initializable {
    
    signUpData currentlyLoggedInUserInfo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //System.out.println(resident.toString());
        
    }

    public void helperOfDataPassing(signUpData userDetails){
        //resident = people;
        //System.out.println("Hasib");
        //System.out.println(userDetails.getEmail());
        currentlyLoggedInUserInfo = userDetails;
    }

    @FXML
    private void ok(ActionEvent event) {
        System.out.println(currentlyLoggedInUserInfo.getEmail());
    }
    
}
