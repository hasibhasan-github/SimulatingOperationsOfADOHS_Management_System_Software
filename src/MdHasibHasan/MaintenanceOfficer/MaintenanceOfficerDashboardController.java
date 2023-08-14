/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class MaintenanceOfficerDashboardController implements Initializable {

    @FXML
    private TableView<carStickerRequest> tableViewMaintainenceOfficer;
    @FXML
    private TableColumn<carStickerRequest, Integer> idColoumn;
    @FXML
    private TableColumn<carStickerRequest, String> emailColoumn;
    @FXML
    private TableColumn<carStickerRequest, String> applicationStatusColoumn;
    @FXML
    private TableColumn<carStickerRequest, String> paymentStatusColoumn;
    
    private ObservableList<carStickerRequest> tableDataOfCarStickerRequest;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        idColoumn.setCellValueFactory(new PropertyValueFactory<carStickerRequest, Integer>("id"));
        emailColoumn.setCellValueFactory(new PropertyValueFactory<carStickerRequest, String>("email"));
        paymentStatusColoumn.setCellValueFactory(new PropertyValueFactory<carStickerRequest, String>("paymentStatus"));
        applicationStatusColoumn.setCellValueFactory(new PropertyValueFactory<carStickerRequest, String>("applicationStatus"));
        
    }    

    @FXML
    private void loadCarStickerRequestDetailsOnClick(ActionEvent event) {
        carStickerRequest requestSticker = new carStickerRequest(0,"","","");
        
        tableDataOfCarStickerRequest = (ObservableList<carStickerRequest>) DataReadWrite.readObjectToFile("CarStickerRequestData.bin", requestSticker);
        
        tableViewMaintainenceOfficer.getItems().addAll(tableDataOfCarStickerRequest);
    }

    @FXML
    private void updateCarStickerRequestDetailsOnClick(ActionEvent event) {
        carStickerRequest giveApproval =tableViewMaintainenceOfficer.getSelectionModel().getSelectedItem();
        
        tableViewMaintainenceOfficer.getSelectionModel().isSelected(0);
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/simulatingoperationsofdohs_management_system_software/login.fxml");
        GenerateAlerts.successfulAlert("Have good day!" + "\n" + "Please visit Again");
    }

    @FXML
    private void approveButtonOnClick(ActionEvent event) {
        System.out.println(tableViewMaintainenceOfficer.getSelectionModel().isSelected(0));
        carStickerRequest giveApproval =tableViewMaintainenceOfficer.getSelectionModel().getSelectedItem();
        giveApproval.setApplicationStatus("Accepted");
    }
    
}
