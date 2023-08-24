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
public class DevelopmentPalnsAndProjectsController implements Initializable {

    @FXML
    private TableView<developementProject> developementProjectTableView;
    @FXML
    private ListView<String> developementProjectDescriptionList;
    @FXML
    private TableColumn<developementProject, String> projectNameTableColoumn;
    @FXML
    private TableColumn<developementProject, LocalDate> startDateTableColoumn;
    @FXML
    private TableColumn<developementProject, ArrayList<String>> projectDescriptionTableColoumn;
    @FXML
    private TextField projectDescriptionTextField;
    @FXML
    private TextArea projectDescriptionTextArea;
    @FXML
    private TextField projectNameTextField;
    @FXML
    private DatePicker projectStartDatePicker;
    
    private ArrayList<String> projectDescription;
    
    private ObservableList<developementProject> projectDevPlan;


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        // Initializing the ArrayList For Project Description.
        projectDescription = new ArrayList<String>();
        // Initializing the Table Coloumn Data
        projectNameTableColoumn.setCellValueFactory(new PropertyValueFactory<developementProject, String>("projectName"));
        startDateTableColoumn.setCellValueFactory(new PropertyValueFactory<developementProject, LocalDate>("projectStartDate"));
        projectDescriptionTableColoumn.setCellValueFactory(new PropertyValueFactory<developementProject, ArrayList<String>>("projectDescription"));
        //  Creating Dummy Instance to Read The File Data of "DevelopmentProjects.bin".
        developementProject dummyInstance = new developementProject("", LocalDate.of(2023, 03, 10), new ArrayList<String>());
        // Reading the data From File.
        projectDevPlan = (ObservableList<developementProject>) DataReadWrite.readObjectToFile("DevelopmentProjects.bin", dummyInstance);
        // Adding the Observable List of Data(From File reading) to the developementProjectTableView
        developementProjectTableView.getItems().addAll(projectDevPlan);    
        
    }    

    @FXML
    private void loadSelectedProjectDetailsButtonOnClick(ActionEvent event) {
        try{
            // Throwing an Exception if Table row is not Selected.
            if ( developementProjectTableView.getSelectionModel().getSelectedItem() == null ) throw new RuntimeException("Exception");
            // Clearing the ArrayList Of List View.
            developementProjectDescriptionList.getItems().clear();
            // Adding the selected data description in the List View from Table.
            for ( developementProject tmp : projectDevPlan ){
                if ( tmp == developementProjectTableView.getSelectionModel().getSelectedItem() ){
                    developementProjectDescriptionList.getItems().addAll(tmp.getProjectDescription());
                }
            }
        }
        catch( RuntimeException e ) {
            GenerateAlerts.unsuccessfulAlert("Please Select the File from Table to Load.");
        }
    }

    @FXML
    private void addProjectDescriptionButtonOnClick(ActionEvent event) {
        // Adding new Project Description String to the Array.
        projectDescription.add(projectDescriptionTextField.getText());
        // Showing the Currently Stored Array Data in Text Area.
        projectDescriptionTextArea.appendText(projectDescriptionTextField.getText()+"\n");
        // Clearing the Text Field after adding the String to the ArrrayList.
        projectDescriptionTextField.clear();
    }

    @FXML
    private void publishNewCreatedDevelopementProject(ActionEvent event) {
        // Creating new Development plan Data and writing on the File.
        try{
            if ( GenerateAlerts.confirmationAlert() ) {
                // Creating the new instance 
                developementProject newDevProject = new developementProject(projectNameTextField.getText(), 
                        projectStartDatePicker.getValue(), projectDescription);
                // Calling out the Model Class Method.
                CantonmentBoardMember.planOrAddNewDevelopementProject(newDevProject);
            }
            // Clearing all the Fields.
            projectNameTextField.clear(); 
            projectStartDatePicker.setValue(null);
            projectDescription.clear();
            projectDescriptionTextArea.clear();
            // Clearing the ArrayList projectDevPlan Data.
            projectDevPlan.clear();
        }
        catch (Exception e){
            // For any kind of input error giving Alert.
            GenerateAlerts.unsuccessfulAlert("Please check the details and try again.");
        }
       
        
    }

    @FXML
    private void refreshDevelopementProjectTableButtonOnClick(ActionEvent event) {
        // Clearing the ObservableList data in the developementProjectTableView
        developementProjectTableView.getItems().clear();
        // Clearing the ArrayList projectDevPlan Data.
        projectDevPlan.clear();
        //  Creating Dummy Instance to Read The File Data of "DevelopmentProjects.bin".
        developementProject dummyInstance = new developementProject("", LocalDate.of(2023, 03, 10), new ArrayList<String>());
        // Reading the data From File.
        projectDevPlan = (ObservableList<developementProject>) DataReadWrite.readObjectToFile("DevelopmentProjects.bin", dummyInstance);
        // Adding the Observable List of Data(From File reading) to the developementProjectTableView
        developementProjectTableView.getItems().addAll(projectDevPlan);
        
    }

    @FXML
    private void downloadSelectedProjectDetailsPDFButtonOnClick(ActionEvent event) {
        try {
             // Throwing an Exception if Table row is not Selected.
            if ( developementProjectTableView.getSelectionModel().getSelectedItem() == null ) throw new RuntimeException("Exception");
            CantonmentBoardMember.generateDevelopementProjectPDF(developementProjectTableView.getSelectionModel().getSelectedItem());
        }
        catch (RuntimeException e){
            GenerateAlerts.unsuccessfulAlert("Please Select the File from Table to Load.");
        }
    }
    
}
