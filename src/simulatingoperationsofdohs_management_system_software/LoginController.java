/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package simulatingoperationsofdohs_management_system_software;

import MdHasibHasan.loginValidationAndVerification;
import MdHasibHasan.sceneChanging;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label emailErrorLabel;
    @FXML
    private Label passwordErrorLabel;

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
    private void signUpButtonOnClick(ActionEvent event) throws IOException {
        System.out.println("SignOut");
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/signUpScene.fxml");
    }

    @FXML
    private void signInValidation(MouseEvent event) {
        String emailOrId, pass;
        emailOrId = emailOrIdTextField.getText().trim();
        pass = passwordField.getText();
        loginValidationAndVerification.validationProcessOfData(emailOrId, pass, emailErrorLabel, emailOrIdTextField, passwordErrorLabel, passwordField);
        
    }

    @FXML
    private void emailOrIdLabelOnKeyDataEntry(KeyEvent event) {
        emailErrorLabel.setVisible(false);
        emailOrIdTextField.setStyle("-fx-border-color: transparent;");
    }

    @FXML
    private void passwordFieldOnKeyDataEntry(KeyEvent event) {
        passwordErrorLabel.setVisible(false);
        passwordField.setStyle("-fx-border-color: transparent;");
    }
    
}
