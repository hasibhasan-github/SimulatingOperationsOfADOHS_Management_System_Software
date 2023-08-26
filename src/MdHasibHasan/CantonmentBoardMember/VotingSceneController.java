/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class VotingSceneController implements Initializable {

    @FXML
    private ComboBox<?> chooseProjectComboBox;
    @FXML
    private TextField runningVoteTextField;
    @FXML
    private ComboBox<?> choosePolicy;
    @FXML
    private Button startVotingEventDevelopementButtonOnClick;
    @FXML
    private DatePicker selectDateDevelopement;
    @FXML
    private DatePicker selectDatePolicy;
    @FXML
    private Button startVotingEventDohsButtonOnClick;
    @FXML
    private PieChart pieChart;
    @FXML
    private TextField runningVoteTextField2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
