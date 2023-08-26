/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class VotingSceneController implements Initializable {

    @FXML
    private ComboBox<String> chooseProjectComboBox;
    @FXML
    private TextField runningVoteTextField;
    @FXML
    private DatePicker selectDateDevelopement;
    @FXML
    private PieChart pieChart;
    @FXML
    private TextField runningVoteTextField2;
    @FXML
    private TextArea loadDevelopementPlanTxtArea;
    @FXML
    private Button startVotingEventDevelopementButton;
    @FXML
    private Button endVotingButton;
    
    private ObservableList<developementProject> projectDevPlan;
    
    private ObservableList<residentVote> rVoteProj;
    @FXML
    private Label StatusLabel;
    @FXML
    private Label PercentLabel;
    
    int pos, neg, neut;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //  Creating Dummy Instance to Read The File Data of "DevelopmentProjects.bin".
        developementProject dummyInstance = new developementProject("", LocalDate.of(2023, 03, 10), new ArrayList<String>());
        // Reading the data From File.
        projectDevPlan = (ObservableList<developementProject>) DataReadWrite.readObjectToFile("DevelopmentProjects.bin", dummyInstance);
        
        for ( developementProject comboBoxData : projectDevPlan ){
            chooseProjectComboBox.getItems().add(comboBoxData.getProjectName());
        }
        developementProjectVoting dummyProj = new developementProjectVoting("", dummyInstance, LocalDate.of(2023, 03, 10) );
        
        ObservableList<developementProjectVoting> votingProj = (ObservableList<developementProjectVoting>) DataReadWrite.readObjectToFile("developementProjectVoting.bin", dummyProj);
        
        
        residentVote dummyResidentVote = new residentVote ("", "", 1, dummyInstance );
        
        rVoteProj  = (ObservableList<residentVote>) DataReadWrite.readObjectToFile("ResidentVoteOnDevelopementProject.bin", dummyResidentVote);
        
        
        
        int positive = 0, negative = 0, neutral = 0;
        
        for ( residentVote voteCount: rVoteProj ){
            if ( voteCount.getResidentVote().equals("Positive") ) positive++;
            else if ( voteCount.getResidentVote().equals("Negative") ) negative++;
            else if ( voteCount.getResidentVote().equals("Neutral") ) neutral++;
        }
        
        System.out.println(positive + " " + negative + " " + neutral );
       
        
        if ( votingProj.get(0).getProjectName().equals("Empty") ){
            endVotingButton.setDisable(true);
            runningVoteTextField.setText("Organize new Voting.");
            runningVoteTextField2.setText("Organize new Voting.");
        }
        else {
            startVotingEventDevelopementButton.setDisable(true);
            runningVoteTextField.setText(votingProj.get(0).getProjectName());
            runningVoteTextField2.setText(votingProj.get(0).getProjectName());
            pos = positive; neg = negative; neut = neutral;
            showPieChart();
            
        }
        
    }    
    
    private void showPieChart(){
        // Initializing the PieChart and adding the data in PieChart 
        pieChart.getData().clear();
        ObservableList<PieChart.Data>PieChar = FXCollections.observableArrayList();
        PieChar.add(new PieChart.Data("Negative", neg));
        PieChar.add(new PieChart.Data("Neutral", neut));
        PieChar.add(new PieChart.Data("Positive", pos));
        
        pieChart.getData().addAll(PieChar);
        
        for(PieChart.Data data1: pieChart.getData()){
            data1.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, 
                    new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    StatusLabel.setText(String.valueOf(data1.getName()));
                DecimalFormat decimalFormat = new DecimalFormat("0.00");
                double selected = (data1.getPieValue());
                double percentage = (selected/Double.parseDouble(String.valueOf((pos + neg + neut))))*Double.parseDouble("100");
                PercentLabel.setText(String.valueOf(decimalFormat.format(percentage))+ "%");
                }
            }
            );
        }
    }

    @FXML
    private void startVotingEventDevelopementButtonOnClick(ActionEvent event) {
        try{
            if (chooseProjectComboBox.getValue() == null) throw new RuntimeException("Select the Combo Box.");
            if (selectDateDevelopement.getValue() == null) throw new RuntimeException("Select the Combo Box.");
            if ( GenerateAlerts.confirmationAlert() ) {
                CantonmentBoardMember.organizeNewVote(chooseProjectComboBox.getValue(), selectDateDevelopement.getValue());
            }
            runningVoteTextField.setText(chooseProjectComboBox.getValue());
            runningVoteTextField2.setText(chooseProjectComboBox.getValue());
            GenerateAlerts.successfulAlert("New Voting System Created Successfully.");
            startVotingEventDevelopementButton.setDisable(true);
            showPieChart();
        }
        catch (RuntimeException e){
            GenerateAlerts.unsuccessfulAlert(e.toString());
            
        }
    }

    @FXML
    private void endVotingButtonOnClick(ActionEvent event) {
        developementProject dummyInstance = new developementProject("", LocalDate.of(2023, 03, 10), new ArrayList<String>());
        developementProjectVoting dummyProj = new developementProjectVoting("Empty", dummyInstance, LocalDate.of(2023, 03, 10) );
        
        DataReadWrite.overWriteObjectToFile("developementProjectVoting.bin", dummyProj);
        
        runningVoteTextField.setText("Organize new Voting.");
        runningVoteTextField2.setText("Organize new Voting.");
        
        endVotingButton.setDisable(true);
        startVotingEventDevelopementButton.setDisable(false);
        pieChart.getData().clear();
    }

    @FXML
    private void chooseProjectComboBoxOnSelection(ActionEvent event) {
        for ( developementProject comboBoxData : projectDevPlan ){
            if ( comboBoxData.getProjectName().equals(chooseProjectComboBox.getValue()) ){
                for ( String description : comboBoxData.getProjectDescription() ){
                    loadDevelopementPlanTxtArea.appendText(description + "\n");
                }
            }
        }
    }

    
}
