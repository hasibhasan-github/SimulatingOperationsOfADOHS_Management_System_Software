/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class permissionRequestSceneController implements Initializable {

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
    
    private ObservableList<crucialTaskPermissionRequest> crucTaskReq;
    
    private ObservableList<crucialTaskPermissionRequest> updatedCrucTaskReq;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        updatedCrucTaskReq = FXCollections.observableArrayList();
       
        eventNameTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, String>("eventNamme"));
        eventIDTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, Integer>("ID"));
        permissionStatusTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, String>("permissionStatus"));
        departmentTableColoumnn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, String>("department"));
        eventDescriptionTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, ArrayList<String>>("eventDescription"));
        applicationDateTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, LocalDate>("applicationDate"));
        eventDateTableColoumn.setCellValueFactory(new PropertyValueFactory<crucialTaskPermissionRequest, LocalDate>("eventDate"));
        
        crucialTaskPermissionRequest dummyInstance = new crucialTaskPermissionRequest(1, "", "", LocalDate.of(2023, 02, 02),
        LocalDate.of(2023, 02, 02), new ArrayList<String>());
        
        crucTaskReq = (ObservableList<crucialTaskPermissionRequest>) DataReadWrite.readObjectToFile("CrucialTaskPermissionRequest.bin", dummyInstance);
        
        permissionFromHigherAuthoritiesTableView.getItems().addAll(crucTaskReq);
    }    
    
    private void refreshTable(){
        updatedCrucTaskReq.clear();
        permissionFromHigherAuthoritiesTableView.getItems().clear();
        updatedCrucTaskReq = CantonmentBoardMember.acceptOrRejectPendingPermission(crucTaskReq);
        permissionFromHigherAuthoritiesTableView.getItems().addAll(updatedCrucTaskReq);
        
    }

    @FXML
    private void acceptButtonOnClick(ActionEvent event) {
        try { 
            if ( permissionFromHigherAuthoritiesTableView.getSelectionModel().getSelectedItem() == null ){
                throw new RuntimeException("Table Selection cannot be empty.");
            }
            for ( crucialTaskPermissionRequest taskReqData : crucTaskReq ) {
                if ( taskReqData == permissionFromHigherAuthoritiesTableView.getSelectionModel().getSelectedItem() ){
                    taskReqData.setPermissionStatus("Accepted");
                    break;
                }
            }
            refreshTable();
        }
        catch (RuntimeException e){
            GenerateAlerts.unsuccessfulAlert(e.toString());
        }
  
    }

    @FXML
    private void rejectButtonOnClick(ActionEvent event) {
        try { 
            if ( permissionFromHigherAuthoritiesTableView.getSelectionModel().getSelectedItem() == null ){
                throw new RuntimeException("Table Selection cannot be empty.");
            }
            for ( crucialTaskPermissionRequest taskReqData : crucTaskReq ) {
                if ( taskReqData == permissionFromHigherAuthoritiesTableView.getSelectionModel().getSelectedItem() ){
                    taskReqData.setPermissionStatus("Rejected");
                    break;
                }
            }
            refreshTable();
        }
        catch (RuntimeException e){
            GenerateAlerts.unsuccessfulAlert(e.toString());
        }
    }

    @FXML
    private void DOWNLoadPDFButtonOnClick(ActionEvent event) {
        try{
            if ( permissionFromHigherAuthoritiesTableView.getSelectionModel().getSelectedItem() == null ){
                throw new RuntimeException("Table Selection cannot be empty.");
            }
            else{
                CantonmentBoardMember.viewPendingPermissionPDF(permissionFromHigherAuthoritiesTableView.getSelectionModel().getSelectedItem());
            }
        }
        catch (RuntimeException ee){
            GenerateAlerts.unsuccessfulAlert(ee.toString());
            
        }
    }
    
}
