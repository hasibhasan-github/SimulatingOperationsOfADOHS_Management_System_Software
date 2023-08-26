/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AbdullahAlMamun;

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
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class SecurityCheifDashboardController implements Initializable {

    private MenuBar dashboardBoerderPane;
    @FXML
    private BorderPane dashboardBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void visitorRequestButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("GrantVisitorAccess.fxml"));
        dashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void monthlyReportButtonOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ViewReport.fxml"));
        dashboardBorderPane.setCenter(parent);
    }

    @FXML
    private void checkPointButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void residentPortalButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void sugestCandidateButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void gatePassButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logoutButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        newwscene.logOutSceneSwitching(stage);
    }

    @FXML
    private void DummyHasibSceneOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("DummyHasib.fxml"));
        dashboardBorderPane.setCenter(parent);
    }
    
}
