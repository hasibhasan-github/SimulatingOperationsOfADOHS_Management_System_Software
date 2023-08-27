/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Abdullah.UtilityServiceManager;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class UtilityServiceManagerDashboardController implements Initializable {

    @FXML
    private BorderPane UtilityServiceManagerBorderPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void serviceProvidersPortalMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("ServiceProvidersPortal.fxml"));
        UtilityServiceManagerBorderPane.setCenter(parent);
    }

    @FXML
    private void logOutMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("LogOutScence.fxml"));
        UtilityServiceManagerBorderPane.setCenter(parent);
    }

    @FXML
    private void residentPortalMenuItemOnClick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("UtilitySereviceManagerResidentPortal.fxml"));
        UtilityServiceManagerBorderPane.setCenter(parent);
    }

    @FXML
    private void generateReportMenuItemOnclick(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("UtilityReport.fxml"));
        UtilityServiceManagerBorderPane.setCenter(parent);
    }
    
}
