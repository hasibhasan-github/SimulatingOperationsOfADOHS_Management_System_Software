/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.CantonmentBoardMember.dohsPolicies;
import MdHasibHasan.CantonmentBoardMember.loadResidentData;
import MdHasibHasan.DataReadWrite;
import MdHasibHasan.DummyUser.Resident;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.sceneChanging;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
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
    
    private ObservableList<dohsPolicies> policyListOfDohs;
    
    @FXML
    private TableView<maintenanceFee> maintenanceFeeTableView;
    @FXML
    private TableColumn<maintenanceFee, String> emailTableColumn;
    @FXML
    private TableColumn<maintenanceFee, Integer> idlTableColumn;
    @FXML
    private TableColumn<maintenanceFee, Float> maintenanceFeeTableColumn;
    @FXML
    private TableColumn<maintenanceFee, Boolean> paymentStatusTableColumn;
    @FXML
    private TableColumn<maintenanceFee, String> monthTableColumn;
    @FXML
    private TableColumn<maintenanceFee, String> yearTableColoumn;
    
    private ObservableList<maintenanceFee> feeList;
    @FXML
    private ComboBox<String> selectMonthComboBox;
    @FXML
    private ComboBox<String> selectYearComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initializing The Table for Car Sticker.
        idColoumn.setCellValueFactory(new PropertyValueFactory<carStickerRequest, Integer>("id"));
        emailColoumn.setCellValueFactory(new PropertyValueFactory<carStickerRequest, String>("email"));
        paymentStatusColoumn.setCellValueFactory(new PropertyValueFactory<carStickerRequest, String>("paymentStatus"));
        applicationStatusColoumn.setCellValueFactory(new PropertyValueFactory<carStickerRequest, String>("applicationStatus"));
        // Initializing The Table for Car Sticker. 
        
        // Creating Dummy Instance ofcarStickerRequest.
        carStickerRequest requestSticker = new carStickerRequest(0,"","","");
        // Reading Data From File.
        tableDataOfCarStickerRequest = (ObservableList<carStickerRequest>) DataReadWrite.readObjectToFile("CarStickerRequestData.bin", requestSticker);
        // Adding the data of carStickerRequest to the tableViewMaintainenceOfficer.
        tableViewMaintainenceOfficer.getItems().addAll(tableDataOfCarStickerRequest);
        
        // Maintenece Department Head Experience.
        experienceTextArea.setText("Experienced department head with a decade of hands-on leadership in maintenance operations.\n"
                             + "Proven track record in optimizing equipment performance, fostering team efficiency, and implementing cost-effective maintenance strategies.\n " +
                               "Adept at ensuring facility functionality and enhancing operational effectiveness");
        // Maintenece Department Head Experience.
        
        // Creating Dummy Instance of dohsPolicies.
        dohsPolicies dummyInstance = new dohsPolicies("", LocalDate.of(2023, 02, 02),
                                                LocalDate.of(2023, 02, 02), new ArrayList<String>());
        // Creating Dummy Instance of dohsPolicies.
        
        // Reading data from DOHSPOLICIES.bin file.
        policyListOfDohs = (ObservableList<dohsPolicies>) DataReadWrite.readObjectToFile("DOHSPOLICIES.bin", dummyInstance);
        // Reading data from DOHSPOLICIES.bin file.
        
        // Showing the Policies in policyTextArea.
        for ( dohsPolicies policyData : policyListOfDohs ){
            policyTextArea.appendText(policyData.getPolicyName() + "\n");
            for ( int i = 0; i < policyData.getPolicyDescription().size(); ++i ){
                policyTextArea.appendText(policyData.getPolicyDescription().get(i)+"\n");
            }
        }
        // Showing the Policies in policyTextArea.
        
        // Initializing the Table for Maintenance Fee.
        emailTableColumn.setCellValueFactory(new PropertyValueFactory<maintenanceFee, String>("residentEmail"));
        idlTableColumn.setCellValueFactory(new PropertyValueFactory<maintenanceFee, Integer>("residentId"));
        monthTableColumn.setCellValueFactory(new PropertyValueFactory<maintenanceFee, String>("month"));
        yearTableColoumn.setCellValueFactory(new PropertyValueFactory<maintenanceFee, String>("year"));
        maintenanceFeeTableColumn.setCellValueFactory(new PropertyValueFactory<maintenanceFee, Float>("maintenanceFee"));
        paymentStatusTableColumn.setCellValueFactory(new PropertyValueFactory<maintenanceFee, Boolean>("paymentStatus"));
        // Initializing the Table for Maintenance Fee.
        
        // Initializing the Value of selectMonthComboBox and selectYearComboBox
        selectMonthComboBox.getItems().addAll("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December");
        selectYearComboBox.getItems().addAll("2023", "2024", "2025", "2026", "2027", "2028");
        // Initializing the Value of selectMonthComboBox and selectYearComboBox
        loadMaintenanceFeeDataList();

    }  
    
    private void loadMaintenanceFeeDataList(){
        maintenanceFee dummy = new maintenanceFee(0, "", "", "", false);
        feeList = (ObservableList<maintenanceFee>) DataReadWrite.readObjectToFile("MainteneceFee.bin", dummy);
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

    @FXML
    private void loadMaintenanceFeeDataButtonOnClick(ActionEvent event) {
        // Clearing the ObservableArrayList in maintenanceFeeTableView
        maintenanceFeeTableView.getItems().clear();
        // Reading the Data From MainteneceFee,bin File.
        loadMaintenanceFeeDataList();
        try{
            ObservableList<maintenanceFee> updatedFeeList = MaintainenceOfficer.collectAndViewMaintenanceFee(feeList, selectMonthComboBox.getValue(), selectYearComboBox.getValue());
            maintenanceFeeTableView.getItems().addAll(updatedFeeList);
        }
        catch(Exception e){
            GenerateAlerts.unsuccessfulAlert("Select the Combo Box Item.");
        }
    }
    
}
