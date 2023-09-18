/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.DummyUser.Resident;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.sceneChanging;
import MdHasibHasan.signUpData;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */

public class DohsSoftwareSystemController implements Initializable {

    @FXML
    private TableView<signUpData> allEmployeeAndCMBTableView;
    @FXML
    private TableColumn<signUpData, Integer> idTableColoumn;
    @FXML
    private TableColumn<signUpData, String> emailTableColoumn;
    @FXML
    private TableColumn<signUpData, String> passwordTableColoumn;
    @FXML
    private TableColumn<signUpData, String> userTypeTableColoumn;
    
    private ObservableList<signUpData> loginInfo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loginInfo = FXCollections.observableArrayList();
        emailTableColoumn.setCellValueFactory(new PropertyValueFactory<signUpData, String>("email"));
        idTableColoumn.setCellValueFactory(new PropertyValueFactory<signUpData, Integer>("id"));
        passwordTableColoumn.setCellValueFactory(new PropertyValueFactory<signUpData, String>("password"));
        userTypeTableColoumn.setCellValueFactory(new PropertyValueFactory<signUpData, String>("userType"));
        
        readAllDataFromFile();
        for ( signUpData data : loginInfo ){
            data.setPassword("******");
        }
        
        allEmployeeAndCMBTableView.getItems().addAll(loginInfo);
    }

    private void readAllDataFromFile(){
        signUpData sud = new signUpData(0,"e", "p", "u");
        loginInfo = (ObservableList<signUpData>) DataReadWrite.readObjectToFile("LoginData.bin", sud);
    }

    @FXML
    private void registerButtonOnClick(ActionEvent event) throws IOException {
        signUpData sud = new signUpData(0,"e", "p", "u");
        sceneChanging newwscene = new sceneChanging();
        newwscene.windowSwitchingWithDataPassing( "/MdHasibHasan/signUpScene.fxml", "Maintainance", sud);
    }

    @FXML
    private void deleteButtonOnClick(ActionEvent event) {
        //
        if ( GenerateAlerts.confirmationAlert() ) { 
            try{
                loginInfo.clear();
                readAllDataFromFile();
                ObservableList<signUpData> newLoginInfo = MaintainenceOfficer.deleteDOHSSoftwareUser(loginInfo, allEmployeeAndCMBTableView.getSelectionModel().getSelectedItem());
                allEmployeeAndCMBTableView.getItems().clear();
                allEmployeeAndCMBTableView.getItems().addAll(newLoginInfo);
            }
            catch (Exception e){
                GenerateAlerts.unsuccessfulAlert("Please select the user from Table to Delete.");
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
