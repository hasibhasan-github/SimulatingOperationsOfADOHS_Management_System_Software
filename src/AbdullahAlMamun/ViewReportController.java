/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ViewReportController implements Initializable {

    @FXML
    private PieChart purposeOfVisitPieChart;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;
    @FXML
    private Label statusLabel;
    @FXML
    private BarChart<String, Number> barChart;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        int[] slotCountList = SecurityCheif.visitorsTimeSlotCountBarChart();
        
        String[] timeSlotArr = {"8.00-10.00 am", "10.00-12.00 am", "12.00-2.00 pm", 
         "2.00-4.00 pm", "4.00-6.00 pm", "6.00-8.00 pm", "8.00-10.00 pm"};
         
        
        XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
        for(int i=0; i<7; i++){
             if(slotCountList[i]!=0){
                 series.getData().add(new XYChart.Data<String,Number>(timeSlotArr[i],slotCountList[i]));
             }
         }
       barChart.getData().clear();
       series.setName("Visitor Time Slot Count");
       barChart.getData().add(series);
    }    

    private void goToDashboardButtonONClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage, "SecurityCheifDashboard.fxml");
    }

    @FXML
    private void loadChartButtonOnClick(ActionEvent event) {
        try{
            ObservableList<PieChart.Data> tempList = SecurityCheif.purposeOfVisitCountPiChart();
            purposeOfVisitPieChart.getData().clear();
            purposeOfVisitPieChart.getData().addAll(tempList);
        }
        catch(Exception ee) {
            GenerateAlerts.successfulAlert("Please Check Again");
        }
        
        for(PieChart.Data data1: purposeOfVisitPieChart.getData()){
            data1.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    statusLabel.setText(String.valueOf(data1.getPieValue()));
                
                }
            }
            );
        } 
       
        
    }
    
}
