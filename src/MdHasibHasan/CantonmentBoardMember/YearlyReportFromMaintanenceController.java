/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.MaintenanceOfficer.monthlyReport;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Hasib
 */

public class YearlyReportFromMaintanenceController implements Initializable {

    @FXML
    private ComboBox<String> yearComboBox;
    @FXML
    private StackedBarChart<String, Number> stackBarChart;
    
    private ObservableList<monthlyReport> reportOfMaintenance;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private Label series1Label;
    @FXML
    private Label series2Label;
    @FXML
    private Label series3Label;
    @FXML
    private Label series4Label;
    @FXML
    private Label series5Label;
    @FXML
    private Label series6Label;
    @FXML
    private Label series7Label;
    @FXML
    private Label series8Label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
            //yearComboBox.getItems().addAll("January", "February", "March", "April", "May",
            //    "June", "July", "August", "September", "October", "November", "December");
            
            yearComboBox.getItems().addAll("2022","2023", "2024", "2025", "2026", "2027", "2028");
        
            monthlyReport dummyRep = new monthlyReport("", "", 1.0, new HashMap<String, Double>());
            
            reportOfMaintenance = (ObservableList<monthlyReport>) DataReadWrite.readObjectToFile("MonthlyReportOfMaintenanceDept.bin", dummyRep);

              
    }    

    @FXML
    private void loadChartButtonOnClick(ActionEvent event) {
       try {
           
         if ( yearComboBox.getValue() == null ) throw new RuntimeException("Select the year");
         else {
        stackBarChart.getData().clear();
        setLabelDisable();
        
        XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series4 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series5 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series6 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series7 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series8 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series9 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series10 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series11 = new XYChart.Series<String,Number>();
        XYChart.Series<String,Number> series12 = new XYChart.Series<>();
        
        series1.setName("January");
        series2.setName("February");
        series3.setName("March");
        series4.setName("April");
        series5.setName("May");
        series6.setName("June");
        series7.setName("July");
        series8.setName("August");
        series9.setName("September");
        series10.setName("October");
        series11.setName("November");
        series12.setName("December");
                   
        for ( monthlyReport data : reportOfMaintenance ){
            if ( yearComboBox.getValue().equals(data.getYear()) ){
                setLabel();
                if ( data.getMonth().equals("January") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series1.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); 
                    // series1Label.setText(entry.getKey().substring(5));
                    }
                }
                else if ( data.getMonth().equals("February") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series2.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); 
                    // series2Label.setText(entry.getKey().substring(5));
                    }
                }
                else if ( data.getMonth().equals("March") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series3.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); }
                }
                else if ( data.getMonth().equals("April") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series4.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); }
                }
                else if ( data.getMonth().equals("May") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series5.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); }
                }
                else if ( data.getMonth().equals("June") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series6.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); }
                }
                else if ( data.getMonth().equals("July") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series7.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); }
                }
                else if ( data.getMonth().equals("August") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series8.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); }
                }
                else if ( data.getMonth().equals("September") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series9.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); }
                }
                else if ( data.getMonth().equals("October") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series10.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); }
                }
                else if ( data.getMonth().equals("November") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series11.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); }
                }
                else if ( data.getMonth().equals("December") ){
                    for ( Map.Entry<String, Double> entry : data.getExpendedOrgAndAmount().entrySet()) {
                    series12.getData().add(new XYChart.Data<>(entry.getKey().substring(5), entry.getValue())); }
                }
            }
        }
        
        
        stackBarChart.getData().addAll(series1, series2, series3, series4, series5,
                series6, series7, series8, series9, series10, series11, series12);
        
         }
       }
       catch ( RuntimeException e ){
           GenerateAlerts.unsuccessfulAlert(e.toString());
       }
    }
    
    private void setLabel (){
        series1Label.setText("Mosque");
        series2Label.setText("Park");
        series3Label.setText("Hospital");
        series4Label.setText("Street");
        series5Label.setText("Street Light");
        series6Label.setText("School");
        series7Label.setText("Security");
        series8Label.setText("Office");
    }
    
    private void setLabelDisable() {
        series1Label.setText("");
        series2Label.setText("");
        series3Label.setText("");
        series4Label.setText("");
        series5Label.setText("");
        series6Label.setText("");
        series7Label.setText("");
        series8Label.setText("");
    }
}
