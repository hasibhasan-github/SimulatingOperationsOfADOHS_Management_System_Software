/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;


/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class CantonmentBoardMemberDashboardController implements Initializable {

    @FXML
    private BorderPane borderPaneId;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO 
        
    }    

    @FXML
    private void policyAndGuidelinesOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("dohsPolicies.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void goToLogOutSceneOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("logOutScene.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void seeFullMapButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void developementPlanAndProjectsButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("DevelopmentPalnsAndProjects.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void dohsDetailsMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("DOHSDetails.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void pendingPermissionMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("permissionRequestScene.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void permissionAnalysisDataMenuItemOnClick(ActionEvent event) {
    }

    @FXML
    private void votingMenuItemOnSelect(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("VotingScene.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void sendNoticeMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("sendNoticceScene.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void securityDepartmentMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("reportFromSecurity.fxml"));
        borderPaneId.setCenter(parent);
    }

    @FXML
    private void maintenaceDeptMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("reportViewFromMaintenance.fxml"));
        borderPaneId.setCenter(parent);
    }


    
}
