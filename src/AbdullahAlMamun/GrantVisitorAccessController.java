/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class GrantVisitorAccessController implements Initializable {

    @FXML
    private TableView<VisitorRequest> VisitorDataTableView;
    @FXML
    private TableColumn<VisitorRequest, String> nameCol;
    @FXML
    private TableColumn<VisitorRequest, String> PhoneNoCol;
    @FXML
    private TableColumn<VisitorRequest, String> povCol;
    @FXML
    private TableColumn<VisitorRequest, String> timeSlotCol;
    @FXML
    private TableColumn<VisitorRequest, String> statusCol;
    
    private ObservableList<VisitorRequest> dataOfVisitorRequest;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        nameCol.setCellValueFactory(new PropertyValueFactory<VisitorRequest, String>("Name"));
        PhoneNoCol.setCellValueFactory(new PropertyValueFactory<VisitorRequest, String>("Phone No"));
        povCol.setCellValueFactory(new PropertyValueFactory<VisitorRequest, String>("Purpose Of Visit"));
        timeSlotCol.setCellValueFactory(new PropertyValueFactory<VisitorRequest, String>("Time Slot"));
        statusCol.setCellValueFactory(new PropertyValueFactory<VisitorRequest, String>("Status"));
        
        VisitorRequest visitorReq = new VisitorRequest("","","","","");
        dataOfVisitorRequest = (ObservableList<VisitorRequest>) DataReadWrite.readObjectToFile("VisitorRequest.bin", visitorReq);
        
        VisitorDataTableView.getItems().addAll(dataOfVisitorRequest);
    }    

    @FXML
    private void approveButtonOnClick(ActionEvent event) {
        VisitorRequest ApproveList = VisitorDataTableView.getSelectionModel().getSelectedItem();
        if (VisitorDataTableView.getSelectionModel().isSelected(0)) GenerateAlerts.successfulAlert("Please Select Table Item.");
        // Clearing table data list
        VisitorDataTableView.getItems().clear();
        // Approving Car Sticker Request by model class static method.
        VisitorDataTableView.getItems().addAll(SecurityCheif.gantAccessPermission(dataOfVisitorRequest, ApproveList));
    }
    
}
