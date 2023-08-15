/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package simulatingoperationsofdohs_management_system_software;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.DummyUser.ResidentDashboardController;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.loginValidationAndVerification;
import MdHasibHasan.sceneChanging;
import MdHasibHasan.signUpData;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private ComboBox<String> selectUserComboBox;
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
        selectUserComboBox.getItems().addAll("Cantonment Board Member","Resident",
                                        "Maintenance Officer", "Human Resource Management Officer",
                                    " Accounts & Finance Officer", "Utility Service Officer",
                                    "Security Officer", "Real Estate Agent");
    }    

    @FXML
    private void visitorButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/AbdullahAlMamun/VisitorSignUp.fxml");
        
    }

    @FXML
    private void aboutButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void contactButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void signInButtonOnClick(ActionEvent event) {
        /// System.out.println("SignIn");
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        sceneChanging newwscene = new sceneChanging();
        
        String emailOrId, pass;
        int loginUsingId = 0;
        try{
            loginUsingId = Integer.parseInt(emailOrIdTextField.getText());
        }
        catch (Exception e){
            // catch occurs if the field contain email.
        }
        emailOrId = emailOrIdTextField.getText().trim();
        pass = passwordField.getText();
        boolean validationCheck = loginValidationAndVerification.validationProcessOfData(emailOrId, pass, emailErrorLabel, emailOrIdTextField, passwordErrorLabel, passwordField);
        if (validationCheck){
            boolean flag = false;
            ObservableList<signUpData> loginInfo = FXCollections.observableArrayList();
            signUpData sud = new signUpData(0,"e", "p", "u");
            loginInfo = (ObservableList<signUpData>) DataReadWrite.readObjectToFile("LoginData.bin", sud);
            try{  // AccountOfficerDashBoard
                for ( signUpData tmp : loginInfo ){
                if ( tmp.getUserType().equals("Maintenance Officer") && ( tmp.getPassword().equals(pass) && (tmp.getEmail().equals(emailOrId) || tmp.getId() == (loginUsingId) ) )){
                    newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/MaintenanceOfficerDashboard.fxml");
                    flag = true;
                }
                else if ( tmp.getUserType().equals(" Accounts & Finance Officer") && ( tmp.getPassword().equals(pass) && (tmp.getEmail().equals(emailOrId) || tmp.getId() == (loginUsingId) ) )){
                    newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdMasumBilla/AccountOfficerDashBoard.fxml");
                    flag = true;
                }
                else if ( tmp.getUserType().equals("Real Estate Agent") && ( tmp.getPassword().equals(pass) && (tmp.getEmail().equals(emailOrId) || tmp.getId() == (loginUsingId) ) )){
                    newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdMasumBilla/realEstateAgentDashboard.fxml");
                    flag = true;
                }
                else if ( tmp.getUserType().equals("Resident") && ( tmp.getPassword().equals(pass) && (tmp.getEmail().equals(emailOrId) || tmp.getId() == (loginUsingId) ) )){
                    newwscene.sceneSwitchingWithDataPassing(stage, "/MdHasibHasan/DummyUser/ResidentDashboard.fxml", "Resident", tmp);
                    flag = true;
                }
            }
          }
            catch (IOException e){
                GenerateAlerts.unsuccessfulAlert("System Error!" + "\n" + "Please contact with Maintenance Department.");
            }
            if ( !flag ){
                GenerateAlerts.unsuccessfulAlert("No user Found with the Domain.");
            }
        }
        
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
        boolean validationCheck = loginValidationAndVerification.validationProcessOfData(emailOrId, pass, emailErrorLabel, emailOrIdTextField, passwordErrorLabel, passwordField);
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

    @FXML
    private void selectUserComboBoxOnClick(ActionEvent event) {
        if (selectUserComboBox.getValue() != null ) selectUserComboBox.setStyle("-fx-background-color: white;");
    }
    
}
