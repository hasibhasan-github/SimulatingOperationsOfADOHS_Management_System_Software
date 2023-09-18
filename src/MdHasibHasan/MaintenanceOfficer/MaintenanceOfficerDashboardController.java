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
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    @FXML
    private ComboBox<String> budgetYearComboBox;
    @FXML
    private TextField amountOfBudgetTextField;
    @FXML
    private ListView<String> budgetListView;
    @FXML
    private TextArea showBudgetItemAmountTextArea;
    
    private Map <String, Float> mapOfBudgetList;
    
    @FXML
    private BarChart<String, Number> barChartOfYearlyBudget;
    @FXML
    private NumberAxis yearlyBudgetYAxis;
    @FXML
    private CategoryAxis yearlyBudgetXAxis;
    @FXML
    private ListView<String> userGoalListView;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Initializing the mapOfBudgetList -----> Map<String, Integer>>();
        mapOfBudgetList = new HashMap<String, Float>();
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
        
        // Reading Data From YearlyBudgetOfMaintenanceDept.bin file.
        loadMaintenanceFeeDataList();
        // Reading Data From YearlyBudgetOfMaintenanceDept.bin file.
        
        budgetYearComboBox.getItems().addAll( "2019","2020", "2021", "2022");
        budgetYearComboBox.getItems().addAll(selectYearComboBox.getItems());
        
        budgetListView.getItems().addAll("1.DOHS Mosque", "2.DOHS  Park", "3.DOHS Hospital", "4.DOHS Street", "5.DOHS Street Lights",
                "6.DOHS School", "7.DOHS Gate Security", "8.DOHS Office");
        
        // Initializing and Loading The Bar Chart
        loadBarChart();
        // Initializing and Loading The Bar Chart
        
        // Initializing the User Goal List View
        initializingTheuserGoalListView();
        // Initializing the User Goal List View
    }  
    
    private void loadMaintenanceFeeDataList(){
        maintenanceFee dummy = new maintenanceFee(0, "", "", "", false);
        feeList = (ObservableList<maintenanceFee>) DataReadWrite.readObjectToFile("MainteneceFee.bin", dummy);
    }
    
    private void loadBarChart(){
        // Reading Data from YearlyBudgetOfMaintenanceDept.bin file.
        yearlyBudget newBudget = new yearlyBudget("", 10, new HashMap<String, Float>());
        ObservableList<yearlyBudget> budgetYearly = (ObservableList<yearlyBudget>) DataReadWrite.readObjectToFile("YearlyBudgetOfMaintenanceDept.bin", newBudget);
        
        barChartOfYearlyBudget.getData().clear();
        
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        for (yearlyBudget tmp : budgetYearly){
            series.getData().add(new XYChart.Data<String,Number>(tmp.getBudgetYear(),tmp.getTotalBudgetAmount()));
        }
        
        series.setName("All time Maintenance Budget");
        barChartOfYearlyBudget.getData().add(series);
    }
    
    private void initializingTheuserGoalListView(){
        // Initializing the User Goal List View
        userGoalListView.getItems().addAll("1.DOHS Software System", "2.Notice Section", "3.Public Property Section",
                "4.Support/Help Desk Forum", "5.Monthly Report Section", "6.Permission Section");
    }
   

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        if ( GenerateAlerts.confirmationAlert() ) {
        newwscene.logOutSceneSwitching(stage);
        GenerateAlerts.successfulAlert("Have a good day!" + "\n" + "Please visit Again"); }
    }

    @FXML
    private void approveButtonOnClick(ActionEvent event) {
        try {
        carStickerRequest giveApproval =tableViewMaintainenceOfficer.getSelectionModel().getSelectedItem(); 
        // Approving Car Sticker Request by model class static method.
        ObservableList<carStickerRequest> approvedList = MaintainenceOfficer.approveCarStickerRequest(tableDataOfCarStickerRequest, giveApproval);
        // Clearing table data list
        tableViewMaintainenceOfficer.getItems().clear();
        // Adding the updated list to Table
        tableViewMaintainenceOfficer.getItems().addAll(approvedList);
        }
        catch( Exception em ){
            GenerateAlerts.successfulAlert("Please Select Table Item.");
        }
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

    @FXML
    private void addBudgetForTheSelectedItemFromListButtonOnClick(ActionEvent event) {
        try{
            mapOfBudgetList.put(budgetListView.getSelectionModel().getSelectedItem(), Float.parseFloat(amountOfBudgetTextField.getText()));
            //budgetListForSpeicificYear.add();
            showBudgetItemAmountTextArea.appendText(budgetListView.getSelectionModel().getSelectedItem() + " : " + amountOfBudgetTextField.getText() + " BDT\n");
            budgetListView.getSelectionModel().clearSelection();
            amountOfBudgetTextField.clear();
        }
        catch (Exception e){
            GenerateAlerts.unsuccessfulAlert("Select the Item from List and Add the Amount.");
        }
    }

    @FXML
    private void createYearlyBudgetButtonOnClick(ActionEvent event) {
        try{
            if ( GenerateAlerts.confirmationAlert() ){
                MaintainenceOfficer.createYearlyMaintenanceBudget(mapOfBudgetList, budgetYearComboBox.getValue());
                showBudgetItemAmountTextArea.clear();
                mapOfBudgetList.clear();
                //Refreshing The Bar Chart
                loadBarChart();
            }
        }
        catch( Exception e ){
            GenerateAlerts.unsuccessfulAlert("Please Select the Year and other Data.");
        }
        
    }

    @FXML
    private void loadPageButtonOnClick(ActionEvent event) {
        // dohsSoftwareSystem ,"dohsSoftwareSystem.fxml");
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        try{

            if ( userGoalListView.getSelectionModel().getSelectedItem().equals("1.DOHS Software System") ){
                newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/dohsSoftwareSystem.fxml");
            }
            else if ( userGoalListView.getSelectionModel().getSelectedItem().equals("3.Public Property Section") ){
                newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/PublicPropertyDashboard.fxml");
            }
            else if ( userGoalListView.getSelectionModel().getSelectedItem().equals("6.Permission Section") ){
                newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/requestEventPermission.fxml");
            }
            else if ( userGoalListView.getSelectionModel().getSelectedItem().equals("2.Notice Section") ){
                newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/noticeScene.fxml");
            }
            else if ( userGoalListView.getSelectionModel().getSelectedItem().equals("5.Monthly Report Section") ){
                newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/maintenaceDepartmentWorkReport.fxml");
            }
            else if ( userGoalListView.getSelectionModel().getSelectedItem().equals("4.Support/Help Desk Forum") ){
                newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/helpDeskForumsFeedBack.fxml");
            }
        }
        catch (Exception e){
            GenerateAlerts.unsuccessfulAlert("Please select the page from list.");
        }
    }
    
}
