/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private ComboBox<?> userDesignationComboBox;
    @FXML
    private ComboBox<?> userDepartmentComboBox;
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
    private ComboBox<?> militaryRankComboBox;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userTypeComboBox.getItems().addAll("Cantonment Board Member","Resident", "Employee");
        userList.getItems().addAll("Maintenance Officer", "Human Resource Manager",
                                    " Accounts & Finance Officer", "Utility Service Manager",
                                    "Security Chief", "Real Estate Agent");
        userList.setDisable(true);
    }    

    @FXML
    private void userTypeSelectionOnAction(ActionEvent event) {
        if(userTypeComboBox.getValue().equals("Resident") ||
           userTypeComboBox.getValue().equals("Cantonment Board Member") ) userList.setDisable(true);
        else userList.setDisable(false);
    }

    @FXML
    private void submitOnClickButton(ActionEvent event) {
        // String str = userList.getSelectionModel().getSelectedItem();
        System.out.println(userList.getSelectionModel().getSelectedItem());
    }

    @FXML
    private void goBackOnClickButton(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage,"/simulatingoperationsofdohs_management_system_software/login.fxml" );
    }
    
}
