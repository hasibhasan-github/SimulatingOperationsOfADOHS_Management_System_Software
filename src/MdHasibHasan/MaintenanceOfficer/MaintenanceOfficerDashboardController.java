/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.CantonmentBoardMember.loadResidentData;
import MdHasibHasan.DataReadWrite;
import MdHasibHasan.DummyUser.Resident;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.sceneChanging;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
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
    @FXML
    private TextArea policyTextArea;
    @FXML
    private TextArea notificationTextArea;
    @FXML
    private TextArea experienceTextArea;

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
        
        carStickerRequest requestSticker = new carStickerRequest(0,"","","");
        tableDataOfCarStickerRequest = (ObservableList<carStickerRequest>) DataReadWrite.readObjectToFile("CarStickerRequestData.bin", requestSticker);
        tableViewMaintainenceOfficer.getItems().addAll(tableDataOfCarStickerRequest);
        
        experienceTextArea.setText("Experienced department head with a decade of hands-on leadership in maintenance operations.\n"
                             + "Proven track record in optimizing equipment performance, fostering team efficiency, and implementing cost-effective maintenance strategies.\n " +
                               "Adept at ensuring facility functionality and enhancing operational effectiveness");
        
    }    

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/simulatingoperationsofdohs_management_system_software/login.fxml");
        GenerateAlerts.successfulAlert("Have a good day!" + "\n" + "Please visit Again");
    }

    @FXML
    private void approveButtonOnClick(ActionEvent event) {
        carStickerRequest giveApproval =tableViewMaintainenceOfficer.getSelectionModel().getSelectedItem();
        if ( tableViewMaintainenceOfficer.getSelectionModel().isSelected(0)) GenerateAlerts.successfulAlert("Please Select Table Item.");
        // Clearing table data list
        tableViewMaintainenceOfficer.getItems().clear();
        // Approving Car Sticker Request by model class static method.
        tableViewMaintainenceOfficer.getItems().addAll(MaintainenceOfficer.approveCarStickerRequest(tableDataOfCarStickerRequest, giveApproval));
    }
    
}
