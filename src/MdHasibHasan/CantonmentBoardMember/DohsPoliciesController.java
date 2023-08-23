/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class DohsPoliciesController implements Initializable {

    @FXML
    private TableView<dohsPolicies> policyTableView;
    @FXML
    private TableColumn<dohsPolicies, String> policyNameTableColoumn;
    @FXML
    private TableColumn<dohsPolicies, LocalDate> policyCreationDateTableColoumn;
    @FXML
    private TableColumn<dohsPolicies, LocalDate> policyEditionTableColoumn;
    @FXML
    private TableColumn<dohsPolicies, ArrayList<String>> policyDescriptionTableColoumn;
    @FXML
    private TextField policyNameTextField;
    @FXML
    private DatePicker policyCreationDatePicker;
    @FXML
    private TextField policyDescriptionTextField;
    @FXML
    private TextArea showAddedPolicyDescriiptionTextArea;
    @FXML
    private TextField policyCreationDateTextField;
    @FXML
    private ComboBox<String> selectPolicyComboBox;
    @FXML
    private DatePicker policyEditionDatePicker;
    @FXML
    private ListView<String> policyDescriptionListView;
    
    private ArrayList<String> policyDescriptionList;
    
    private ObservableList<dohsPolicies> policyListOfDohs;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        policyDescriptionList = new ArrayList<String>();
        dohsPolicies dummyInstance = new dohsPolicies("", LocalDate.of(2023, 02, 02),
                                                LocalDate.of(2023, 02, 02), new ArrayList<String>());
        policyListOfDohs = (ObservableList<dohsPolicies>) DataReadWrite.readObjectToFile("DOHSPOLICIES.bin", dummyInstance);
        for ( dohsPolicies policyData : policyListOfDohs ){
            selectPolicyComboBox.getItems().add(policyData.getPolicyName());
        } 
        // Setting up the Table Data 
        policyNameTableColoumn.setCellValueFactory(new PropertyValueFactory<dohsPolicies, String>("policyName"));
        policyCreationDateTableColoumn.setCellValueFactory(new PropertyValueFactory<dohsPolicies, LocalDate>("policyCreationDate"));
        policyEditionTableColoumn.setCellValueFactory(new PropertyValueFactory<dohsPolicies, LocalDate>("policyLastEditedDate"));
        policyDescriptionTableColoumn.setCellValueFactory(new PropertyValueFactory<dohsPolicies, ArrayList<String>>("policyDescription"));
        
        policyTableView.getItems().addAll(policyListOfDohs);
        
    }    


    @FXML
    private void deletePolicyButtonOnClick(ActionEvent event) {
        // Using try catch to give user prompt if he forgot to select the table item and accidently pressed Delete Button.
        try{
        // Getting the selected dohsPoliciies Instance from Table  
        dohsPolicies deletePolicy = policyTableView.getSelectionModel().getSelectedItem();
        ObservableList<dohsPolicies> updatedPolicyListOfDohs = CantonmentBoardMember.deleteAnOldPolicy(deletePolicy);
        // Updating the table view list
        policyTableView.getItems().clear();
        policyTableView.getItems().addAll(updatedPolicyListOfDohs);
        }
        catch (Exception e) {
            GenerateAlerts.unsuccessfulAlert("Please select the policy from table.");
        }
        
    }

    @FXML
    private void addPolicyDescriptionButtonOnClick(ActionEvent event) {
        // Adding the policy Description to the ArrayList.
        policyDescriptionList.add(policyDescriptionTextField.getText());
        showAddedPolicyDescriiptionTextArea.appendText(policyDescriptionTextField.getText() + "\n");
        // Clearing the Policy Description Text Field.
        policyDescriptionTextField.clear();
    }

    @FXML
    private void addANewPolicyButtonOnClick(ActionEvent event) {
        // Using try catch to handle fields input exceptions
        try{
            // Confirming Before processing.
            if ( GenerateAlerts.confirmationAlert() ){ 
                // Creating instance of dohsPolicies for writing in the bin File.
                dohsPolicies newPolicy = new dohsPolicies(policyNameTextField.getText(), policyCreationDatePicker.getValue(),
                                                    policyCreationDatePicker.getValue(), policyDescriptionList );
                // Writing the new Policy to the Bin File.
                CantonmentBoardMember.implyNewPoliciesAndGuidelines(newPolicy);
            }
            // Clearing the input fields and ArrayList.
            policyDescriptionList.clear();
            policyDescriptionTextField.clear();
            policyNameTextField.clear();
            showAddedPolicyDescriiptionTextArea.clear();
            policyCreationDatePicker.setValue(null);
        }
        catch ( Exception ex){
            // Showing unsuccessful Alert if some fields input are missing.
            GenerateAlerts.unsuccessfulAlert("Please fillup all the fields.");
        }
    }

    @FXML
    private void updatePolicyDescriptionButtonOnClick(ActionEvent event) {
        // Clearing All the data Fields
        policyCreationDateTextField.clear();
        policyDescriptionListView.getItems().clear();
        selectPolicyComboBox.setValue(null);
        selectPolicyComboBox.getItems().clear();
        
        dohsPolicies dummyInstance = new dohsPolicies("", LocalDate.of(2023, 02, 02),
                                                LocalDate.of(2023, 02, 02), new ArrayList<String>());
        policyListOfDohs = (ObservableList<dohsPolicies>) DataReadWrite.readObjectToFile("DOHSPOLICIES.bin", dummyInstance);
        for ( dohsPolicies policyData : policyListOfDohs ){
            selectPolicyComboBox.getItems().add(policyData.getPolicyName());
        } 
    }

    @FXML
    private void policyNameSelectOnActionEvent(ActionEvent event) {
        policyCreationDateTextField.clear();
        policyDescriptionListView.getItems().clear();
        for ( dohsPolicies policyData : policyListOfDohs ){
            if ( policyData.getPolicyName().equals(selectPolicyComboBox.getValue()) ){
                policyCreationDateTextField.setText(String.valueOf(policyData.getPolicyCreationDate()));
                for ( String policyDescriptionData : policyData.getPolicyDescription()){
                    policyDescriptionListView.getItems().add(policyDescriptionData);
                }
            }
        }
    }

    @FXML
    private void updatePolicyTableButtonOnClick(ActionEvent event) {
        // Updating the newly added dohsPoliciies Instance to Table  
        dohsPolicies dummyInstance = new dohsPolicies("", LocalDate.of(2023, 02, 02),
                                                LocalDate.of(2023, 02, 02), new ArrayList<String>());
        ObservableList<dohsPolicies> policyListOfDohs = (ObservableList<dohsPolicies>) DataReadWrite.readObjectToFile("DOHSPOLICIES.bin", dummyInstance);
        
        // Updating the table view list
        policyTableView.getItems().clear();
        policyTableView.getItems().addAll(policyListOfDohs);
    }
    
}
