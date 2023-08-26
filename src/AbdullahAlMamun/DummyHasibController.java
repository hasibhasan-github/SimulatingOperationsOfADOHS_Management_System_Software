/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.CantonmentBoardMember.crucialTaskPermissionRequest;
import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
public class DummyHasibController implements Initializable {

    @FXML
    private DatePicker applicationDatePicker;
    @FXML
    private DatePicker eventDatePicker;
    @FXML
    private TextField eventNameTxtField;
    @FXML
    private TextField eventDescriptionTxtField;
    @FXML
    private ComboBox<String> selectDepartmentOfApplicationComboBox;
    @FXML
    private TextArea eventAllDescritionTxtArea;
    @FXML
    private TextField eventIDTxtField;
    @FXML
    private TableView<crucialTaskPermissionRequest> permissionFromHigherAuthoritiesTableView;
    @FXML
    private TableColumn<crucialTaskPermissionRequest, String> eventNameTableColoumn;
    @FXML
    private TableColumn<crucialTaskPermissionRequest, Integer> eventIDTableColoumn;
    @FXML
    private TableColumn<crucialTaskPermissionRequest, String> permissionStatusTableColoumn;
    @FXML
    private TableColumn<crucialTaskPermissionRequest, LocalDate> applicationDateTableColoumn;
    @FXML
    private TableColumn<crucialTaskPermissionRequest, LocalDate> eventDateTableColoumn;
    @FXML
    private TableColumn<crucialTaskPermissionRequest, String> departmentTableColoumnn;
    @FXML
    private TableColumn<crucialTaskPermissionRequest, ArrayList<String>> eventDescriptionTableColoumn;
    
    private ArrayList<String> eventDescriptionList;
    
    private ObservableList<crucialTaskPermissionRequest> crucTaskReq;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        eventDescriptionList = new ArrayList<String>();
        
        eventNameTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, String>("eventNamme"));
        eventIDTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, Integer>("ID"));
        permissionStatusTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, String>("permissionStatus"));
        departmentTableColoumnn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, String>("department"));
        eventDescriptionTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, ArrayList<String>>("eventDescription"));
        applicationDateTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, LocalDate>("applicationDate"));
        eventDateTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, LocalDate>("eventDate"));
        
        selectDepartmentOfApplicationComboBox.getItems().add("Security");
        
        crucialTaskPermissionRequest dummyInstance = new crucialTaskPermissionRequest(1, "", "", LocalDate.of(2023, 02, 02),
        LocalDate.of(2023, 02, 02), new ArrayList<String>());
        
        crucTaskReq = (ObservableList<crucialTaskPermissionRequest>) DataReadWrite.readObjectToFile("CrucialTaskPermissionRequest.bin", dummyInstance);
        
        permissionFromHigherAuthoritiesTableView.getItems().addAll(crucTaskReq);
        
    }    

    @FXML
    private void addEventDescriptionButtonOnClick(ActionEvent event) {
        try{
            System.out.println(eventDescriptionTxtField.getText().isEmpty());
            if (eventDescriptionTxtField.getText().isEmpty() ) throw new RuntimeException("Event description cannot be empty.");
            else eventDescriptionList.add(eventDescriptionTxtField.getText());
            eventAllDescritionTxtArea.appendText(eventDescriptionTxtField.getText() + "\n");
            eventDescriptionTxtField.clear();
        }
        catch ( RuntimeException e){
            GenerateAlerts.unsuccessfulAlert("Please write Event Description.");
        }
    }

    @FXML
    private void requestForPermissionButtonOnClick(ActionEvent event) {
        try{
            crucialTaskPermissionRequest newReq = new crucialTaskPermissionRequest(Integer.parseInt(eventIDTxtField.getText()),
            eventNameTxtField.getText(), selectDepartmentOfApplicationComboBox.getValue(), applicationDatePicker.getValue(), 
            eventDatePicker.getValue(), eventDescriptionList);
            if ( GenerateAlerts.confirmationAlert() ) {
                SecurityCheif.requestPermissionForCrucialTask(newReq);
            }
            eventDescriptionList.clear();
            eventNameTxtField.clear();
            eventIDTxtField.clear();
            selectDepartmentOfApplicationComboBox.setValue(null);
            applicationDatePicker.setValue(null);
            eventDatePicker.setValue(null);
            eventAllDescritionTxtArea.clear();
        }
        catch ( Exception e ){
            GenerateAlerts.unsuccessfulAlert("Please Fill all the Information Carefully and try again.");
        }
    }

    @FXML
    private void refreshButtonOnClick(ActionEvent event) {
    }
    
}
