/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.MaintenanceOfficer.monthlyReport;
import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hasib
 */

public class ReportViewFromMaintenanceController implements Initializable {

    @FXML
    private ComboBox<String> monthComboBox;
    @FXML
    private ComboBox<String> yearComboBox;
    @FXML
    private PieChart pieChart;
    
    private ObservableList<monthlyReport> reportOfMaintenance;
    
    private Double total;
    @FXML
    private Label StatusLabel;
    @FXML
    private Label PercentLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        // TODO
            total = 0.0;
            monthlyReport dummyRep = new monthlyReport("", "", 1.0, new HashMap<String, Double>());
            
            reportOfMaintenance = (ObservableList<monthlyReport>) DataReadWrite.readObjectToFile("MonthlyReportOfMaintenanceDept.bin", dummyRep);
            
            yearComboBox.getItems().addAll("2022","2023", "2024", "2025", "2026", "2027", "2028");
            
            monthComboBox.getItems().addAll("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December");
        
            
    }    

    @FXML
    private void loadReportButtonOnClick(ActionEvent event) {
        try{
            pieChart.getData().clear();
            if (( monthComboBox.getValue() == null && yearComboBox.getValue() == null ) ){
                throw new RuntimeException ("Please Select all the ComboBox.");
            }
            else{
                ObservableList<PieChart.Data>PieChar = FXCollections.observableArrayList();
                
                for ( monthlyReport dataOfChart : reportOfMaintenance ){
                    if ( dataOfChart.getMonth().equals(monthComboBox.getValue()) && yearComboBox.getValue().equals(dataOfChart.getYear()) ){
                        total = dataOfChart.getTotalExpendedAmount();
                        for ( Map.Entry<String, Double> entry : dataOfChart.getExpendedOrgAndAmount().entrySet() ){
                            PieChar.add(new PieChart.Data(entry.getKey(), entry.getValue()));
                        }
                    }
                }
                pieChart.getData().addAll(PieChar);
                
        for(PieChart.Data data1: pieChart.getData()){
            data1.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    StatusLabel.setText(String.valueOf(data1.getName()));
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                double selected = (data1.getPieValue());
                double percentage = (selected/Double.parseDouble(String.valueOf((total))))*Double.parseDouble("100");
                PercentLabel.setText(String.valueOf(decimalFormat.format(percentage))+ "%");
                }
            }
            );
        }
                
            }
        }
        catch ( RuntimeException ee ){
            GenerateAlerts.unsuccessfulAlert(ee.toString());
        }
    }

    @FXML
    private void yearlyReportButtonOnClick(ActionEvent event) throws IOException {
    sceneChanging newwscene = new sceneChanging();
        newwscene.windowSwitchingWithoutDataPassing( "/MdHasibHasan/CantonmentBoardMember/yearlyReportFromMaintanence.fxml");
    
        
    }

    
}
