/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdMasumBilla;

import MdHasibHasan.DataReadWrite;
import java.net.URL;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
/**
 * FXML Controller class
 *
 * @author MD Masum Billa
 */
public class AccountOfficerDashBoardController implements Initializable {


    @FXML
    private PieChart PieChart;
    @FXML
    private ComboBox<String> ItemNameComboBox;
    @FXML
    private TextField ItemValue;
    
    @FXML
    private TextArea OutputTextArea;
    
    @FXML
    private Label StatusLabel;
    @FXML
    private Label PercentLabel;
    
    /**
     * Initializes the controller class.
     */
    
    ObservableList<PieChart.Data>PieChartData = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ItemNameComboBox.getItems().addAll("Infrastructure Development",
                "Staff Salaries",
                "Security",
                "Emergencies",
                "Legal and Regulatory Compliance");
        ItemNameComboBox.setValue("Choose an option");
    }    
    
    @FXML
    private void ShowPieChartOnClick(ActionEvent event) {
        BudgetingAndForecasting budget = new BudgetingAndForecasting("", (float) 1.0);
        ObservableList<BudgetingAndForecasting> LoadChartDataFromFile = (ObservableList<BudgetingAndForecasting>) DataReadWrite.readObjectToFile("BudgetFileData.bin", budget);
        ObservableList<PieChart.Data>PieChar = FXCollections.observableArrayList();
//PieChart.getData().addAll(PieChartData);
        for (BudgetingAndForecasting x : LoadChartDataFromFile){
            PieChar.add(new PieChart.Data(x.getItem(),x.getValue()));
            //data.add(new PieChart.Data(label, value));
            //System.out.println(x.getItem());
            //PieChart.getData().add(x);
        }
        PieChart.getData().clear();
        PieChart.getData().addAll(PieChar);
        
        for(PieChart.Data data1: PieChart.getData()){
            data1.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    StatusLabel.setText(String.valueOf(data1.getPieValue()));
                System.out.println("Pie Chart Clicked");
                PercentLabel.setTranslateX(event.getSceneX()-PercentLabel.getLayoutX());
                PercentLabel.setTranslateX(event.getSceneY()-PercentLabel.getLayoutY());
                PercentLabel.setText(String.valueOf(data1.getPieValue())+ "%");
                }
            }
            );
        } 
        
    }
    
    

    @FXML
    private void AddNewItemToFileOnButtonClick(ActionEvent event) {
        
        BudgetingAndForecasting budget = new BudgetingAndForecasting(ItemNameComboBox.getValue(),Float.parseFloat(ItemValue.getText()));
        DataReadWrite.writeObjectToFile("BudgetFileData.bin",budget);
        
        System.out.println("Data added Successfully.");
    }
    
    @FXML
    void ClearFileDataOnClick(ActionEvent event) {
        /*
        BudgetingAndForecasting x = new BudgetingAndForecasting();
        x.clearPieChartData(budget);
        */
        //PieChart.getData().clear();
        BudgetingAndForecasting budget = new BudgetingAndForecasting("", (float) 0.0);
        DataReadWrite.overWriteObjectToFile("BudgetFileData.bin", budget);
        
        BudgetingAndForecasting budddy = new BudgetingAndForecasting("", (float) 1.0);
        ObservableList<BudgetingAndForecasting> LoadChartDataFromFile = (ObservableList<BudgetingAndForecasting>) DataReadWrite.readObjectToFile("BudgetFileData.bin", budddy);
        
        for (BudgetingAndForecasting x : LoadChartDataFromFile){
            System.out.println(x.getItem());
        }
    }
    
    @FXML
    void GeneratePdfOnClick(ActionEvent event) {

    }

    @FXML
    void ShowFinancialReportOnClick(ActionEvent event) {
        
        /* FinancialRiskManagement risk = new FinancialRiskManagement( (int) 1);
        ObservableList<FinancialRiskManagement> readRisk = (ObservableList<FinancialRiskManagement>) DataReadWrite.readObjectToFile("BudgetFileData.bin", risk);
        
        if (readRisk != null) {
        String reportText = "Financial Risk Report:\n\n";
        reportText += "Description: " + readRisk.get(0).getDescription() + "\n"; // Adjust the method according to your FinancialRiskManagement class
        reportText += "Risk Level: " + readRisk.get(0).getRisklevel() + "\n"; // Adjust the method according to your FinancialRiskManagement class
        // Add more properties as needed

        OutputTextArea.setText(reportText);
        } else {
        OutputTextArea.setText("Error reading financial data.");
        } */
    }

}
