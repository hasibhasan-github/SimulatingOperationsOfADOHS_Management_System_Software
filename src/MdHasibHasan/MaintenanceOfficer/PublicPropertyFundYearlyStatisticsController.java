/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.DataReadWrite;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Hasib
 */

public class PublicPropertyFundYearlyStatisticsController implements Initializable {

    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private ComboBox<String> selectYearComboBox;
    
    private ObservableList<PublicProperties> donationList;
    
    private ObservableList<PublicProperties> updateDonationList;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        updateDonationList  = FXCollections.observableArrayList();
                
        
        ///orgTypeList.add("Mosque"); orgTypeList.add("Hospital");
        // orgTypeList.add("Park"); orgTypeList.add("School");
        
        PublicProperties donation = new PublicProperties(0, "email", "month", "year", "type", 22.0);
        donationList  = (ObservableList<PublicProperties>) DataReadWrite.readObjectToFile("PublicPropertyMaintanenceFund.bin", donation);
        
        selectYearComboBox.getItems().addAll("2023", "2024", "2025", "2026", "2027", "2028");
    }    

    @FXML
    private void loadYearlyCollectedFundsChartButtonOnClick(ActionEvent event) {
        try{
            updateDonationList.clear();
            lineChart.getData().clear();
            for ( PublicProperties data : donationList ){
                if ( data.getYear().equals(selectYearComboBox.getValue()) ){
                    updateDonationList.add(data);
                }
            }
            XYChart.Series<String,Number> msoque = new XYChart.Series<String,Number>();
            XYChart.Series<String,Number> hospital = new XYChart.Series<String,Number>();
            XYChart.Series<String,Number> school = new XYChart.Series<String,Number>();
            XYChart.Series<String,Number> park = new XYChart.Series<String,Number>();
            
            msoque.setName("Mosque");
            hospital.setName("Hospital");
            school.setName("School");
            park.setName("Park");
            
            Map<String, Double> mosqueMap = new HashMap<String, Double>();
            Map<String, Double> hospitalMap = new HashMap<String, Double>();
            Map<String, Double> parkMap = new HashMap<String, Double>();
            Map<String, Double> schoolMap = new HashMap<String, Double>();
            
            for ( PublicProperties data1 : updateDonationList ){
                if ( mosqueMap.containsKey(data1.getMonth()) && data1.getOrganizationType().equals("Mosque") ){
                    Double amount = mosqueMap.get(data1.getMonth());
                    mosqueMap.put(data1.getMonth(), amount + data1.getDonatedAmount());
                }
                else if (data1.getOrganizationType().equals("Mosque")) {
                    mosqueMap.put(data1.getMonth(), data1.getDonatedAmount());
                }
                if ( hospitalMap.containsKey(data1.getMonth()) && data1.getOrganizationType().equals("Hospital") ){
                    Double amount = hospitalMap.get(data1.getMonth());
                    hospitalMap.put(data1.getMonth(), amount + data1.getDonatedAmount());
                }
                else if (data1.getOrganizationType().equals("Hospital")) {
                    hospitalMap.put(data1.getMonth(), data1.getDonatedAmount());
                }
                if ( parkMap.containsKey(data1.getMonth()) && data1.getOrganizationType().equals("Park") ){
                    Double amount = parkMap.get(data1.getMonth());
                    parkMap.put(data1.getMonth(), amount + data1.getDonatedAmount());
                }
                else if (data1.getOrganizationType().equals("Park")) {
                    parkMap.put(data1.getMonth(), data1.getDonatedAmount());
                }
                if ( schoolMap.containsKey(data1.getMonth()) && data1.getOrganizationType().equals("School") ){
                    Double amount = schoolMap.get(data1.getMonth());
                    schoolMap.put(data1.getMonth(), amount + data1.getDonatedAmount());
                }
                else if (data1.getOrganizationType().equals("School")) {
                    schoolMap.put(data1.getMonth(), data1.getDonatedAmount());
                }
            }
            
            for ( Map.Entry<String, Double> dataaMosque : mosqueMap.entrySet() ){
                //System.out.println(hasib.getKey() + " " + hasib.getValue());
                msoque.getData().add(new XYChart.Data<String,Number>(dataaMosque.getKey(), dataaMosque.getValue()));
            }
            for ( Map.Entry<String, Double> dataHospital : hospitalMap.entrySet() ){
                //System.out.println(hasib.getKey() + " " + hasib.getValue());
                hospital.getData().add(new XYChart.Data<String,Number>(dataHospital.getKey(), dataHospital.getValue()));
            }
            for ( Map.Entry<String, Double> dataPark : parkMap.entrySet() ){
                // System.out.println(hasib.getKey() + " " + hasib.getValue());
                park.getData().add(new XYChart.Data<String,Number>(dataPark.getKey(), dataPark.getValue()));
            }
            for ( Map.Entry<String, Double> dataSchool : schoolMap.entrySet() ){
                // System.out.println(hasib.getKey() + " " + hasib.getValue());
                school.getData().add(new XYChart.Data<String,Number>(dataSchool.getKey(), dataSchool.getValue()));
            }    
         lineChart.getData().addAll(msoque, hospital, park, school);
        }
        catch (Exception e){
            lineChart.getData().clear();
        }
    } 
 
    
}
