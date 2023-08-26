/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class PublicPropertyDashboardController implements Initializable {

    @FXML
    private TableView<PublicProperties> donationDataTableView;
    @FXML
    private TableColumn<PublicProperties, String> emailTableColoumn;
    @FXML
    private TableColumn<PublicProperties, Integer> idTableColoumn;
    @FXML
    private TableColumn<PublicProperties, Double> amountTableColoumn;
    @FXML
    private TableColumn<PublicProperties, String> organizationTypeTableColoumn;
    @FXML
    private TableColumn<PublicProperties, String> monthTableColoumn;
    @FXML
    private TableColumn<PublicProperties, String> yearTableColoumn;
    @FXML
    private ComboBox<String> selectMonthComboBox;
    @FXML
    private ComboBox<String> selectYearComboBox;
    @FXML
    private ComboBox<String> selectOrganizationComboBox;
    @FXML
    private TextField totalDonationAmountInSpecificYearMonth;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        selectMonthComboBox.getItems().addAll("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December");
        selectYearComboBox.getItems().addAll("2023", "2024", "2025", "2026", "2027", "2028");
        selectOrganizationComboBox.getItems().addAll("Mosque", "Hospital", "Park", "School");
        
        emailTableColoumn.setCellValueFactory(new PropertyValueFactory<PublicProperties, String>("email"));
        monthTableColoumn.setCellValueFactory(new PropertyValueFactory<PublicProperties, String>("month"));
        yearTableColoumn.setCellValueFactory(new PropertyValueFactory<PublicProperties, String>("year"));
        organizationTypeTableColoumn.setCellValueFactory(new PropertyValueFactory<PublicProperties, String>("organizationType"));
        idTableColoumn.setCellValueFactory(new PropertyValueFactory<PublicProperties, Integer>("id"));
        amountTableColoumn.setCellValueFactory(new PropertyValueFactory<PublicProperties, Double>("donatedAmount"));
    }    

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/MaintenanceOfficerDashboard.fxml");
    }

    @FXML
    private void loadDonationDataButtonOnClick(ActionEvent event) {
        try{
            PublicProperties donation = new PublicProperties(0, "email",selectMonthComboBox.getValue(),
                selectYearComboBox.getValue(), selectOrganizationComboBox.getValue(), 22.0);
            ObservableList<PublicProperties> updateDonationList = MaintainenceOfficer.seeAllPublicPropertyFunds(donation);
            donationDataTableView.getItems().clear();
            donationDataTableView.getItems().addAll(updateDonationList);
            double totalFund = 0;
            for ( PublicProperties fundData: updateDonationList ){
                totalFund += fundData.getDonatedAmount();
            }
            totalDonationAmountInSpecificYearMonth.setText(String.valueOf(totalFund) + " BDT");
        }
        catch(Exception e){
            GenerateAlerts.unsuccessfulAlert("Select Item from All the ComboBox");
        }
    }

    @FXML
    private void yearlyStatisticsButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        newwscene.windowSwitchingWithoutDataPassing( "/MdHasibHasan/MaintenanceOfficer/PublicPropertyFundYearlyStatistics.fxml");
    }
    
}
