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
    private TableView<loadResidentData> tableresident;
    @FXML
    private TableColumn<loadResidentData, String> nameTable;
    @FXML
    private TableColumn<loadResidentData, Integer> idTable;
    @FXML
    private TableColumn<loadResidentData, String> plotNoTable;
    @FXML
    private TableColumn<loadResidentData, String> ganderTable;
    @FXML
    private TableColumn<loadResidentData, String> holdingTable;
    @FXML
    private PieChart PieChart;
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
        
        idTable.setCellValueFactory(new PropertyValueFactory<loadResidentData, Integer>("id"));
        nameTable.setCellValueFactory(new PropertyValueFactory<loadResidentData, String>("name"));
        plotNoTable.setCellValueFactory(new PropertyValueFactory<loadResidentData, String>("plotNo"));
        ganderTable.setCellValueFactory(new PropertyValueFactory<loadResidentData, String>("gender"));
        holdingTable.setCellValueFactory(new PropertyValueFactory<loadResidentData, String>("holdingNo"));
        
        carStickerRequest requestSticker = new carStickerRequest(0,"","","");
        tableDataOfCarStickerRequest = (ObservableList<carStickerRequest>) DataReadWrite.readObjectToFile("CarStickerRequestData.bin", requestSticker);
        tableViewMaintainenceOfficer.getItems().addAll(tableDataOfCarStickerRequest);
        
        ObservableList<Resident> residentData = (ObservableList<Resident>) DataReadWrite.readObjectToFile("Resident.bin", new Resident("", "", 1, "", "",
        "", "", LocalDate.of(2023, 7, 29), 9));
        ObservableList<loadResidentData> dataTable = FXCollections.observableArrayList();
        int maleCount = 0; int femaleCount = 0;
        for ( Resident tmpp : residentData ){
            //System.out.println(tmpp.getName());
            if ( tmpp.getGender().equals("Male") ) maleCount++;
            else femaleCount++;
            
            dataTable.add(new loadResidentData( tmpp.getName(), tmpp.getPlotNo(), tmpp.getGender(), tmpp.getHoldingOrFlatNo(), tmpp.getId() ));
            //tableresident.getItems().add(new loadResidentData( tmpp.getName(), tmpp.getPlotNo(), tmpp.getGender(), tmpp.getHoldingOrFlatNo(), tmpp.getId() ));
        }
        tableresident.getItems().addAll(dataTable);
        
        policyTextArea.setText("Noise Control Policy: Residents must keep noise levels at a reasonable level between 10:00 PM and 8:00 AM to ensure a peaceful living environment.\n" + 
                                        "Parking Regulation: Residents must use their designated parking spaces only, and visitor parking is strictly reserved for guests." +"\n"+ "Unauthorized parking in visitor spots may result in penalties.\n" +
                                        "Waste Management Policy: All residents must follow the society's waste disposal guidelines, including separating recyclables and putting \n out trash only during designated collection times.\n" + 
                                        "Alteration Approval Process: Any structural changes or renovations to units require prior approval from the society management to \n ensure compliance with safety and aesthetic standards.\n" + 
                                        "Smoking is prohibited in all indoor and outdoor common areas to maintain a healthy and smoke-free environment for all residents. Designated smoking areas may be provided for those who smoke.\n"+
                                        "Residents are allowed to decorate their balconies and exteriors within specified guidelines. Decorations should not obstruct views, create safety hazards, or adversely affect the overall appearance of the building.\n" + 
                                        "Usage of amenities such as the gym, pool, and clubhouse should adhere to designated quiet hours. This ensures that residents can enjoy these facilities without disturbing others.");
        notificationTextArea.setText("Meeting Change Notification:\n" +
                                    "Subject: Change in Weekly Team Meeting Date\n" +
                                        "Date and Time: 5pm Thursday 17 August.\n" + 
                                    "Employee Training Announcement:\n" +
                                    "Subject: Upcoming Training Session\n" +
                                     "Date and Time: Saturday 19 August 11am.\n" +
                                    "IT System Maintenance Notification:\n" +
                                    "Subject: Planned IT System Maintenance\n" +
                                    "Date and Time: Monday 21 August");
        
        experienceTextArea.setText("Experienced department head with a decade of hands-on leadership in maintenance operations.\n"
                             + "Proven track record in optimizing equipment performance, fostering team efficiency, and implementing cost-effective maintenance strategies.\n " +
                               "Adept at ensuring facility functionality and enhancing operational effectiveness");
        
        ObservableList<PieChart.Data>PieChar = FXCollections.observableArrayList();
        PieChar.add(new PieChart.Data("Male", maleCount));
        PieChar.add(new PieChart.Data("Female", femaleCount));
        PieChart.getData().addAll(PieChar);
//for ( Resident xxx : people ){
        //    System.out.println(xxx.toString() + xxx.toStringM());
        //}
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
