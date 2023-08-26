/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author user
 */
public class CheckPointsController implements Initializable {

    @FXML
    private ComboBox<String> selectCheckpointComboBox;
    @FXML
    private ComboBox<String> slectNoOfOfficersCombobox;
    @FXML
    private DatePicker selectDate;
    @FXML
    private Label chekpoint4;
    @FXML
    private Label chekpoint3;
    @FXML
    private Label chekpoint1;
    @FXML
    private Label chekpoint2;
    @FXML
    private Button assignBtn;
    
     private ObservableList<CheckPointData> cpList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectCheckpointComboBox.getItems().addAll("Checkpoint-1","Checkpoint-2","Checkpoint-3","Checkpoint-3");
        slectNoOfOfficersCombobox.getItems().addAll("1","2","3","4","5","6","7","8","9","10");
        
        
        
        
    }    

    @FXML
    private void assignOfficerButtonOnClick(ActionEvent event) {
        String checkpoint = selectCheckpointComboBox.getValue();
        String noOfOfficer = slectNoOfOfficersCombobox.getValue();
        LocalDate date = selectDate.getValue();
        
        try{
            if(checkpoint == null || noOfOfficer == null || date == null) {
            GenerateAlerts.unsuccessfulAlert("Please fill in all fields.");
            return; 
            }
            
            CheckPointData checkpointdata = new CheckPointData(checkpoint, noOfOfficer, date);
            
            DataReadWrite.writeObjectToFile("CheckPointData.bin", checkpointdata);
            GenerateAlerts.successfulAlert("New Officers Assigned");
            assignBtn.setDisable(true);
        }
        catch(Exception ee){
            GenerateAlerts.unsuccessfulAlert("An error occurred. Please try again.");
        }
}

    @FXML
    private void refreshbuttonOnClick(ActionEvent event) {
        CheckPointData cp = new CheckPointData("","",null); 
        cpList = (ObservableList<CheckPointData>) DataReadWrite.readObjectToFile("CheckPointData.bin", cp);
        
        for(CheckPointData x : cpList){          
            String noOfcheckpoint = x.getCheckpointNo();
            if("Checkpoint-1".equals(noOfcheckpoint)){
                chekpoint1.setText(x.getoOfOfficers()+" Officers Assinged in Checkpoint-1");
                
            }
            else if("Checkpoint-2".equals(noOfcheckpoint)){
                chekpoint2.setText(x.getoOfOfficers()+" Officers Assinged in Checkpoint-2");
            }
            else if("Checkpoint-3".equals(noOfcheckpoint)){
                chekpoint3.setText(x.getoOfOfficers()+" Officers Assinged in Checkpoint-3");
            }
            else if("Checkpoint-4".equals(noOfcheckpoint)){
                chekpoint4.setText(x.getoOfOfficers()+" Officers Assinged in Checkpoint-3");
            }
            
        }
    }





}
