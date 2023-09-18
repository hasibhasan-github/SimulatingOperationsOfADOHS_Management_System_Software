/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DummyUser.Resident;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hasib
 */

public class DOHSDetailsController implements Initializable {

    @FXML
    private TableView<loadResidentData> allResidentDataTableView;
    @FXML
    private TableColumn<loadResidentData, String> nameTableColoumn;
    @FXML
    private TableColumn<loadResidentData, Integer> idTableColoumn;
    @FXML
    private TableColumn<loadResidentData, String> genderTableColoumn;
    @FXML
    private TableColumn<loadResidentData, String> plotNoTableColoumn;
    @FXML
    private TableColumn<loadResidentData, String> holdingNoTableColoumn;
    @FXML
    private PieChart maleAndFemaleRatioOieChart;
    
    private ObservableList<loadResidentData> residentDataListForTable;
    @FXML
    private Label StatusLabel;
    @FXML
    private Label PercentLabel;
    
    private int male, female;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Initializing the Table Coloumn Data 
        nameTableColoumn.setCellValueFactory(new PropertyValueFactory<loadResidentData, String>("name"));
        idTableColoumn.setCellValueFactory(new PropertyValueFactory<loadResidentData, Integer>("id"));
        genderTableColoumn.setCellValueFactory(new PropertyValueFactory<loadResidentData, String>("gender"));
        plotNoTableColoumn.setCellValueFactory(new PropertyValueFactory<loadResidentData, String>("plotNo"));
        holdingNoTableColoumn.setCellValueFactory(new PropertyValueFactory<loadResidentData, String>("holdingNo"));
        
        // Creating Dummy Residence Data
        Resident people  = new Resident("", "", 1, "", "", "", 
                        "", LocalDate.of(2023, 03, 10), 11 );
        // Calling the Model Class Method.
        residentDataListForTable = CantonmentBoardMember.viewAllResidentDataAndMaleFemaleRatio(people);
        // Loading the Data in the Table View.
        allResidentDataTableView.getItems().addAll(residentDataListForTable);
        // Creating Integer Variable Male & Female.
        male = 0; female = 0;
        // Counting the Male & Female Resident of DOHS.
        for (loadResidentData maleFemaleData: residentDataListForTable  ){
            if ( maleFemaleData.getGender().equals("Male") ) male++;
            else female++;
        }
        // Initializing the PieChart and adding the data in PieChart 
        ObservableList<PieChart.Data>PieChar = FXCollections.observableArrayList();
        PieChar.add(new PieChart.Data("Male", male));
        PieChar.add(new PieChart.Data("Female", female));
        maleAndFemaleRatioOieChart.getData().addAll(PieChar);
        
        for(PieChart.Data data1: maleAndFemaleRatioOieChart.getData()){
            data1.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    StatusLabel.setText(String.valueOf(data1.getName()));
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                double selected = (data1.getPieValue());
                double percentage = (selected/Double.parseDouble(String.valueOf((male+female))))*Double.parseDouble("100");
                PercentLabel.setText(String.valueOf(decimalFormat.format(percentage))+ "%");
                }
            }
            );
        }
    }    
    
}
