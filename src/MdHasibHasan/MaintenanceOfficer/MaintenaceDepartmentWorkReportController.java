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
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class MaintenaceDepartmentWorkReportController implements Initializable {

    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private ComboBox<String> yearComboBox;
    @FXML
    private ListView<String> listView;
    @FXML
    private TextField expenditureTextField;
    @FXML
    private TextArea expendedFundTxtArea;
    @FXML
    private Button sendExpenditureReportButton;
    
    private Map<String, Double> expendedOrgAndAmount;
    
    private ObservableList<monthlyReport> reportOfMaintenance;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
            expendedOrgAndAmount = new HashMap<String, Double>();
            
            listView.getItems().addAll("1.DOHS Mosque", "2.DOHS  Park", "3.DOHS Hospital", "4.DOHS Street", "5.DOHS Street Lights",
                "6.DOHS School", "7.DOHS Gate Security", "8.DOHS Office");
            
            monthComboBox.getItems().addAll("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December"); 
            
            yearComboBox.getItems().addAll("2022","2023", "2024", "2025", "2026", "2027", "2028");
            
            monthlyReport dummyRep = new monthlyReport("", "", 1.0, new HashMap<String, Double>());
            
            reportOfMaintenance = (ObservableList<monthlyReport>) DataReadWrite.readObjectToFile("MonthlyReportOfMaintenanceDept.bin", dummyRep);
            
            for (monthlyReport tmp : reportOfMaintenance){
                System.out.println(tmp.getTotalExpendedAmount() + " " + tmp.getMonth() + tmp.getYear());
            }
            
    }    


    @FXML
    private void icludeExpandedFundButtonOnClick(ActionEvent event) {
        try {
            if ( listView.getSelectionModel().getSelectedItem() == null && expenditureTextField.getText().isEmpty() ) throw new RuntimeException ("Please Select list Item");
            else expendedOrgAndAmount.put(listView.getSelectionModel().getSelectedItem().substring(2), Double.parseDouble(expenditureTextField.getText()));
            expendedFundTxtArea.appendText("Expended " + expenditureTextField.getText() + " BDT in " + listView.getSelectionModel().getSelectedItem().substring(2) + "\n");
            expenditureTextField.clear();
            listView.getSelectionModel().clearSelection();
        }
        catch (RuntimeException ex){
            GenerateAlerts.unsuccessfulAlert(ex.toString());
        }
    }

    @FXML
    private void sendExpenditureReportButtonOnClick(ActionEvent event) {
        try{
            if ( expendedOrgAndAmount.size() == 0 && ( monthComboBox.getValue() == null && yearComboBox.getValue() == null ) ){
                throw new RuntimeException ("Please Select all the Items.");
            }
            else {
                for (monthlyReport tmp : reportOfMaintenance) {
                    if ( tmp.getMonth().equals(monthComboBox.getValue()) && tmp.getYear().equals(yearComboBox.getValue()) ) {
                        throw new RuntimeException ("There is already a report for this month & year in Database.");
                    }
                }
                MaintainenceOfficer.createMonthlyExpenditureReport(expendedOrgAndAmount, yearComboBox.getValue(), 
                        monthComboBox.getValue());
                expendedFundTxtArea.clear();
                monthComboBox.setValue(null);
                yearComboBox.setValue(null);
                expendedOrgAndAmount.clear();
            }
        } 
        catch ( RuntimeException ee ){
            GenerateAlerts.unsuccessfulAlert(ee.toString());
        }
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/MaintenanceOfficerDashboard.fxml");
    
    }
    
}
