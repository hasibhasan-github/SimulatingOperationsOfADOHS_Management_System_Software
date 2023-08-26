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
    private Label riskStatusLabel;
    
    @FXML
    private Label StatusLabel;
    
    @FXML
    private Label PercentLabel;
    
    //Financial RiskManagement
    
     @FXML
    private ComboBox<String> RiskNameComboBox;

    @FXML
    private ComboBox<String> DescriptionComboBox;

    @FXML
    private ComboBox<Double> LikelihoodComboBox;

    @FXML
    private ComboBox<Double> ImpactComboBox;
    
    @FXML
    private TextArea riskTextArea;
    
    //Financial Report
    
     @FXML
    private TextArea reportTextArea;
     
    //Financial analysis
     
     @FXML
    private TextField TotalIncomeTextField;

    @FXML
    private TextField TotalExpenseTextField;

    @FXML
    private TextField AverageTotalAssets;

    @FXML
    private TextArea financialAnalysisTextArea; 
    
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
        
        //Financial RiskManagement
    
        RiskNameComboBox.getItems().addAll("Market Fluctuations","Membership Fee Default","Maintenance Cost Increase");
        RiskNameComboBox.setValue("Choose an option");
        
        DescriptionComboBox.getItems().addAll(
                "Risks due to market price volatility",
                "Risks of members defaulting on fees",
                "Risks of unexpected maintenance cost hikes"
        );
        DescriptionComboBox.setValue("Choose an option");
        
        LikelihoodComboBox.getItems().addAll(0.7,0.5,0.4);
        LikelihoodComboBox.setValue(Double.NaN);
        
        ImpactComboBox.getItems().addAll(0.8,0.6,0.7);
        ImpactComboBox.setValue(Double.NaN);
    }    
    
    @FXML
    private void ShowPieChartOnClick(ActionEvent event) {
        BudgetingAndForecasting budget = new BudgetingAndForecasting("", (float) 1.0);
        ObservableList<BudgetingAndForecasting> LoadChartDataFromFile = (ObservableList<BudgetingAndForecasting>) DataReadWrite.readObjectToFile("BudgetFileData.bin", budget);
        ObservableList<PieChart.Data>PieChar = FXCollections.observableArrayList();

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
        BudgetingAndForecasting budget = new BudgetingAndForecasting("", (float) 0.0);
        DataReadWrite.overWriteObjectToFile("BudgetFileData.bin", budget);
        
        BudgetingAndForecasting budddy = new BudgetingAndForecasting("", (float) 1.0);
        ObservableList<BudgetingAndForecasting> LoadChartDataFromFile = (ObservableList<BudgetingAndForecasting>) DataReadWrite.readObjectToFile("BudgetFileData.bin", budddy);
        
        for (BudgetingAndForecasting x : LoadChartDataFromFile){
            System.out.println(x.getItem());
        }
    }
      
    @FXML
    void analyzeRiskOnClick(ActionEvent event) {
        String riskName = RiskNameComboBox.getValue();
        String description = DescriptionComboBox.getValue();
        double likelihood = LikelihoodComboBox.getValue();
        double impact = ImpactComboBox.getValue();

        double riskScore = likelihood * impact;
        
        String riskStatus;
        if (riskScore >= 0.7) {
            riskStatus = "High Risk";
        } else if (riskScore >= 0.4) {
            riskStatus = "Medium Risk";
        } else {
            riskStatus = "Low Risk";
        }

        FinancialRisk risk = new FinancialRisk(riskName, description, likelihood, impact);

        String riskAnalysisReport = "Risk: " + riskName +
                                    "\nDescription: " + description +
                                    "\nLikelihood: " + likelihood +
                                    "\nImpact: " + impact +
                                    "\nRisk Score: " + riskScore +
                                    "\nRisk Status: " + riskStatus +
                                    "\n"+
                                    "\n"+
                                    "\n[RiskScore >= 0.7 = High Risk" +                                    
                                    "\nRiskScore >= 0.4 = Medium Risk" +
                                    "\nRiskScore <= 0.4 = Low Risk]" +"\n";

        riskTextArea.setText(risk);

        DataReadWrite.overWriteObjectToFile("FinancialRisk.bin", riskAnalysisReport);
    }
    
        
    @FXML
    void GeneratePdfOnClick(ActionEvent event) {
        String text = riskTextArea.getText();
        PdfGenerator.generatePdf(text);
    }
    
//Financial analysis
    
    @FXML
    void calculateFinancialMetricsOnClick(ActionEvent event) {
        FinancialAnalysis financialAnalysis = new FinancialAnalysis(      
            Double.parseDouble(TotalIncomeTextField.getText()),
            Double.parseDouble(TotalExpenseTextField.getText()),
            Double.parseDouble(AverageTotalAssets.getText())
            );
        financialAnalysisTextArea.appendText(financialAnalysis.toString());
        
        DataReadWrite.overWriteObjectToFile("FinancialAnalysis.bin", financialAnalysis);
        
    }
    
    @FXML
    void GeneratePdfOfFinancialAnalysisOnClick(ActionEvent event) {
        String text = financialAnalysisTextArea.getText();
        PdfGenerator.generatePdf(text);
    }    
    
    
//Financial Report
    
    @FXML
    void ShowReportOnClick(ActionEvent event) {
        BudgetingAndForecasting budget = new BudgetingAndForecasting("", (float) 1.0);
        ObservableList<BudgetingAndForecasting> LoadChartDataFromFile = (ObservableList<BudgetingAndForecasting>) DataReadWrite.readObjectToFile("BudgetFileData.bin", budget);
        for (BudgetingAndForecasting x : LoadChartDataFromFile){
            reportTextArea.appendText(x.toString());
            
        }
        
        FinancialAnalysis financialAnalysis = new FinancialAnalysis(0.0,0.0,0.0);
        
        ObservableList<FinancialAnalysis>FInancialA = (ObservableList<FinancialAnalysis>) DataReadWrite.readObjectToFile("FinancialAnalysis.bin",financialAnalysis );
        for (FinancialAnalysis tmp : FInancialA){
            reportTextArea.appendText(tmp.toString());
        }

        FinancialRisk risk1 = new FinancialRisk("", "", 0.0, 0.0);
        
        ObservableList<FinancialRisk>FInancialR = (ObservableList<FinancialRisk>) DataReadWrite.readObjectToFile("FinancialRisk.bin",risk1);
        for (FinancialRisk tmp : FInancialR){
            reportTextArea.appendText(tmp.toString());
        }    
    }
    
    @FXML
    void GeneratePdfOfFinancialReportOnClick(ActionEvent event) {
        String text = reportTextArea.getText();
        PdfGenerator.generatePdf(text);
    }
}
