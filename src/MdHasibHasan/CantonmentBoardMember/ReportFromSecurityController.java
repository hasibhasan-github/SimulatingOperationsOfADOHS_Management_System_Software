/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DataReadWrite;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hasib
 */

public class ReportFromSecurityController implements Initializable {

    @FXML
    private PieChart pieChart;
    
    private ObservableList<reportFromSecurityDepartment> securityReport;
    @FXML
    private Label StatusLabel;
    @FXML
    private Label PercentLabel;
    
    private Double totalDataNumber;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        totalDataNumber = 0.0;
        
        securityReport = (ObservableList<reportFromSecurityDepartment>) CantonmentBoardMember.viewReportFromDepartments("Security");
        
        // Initializing the PieChart and adding the data in PieChart 
        ObservableList<PieChart.Data>PieChar = FXCollections.observableArrayList();
        
        for ( reportFromSecurityDepartment sReport : securityReport ){
            PieChar.add(new PieChart.Data(sReport.getTimeSlotOrPurposeOfVisit(), sReport.getTimeSlotOrPurposeOfVisitCount()));
            totalDataNumber += sReport.getTimeSlotOrPurposeOfVisitCount();
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
                double percentage = (selected/Double.parseDouble(String.valueOf((totalDataNumber))))*Double.parseDouble("100");
                PercentLabel.setText(String.valueOf(decimalFormat.format(percentage))+ "%");
                }
            }
            );
        }
        
        
    }    
    
}
