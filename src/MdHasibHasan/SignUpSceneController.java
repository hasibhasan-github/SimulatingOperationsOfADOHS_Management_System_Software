/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan;

import AbdullahAlMamun.SecurityCheif;
import MdHasibHasan.CantonmentBoardMember.CantonmentBoardMember;
import MdHasibHasan.CantonmentBoardMember.dohsPolicies;
import MdHasibHasan.DummyUser.Resident;
import MdHasibHasan.MaintenanceOfficer.MaintainenceOfficer;
import MdMasumBilla.accountsAndFinanceOfficer;
import MdMasumBilla.realEstateAgent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class SignUpSceneController implements Initializable {

    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private ListView<String> userList;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private RadioButton maleRadioBtn;
    @FXML
    private RadioButton femaleRadioBtn;
    @FXML
    private DatePicker dateOfBirth;
    @FXML
    private TextField contactNoTextField;
    @FXML
    private ComboBox<String> userDesignationComboBox;
    @FXML
    private ComboBox<String> userDepartmentComboBox;
    @FXML
    private TextField salaryTextField;
    @FXML
    private DatePicker dateOfJoin;
    @FXML
    private PasswordField signUpPasswordField;
    @FXML
    private CheckBox termsAndPoliciesCheckBox;
    @FXML
    private TextArea termsAndPoliciesTextArea;
    @FXML
    private TextField plotNoTextField;
    @FXML
    private TextField holdingOrFlatNoTextField;
    @FXML
    private ComboBox<String> militaryRankComboBox;
    @FXML
    private Button submitButton;
    @FXML
    private Label emailErrorLabel;
    @FXML
    private Label passwordErrorLabel;
    
    private ToggleGroup tg;
    
    private ObservableList<dohsPolicies> policyListOfDohs;
    @FXML
    private Button goBackButton;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tg = new ToggleGroup();
        maleRadioBtn.setToggleGroup(tg);
        femaleRadioBtn.setToggleGroup(tg);
        
        userTypeComboBox.getItems().addAll("Cantonment Board Member","Resident", "Employee");
        userList.getItems().addAll("Maintenance Officer", "Cantonment Board Member",
                                    " Accounts & Finance Officer", "Utility Service Provider",
                                    "Security Officer", "Real Estate Agent");
        userList.setDisable(true);
        
        militaryRankComboBox.getItems().addAll("Major", "Lt. Colonel", "Colonel", "Brigadier",
                                    "Brigadier General","Major General", "Lt. General", "Army Chief");
        militaryRankComboBox.setDisable(true);
        userList.setDisable(true);
        
        userDepartmentComboBox.getItems().addAll("Maintenance", "Human Resource Management", "Accounts & Finance",
                                            "Security", "Utility", "Real Estate");
        
        userDesignationComboBox.getItems().addAll("Department Head", "Associate Department Head", 
                            "Senior Executive", "Executive", "Junior Executive", "Agent");
             
        submitButton.setDisable(true);
        termsAndPoliciesCheckBox.setDisable(true);
        dateOfJoin.setDisable(true);
        salaryTextField.setDisable(true);
        userDepartmentComboBox.setDisable(true);
        userDesignationComboBox.setDisable(true);    
        
        dohsPolicies dummyInstance = new dohsPolicies("", LocalDate.of(2023, 02, 02),
                                                LocalDate.of(2023, 02, 02), new ArrayList<String>());
        policyListOfDohs = (ObservableList<dohsPolicies>) DataReadWrite.readObjectToFile("DOHSPOLICIES.bin", dummyInstance);
        for ( dohsPolicies policyData : policyListOfDohs ){
            termsAndPoliciesTextArea.appendText(policyData.getPolicyName() + "\n");
            for ( int i = 0; i < policyData.getPolicyDescription().size(); ++i ){
                termsAndPoliciesTextArea.appendText(policyData.getPolicyDescription().get(i)+"\n");
            }
        }
    }    

    @FXML
    private void userTypeSelectionOnAction(ActionEvent event) {
        if(userTypeComboBox.getValue().equals("Resident") ||
           userTypeComboBox.getValue().equals("Cantonment Board Member") ) userList.setDisable(true);
        // else userList.setDisable(false);
        
        if (userTypeComboBox.getValue().equals("Cantonment Board Member")) militaryRankComboBox.setDisable(false);
        else militaryRankComboBox.setDisable(true);
       
        if(userTypeComboBox.getValue().equals("Resident")){
            submitButton.setDisable(false);
            termsAndPoliciesCheckBox.setDisable(false);
        }
        else{
            submitButton.setDisable(true);
            termsAndPoliciesCheckBox.setDisable(true);   
        }
    }
    
    private int generateInteger(String name){
        CustomRandom customrandom = new CustomRandom();
        
        int random = customrandom.nextInt(111111, 899999);
        char character;
        character = name.charAt(0);
        
        int id = character;
        id *= 2;
        id += random;
        return id;
    }

    @FXML
    private void submitOnClickButton(ActionEvent event) {
        
        if ( termsAndPoliciesCheckBox.isSelected() && userTypeComboBox.getValue().equals("Resident") ){
            try{
                // Gender Selection
                String gender;
                if (maleRadioBtn.isSelected()) gender = "Male";
                else gender = "Female";
                //GenerateInteger Id
                int id = generateInteger(emailTextField.getText());
                                
                if(GenerateAlerts.confirmationAlert()){
                    Resident people  = new Resident(plotNoTextField.getText(), holdingOrFlatNoTextField.getText(),
                                                    id, nameTextField.getText(), gender, emailTextField.getText(), 
                                                    userTypeComboBox.getValue(), dateOfBirth.getValue(), 
                                                Long.parseLong(contactNoTextField.getText()) );
                    ///  System.out.println(people.toString() + " " + people.toStringM());
                    /* MaintainenceOfficer ms = new MaintainenceOfficer(dateOfJoin.getValue(), Float.parseFloat(salaryTextField.getText()),
                                userDepartmentComboBox.getValue(), userDesignationComboBox.getValue(), id, nameTextField.getText(),
                                gender, emailTextField.getText(), userList.getSelectionModel().getSelectedItem(), dateOfBirth.getValue(),
                                Long.parseLong(contactNoTextField.getText())); */
                    signUpData loginData = new signUpData(id, emailTextField.getText(), 
                                    signUpPasswordField.getText(), userTypeComboBox.getValue());
                    GenerateAlerts.successfulAlert("Registration Successful.\n" + 
                                                    "You DOHS user id is: " + id);
                    // boolean hasib = DataReadWrite.writeObjectToFile("Resident.bin", people);
                    DataReadWrite.writeObjectToFile("Resident.bin", people);
                    // DataReadWrite.readObjectToFile("Resident.bin", people);
                    DataReadWrite.writeObjectToFile("LoginData.bin", loginData);
                    // DataReadWrite.readObjectToFile("LoginData.bin", loginData);
                    holdingOrFlatNoTextField.clear();
                    plotNoTextField.clear();
                    nameTextField.clear();
                    emailTextField.clear();
                    contactNoTextField.clear();
                    //userTypeComboBox.setValue(null);
                    dateOfBirth.setValue(null);
                    signUpPasswordField.clear();
                }
            }
            catch (Exception e){
                GenerateAlerts.unsuccessfulAlert("Please check your given Information." + 
                                                "Then Try Again.");
            }
        }
        else if ( termsAndPoliciesCheckBox.isSelected() && userList.getSelectionModel().isSelected(0) ){
            try{
                registerForMaintenanceOfficer();
                }
            catch(Exception e){
            GenerateAlerts.unsuccessfulAlert("Please check your given Information." + 
                                                "Then Try Again.");
            }
        }
        else if ( termsAndPoliciesCheckBox.isSelected() && userList.getSelectionModel().isSelected(1) ){
            try{
                registerCantonmentBoardMember();
                }
            catch(Exception e){
            GenerateAlerts.unsuccessfulAlert("Please check your given Information." + 
                                                "Then Try Again.");
            }
        }
        else if ( termsAndPoliciesCheckBox.isSelected() && userList.getSelectionModel().isSelected(2) ){
            try{
                registerAccountsAndFinanceOfficer();
                }
            catch(Exception e){
            GenerateAlerts.unsuccessfulAlert("Please check your given Information." + 
                                                "Then Try Again.");
            }
        }
        else if ( termsAndPoliciesCheckBox.isSelected() && userList.getSelectionModel().isSelected(3) ){
            try{
                // registerAccountsAndFinanceOfficer(); // Another
                }
            catch(Exception e){
            GenerateAlerts.unsuccessfulAlert("Please check your given Information." + 
                                                "Then Try Again.");
            }
        }
        else if ( termsAndPoliciesCheckBox.isSelected() && userList.getSelectionModel().isSelected(4) ){
            try{
               registerSecurityChief();
                }
            catch(Exception e){
            GenerateAlerts.unsuccessfulAlert("Please check your given Information." + 
                                                "Then Try Again.");
            }
        }
        else if ( termsAndPoliciesCheckBox.isSelected() && userList.getSelectionModel().isSelected(5) ){
            try{
                registerRealEstateAgent();
                }
            catch(Exception e){
            GenerateAlerts.unsuccessfulAlert("Please check your given Information." + 
                                                "Then Try Again.");
            }
        }
    }

    
    @FXML
    private void goBackOnClickButton(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage,"/simulatingoperationsofdohs_management_system_software/login.fxml" );
    }

    @FXML
    private void checkBoxButtonOnSelect(ActionEvent event) {
        // Email, Password and Age Validation
        String emailOrId, pass;
        emailOrId = emailTextField.getText().trim();
        pass = signUpPasswordField.getText();
        loginValidationAndVerification.validationProcessOfData(emailOrId, pass, emailErrorLabel, emailTextField, passwordErrorLabel, signUpPasswordField);
        
        if ((loginValidationAndVerification.isValidEmail(emailOrId) && loginValidationAndVerification.isValidPassword(pass))
                && loginValidationAndVerification.isValidBirthDate(dateOfBirth.getValue())){
            submitButton.setDisable(false);
        }
        else{
            submitButton.setDisable(true);
            GenerateAlerts.unsuccessfulAlert("Invalid Email or Password." + 
                                            "You must be at least 18 years old.");
            termsAndPoliciesCheckBox.setSelected(false);
        }
        
        signUpData sud = new signUpData(0,"e", "p", "u");
        ObservableList<signUpData> loginInfo = (ObservableList<signUpData>) DataReadWrite.readObjectToFile("LoginData.bin", sud);
        try{         
            for ( signUpData data : loginInfo ){
                if ( data.getEmail().equals(emailTextField.getText())){
                    throw new Exception("Email already exists");
                }
            }
        }
        catch(Exception e){
            GenerateAlerts.unsuccessfulAlert("Email already exists");
            termsAndPoliciesCheckBox.setSelected(false);
        }
        
    }

    @FXML
    private void emailTextFieldOnKeyPressed(KeyEvent event) {
        emailErrorLabel.setVisible(false);
        emailTextField.setStyle("-fx-border-color: transparent;");
    }

    @FXML
    private void passwordFieldOnKeyPressed(KeyEvent event) {
        passwordErrorLabel.setVisible(false);
        signUpPasswordField.setStyle("-fx-border-color: transparent;");
    }
    
    public void helperOfDataPassing(signUpData data, String userName){
        if ( data instanceof signUpData && userName.equals("Maintainance") ){
            userTypeComboBox.setDisable(true);
            userTypeComboBox.setValue("Employee");
            userList.setDisable(false);
            dateOfJoin.setDisable(false);
            salaryTextField.setDisable(false);
            userDepartmentComboBox.setDisable(false);
            userDesignationComboBox.setDisable(false);
            militaryRankComboBox.setDisable(false);
            goBackButton.setDisable(true);
            submitButton.setDisable(false);
            termsAndPoliciesCheckBox.setDisable(false);
            holdingOrFlatNoTextField.setDisable(true);
            plotNoTextField.setDisable(true);
        }
    }
    
    
    private void registerForMaintenanceOfficer(){
        // Gender Selection
        String gender;
        if (maleRadioBtn.isSelected()) gender = "Male";
        else gender = "Female";
        //GenerateInteger Id
        int id = generateInteger(emailTextField.getText());
        MaintainenceOfficer ms = new MaintainenceOfficer(dateOfJoin.getValue(), Float.parseFloat(salaryTextField.getText()),
                    userDepartmentComboBox.getValue(), userDesignationComboBox.getValue(), id, nameTextField.getText(),
                        gender, emailTextField.getText(), userList.getSelectionModel().getSelectedItem(), dateOfBirth.getValue(),
                Long.parseLong(contactNoTextField.getText()));
        signUpData loginData = new signUpData(id, emailTextField.getText(), 
                 signUpPasswordField.getText(), userList.getSelectionModel().getSelectedItem());
        
        MaintainenceOfficer.regsiterNewUser(ms, loginData, "MaintenanceDepartment.bin", id);
        
        holdingOrFlatNoTextField.clear();
        plotNoTextField.clear();
        nameTextField.clear();
        emailTextField.clear();
        contactNoTextField.clear();
        //userTypeComboBox.setValue(null);
        dateOfBirth.setValue(null);
        signUpPasswordField.clear();
    }
    
    private void registerAccountsAndFinanceOfficer(){
        // Gender Selection
        String gender;
        if (maleRadioBtn.isSelected()) gender = "Male";
        else gender = "Female";
        //GenerateInteger Id
        int id = generateInteger(emailTextField.getText());
        accountsAndFinanceOfficer ms = new accountsAndFinanceOfficer(dateOfJoin.getValue(), Float.parseFloat(salaryTextField.getText()),
                    userDepartmentComboBox.getValue(), userDesignationComboBox.getValue(), id, nameTextField.getText(),
                        gender, emailTextField.getText(), userList.getSelectionModel().getSelectedItem(), dateOfBirth.getValue(),
                Long.parseLong(contactNoTextField.getText()));
        signUpData loginData = new signUpData(id, emailTextField.getText(), 
                 signUpPasswordField.getText(), userList.getSelectionModel().getSelectedItem());
        
        MaintainenceOfficer.regsiterNewUser(ms, loginData, "AccountsAndFinanceOfficer.bin", id);
        
        holdingOrFlatNoTextField.clear();
        plotNoTextField.clear();
        nameTextField.clear();
        emailTextField.clear();
        contactNoTextField.clear();
        //userTypeComboBox.setValue(null);
        dateOfBirth.setValue(null);
        signUpPasswordField.clear();
    }
    
    
    private void registerRealEstateAgent(){
        // Gender Selection
        String gender;
        if (maleRadioBtn.isSelected()) gender = "Male";
        else gender = "Female";
        //GenerateInteger Id
        int id = generateInteger(emailTextField.getText());
        realEstateAgent ms = new realEstateAgent(dateOfJoin.getValue(), Float.parseFloat(salaryTextField.getText()),
                    userDepartmentComboBox.getValue(), userDesignationComboBox.getValue(), id, nameTextField.getText(),
                        gender, emailTextField.getText(), userList.getSelectionModel().getSelectedItem(), dateOfBirth.getValue(),
                Long.parseLong(contactNoTextField.getText()));
        signUpData loginData = new signUpData(id, emailTextField.getText(), 
                 signUpPasswordField.getText(), userList.getSelectionModel().getSelectedItem());
        
        MaintainenceOfficer.regsiterNewUser(ms, loginData, "RealEstateAgent.bin", id);
        
        holdingOrFlatNoTextField.clear();
        plotNoTextField.clear();
        nameTextField.clear();
        emailTextField.clear();
        contactNoTextField.clear();
        //userTypeComboBox.setValue(null);
        dateOfBirth.setValue(null);
        signUpPasswordField.clear();
    }
    
    private void registerSecurityChief(){
        // Gender Selection
        String gender;
        if (maleRadioBtn.isSelected()) gender = "Male";
        else gender = "Female";
        //GenerateInteger Id
        int id = generateInteger(emailTextField.getText());
        SecurityCheif ms = new SecurityCheif(dateOfJoin.getValue(), Float.parseFloat(salaryTextField.getText()),
                    userDepartmentComboBox.getValue(), userDesignationComboBox.getValue(), id, nameTextField.getText(),
                        gender, emailTextField.getText(), userList.getSelectionModel().getSelectedItem(), dateOfBirth.getValue(),
                Long.parseLong(contactNoTextField.getText()));
        signUpData loginData = new signUpData(id, emailTextField.getText(), 
                 signUpPasswordField.getText(), userList.getSelectionModel().getSelectedItem());
        
        MaintainenceOfficer.regsiterNewUser(ms, loginData, "SecurityDepartment.bin", id);
        
        holdingOrFlatNoTextField.clear();
        plotNoTextField.clear();
        nameTextField.clear();
        emailTextField.clear();
        contactNoTextField.clear();
        //userTypeComboBox.setValue(null);
        dateOfBirth.setValue(null);
        signUpPasswordField.clear();
    }
    // SecurityCheif
    
    private void registerCantonmentBoardMember(){
        // Gender Selection
        String gender;
        if (maleRadioBtn.isSelected()) gender = "Male";
        else gender = "Female";
        //GenerateInteger Id
        int id = generateInteger(emailTextField.getText());
        CantonmentBoardMember CNB  = new CantonmentBoardMember(militaryRankComboBox.getValue(),
                            id, nameTextField.getText(), gender, emailTextField.getText(), 
                        userList.getSelectionModel().getSelectedItem(), dateOfBirth.getValue(), 
                        Long.parseLong(contactNoTextField.getText()) );
        signUpData loginData = new signUpData(id, emailTextField.getText(), 
                 signUpPasswordField.getText(), userList.getSelectionModel().getSelectedItem());
        
        MaintainenceOfficer.regsiterNewUser(CNB, loginData, "CantonmentBoardMember.bin", id);
        
        holdingOrFlatNoTextField.clear();
        plotNoTextField.clear();
        nameTextField.clear();
        emailTextField.clear();
        contactNoTextField.clear();
        //userTypeComboBox.setValue(null);
        dateOfBirth.setValue(null);
        signUpPasswordField.clear();
    }
    
    
}