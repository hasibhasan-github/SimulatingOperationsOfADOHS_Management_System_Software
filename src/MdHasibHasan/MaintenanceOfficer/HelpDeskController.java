/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */

public class HelpDeskController implements Initializable {

    @FXML
    private TextField nameTxtField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private TextField contactNoTxtField;
    @FXML
    private TextField subjectTxtField;
    @FXML
    private TextArea descriptionTxtArea;
    @FXML
    private Button submitForumButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        userTypeComboBox.getItems().addAll("Resident", "Employee", "Visitor");
        
    }    

    @FXML
    private void submitSupportForumButtonOnClick(ActionEvent event) {
        try{
            if ( descriptionTxtArea.getText().isEmpty() ) throw new RuntimeException ("Description Empty.");
            if ( subjectTxtField.getText().isEmpty() ) throw new RuntimeException ("Subject Empty.");
            if ( contactNoTxtField.getText().isEmpty() ) throw new RuntimeException ("Contact Empty.");
            if ( nameTxtField.getText().isEmpty() ) throw new RuntimeException ("Name Empty.");
            if ( userTypeComboBox.getValue() == null ) throw new RuntimeException ("Select ComboBox.");
            
            SupportForum newForum = new SupportForum(nameTxtField.getText(), userTypeComboBox.getValue(), contactNoTxtField.getText(),
                    subjectTxtField.getText(), descriptionTxtArea.getText());
            
            MaintainenceOfficer.getSubmitForumData(newForum);
            descriptionTxtArea.clear();
            subjectTxtField.clear();
            contactNoTxtField.clear();
            nameTxtField.clear();
            userTypeComboBox.setValue(null);
            submitForumButton.setDisable(true);
            
        }
        catch (RuntimeException ee){
            GenerateAlerts.unsuccessfulAlert(ee.toString());
        }
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newwscene.logOutSceneSwitching(stage);
    }
    
}
