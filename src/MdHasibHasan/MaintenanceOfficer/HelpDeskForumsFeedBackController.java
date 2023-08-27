/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class HelpDeskForumsFeedBackController implements Initializable {

    @FXML
    private TextField contactNoTxtField;
    @FXML
    private TextField nameTxtField;
    @FXML
    private TextField subjectTxtField;
    @FXML
    private TextArea descriptionTxtField;
    @FXML
    private TextField userTypeTxtField;
    
    private ObservableList<SupportForum> listDataForum;
    @FXML
    private ComboBox<String> forumComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        listDataForum = FXCollections.observableArrayList();
        listDataForum = MaintainenceOfficer.viewSubmitForumResponses();
        
        for ( SupportForum dataForum : listDataForum ){
            forumComboBox.getItems().add(dataForum.getSubject());
        }
        
    }    
    

    @FXML
    private void selectForumComboBoxOnAction(ActionEvent event) {
        for ( SupportForum dataForum : listDataForum ){
            if ( forumComboBox.getValue().equals(dataForum.getSubject()) ){
                contactNoTxtField.setText(dataForum.getContactNo());
                nameTxtField.setText(dataForum.getName());
                subjectTxtField.setText(dataForum.getSubject());
                userTypeTxtField.setText(dataForum.getUserType());
                descriptionTxtField.clear();
                String[] parts = dataForum.getDescription().split("\\.");
                for (String part : parts) {
                    descriptionTxtField.appendText(part + "\n");
                }
            }
        }
        
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/MaintenanceOfficerDashboard.fxml");
        
    }
    
}
