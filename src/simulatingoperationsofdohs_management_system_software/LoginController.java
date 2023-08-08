/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package simulatingoperationsofdohs_management_system_software;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class LoginController implements Initializable {

    @FXML
    private TextField emailOrIdTextField;
    @FXML
    private ComboBox<?> selectUserComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void visitorButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void aboutButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void contactButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void signInButtonOnClick(ActionEvent event) {
        System.out.println("SignIn");
    }

    @FXML
    private void forgetPasswordButtonOnClick(ActionEvent event) {
        System.out.println("ForgetPassword");
    }

    @FXML
    private void signUpButtonOnClick(ActionEvent event) {
        System.out.println("SignOut");
    }
    
}
