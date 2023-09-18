/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.CantonmentBoardMember.sendNotice;
import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.downloadNoticePDF;
import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */

public class NoticeSceneController implements Initializable {

    @FXML
    private TableView<sendNotice> noticeTableView;
    @FXML
    private TableColumn<sendNotice, String> noticeTableColoumn;
    @FXML
    private TableColumn<sendNotice, String> subjectTableColoumn;
    @FXML
    private TableColumn<sendNotice, LocalDate> dateTableColoumn;
    @FXML
    private TableColumn<sendNotice, ArrayList<String>> noticeDescriptionTableColoumn;
    @FXML
    private TableColumn<sendNotice, String> departmentTableColoumn;
    
    @FXML
    private TextArea noticeExpandedView;
    
    private ObservableList<sendNotice> noticeList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        noticeList = FXCollections.observableArrayList();
        
        noticeTableColoumn.setCellValueFactory(new PropertyValueFactory<sendNotice, String>("noticeName"));
        subjectTableColoumn.setCellValueFactory(new PropertyValueFactory<sendNotice, String>("noticeSubject"));
        departmentTableColoumn.setCellValueFactory(new PropertyValueFactory<sendNotice, String>("noticeForPeopleType"));
        dateTableColoumn.setCellValueFactory(new PropertyValueFactory<sendNotice, LocalDate>("noticeDate"));
        noticeDescriptionTableColoumn.setCellValueFactory(new PropertyValueFactory<sendNotice, ArrayList<String>>("noticeDescription"));
        
        sendNotice notice = new sendNotice("", "", "", LocalDate.of(2023, 02, 02), new ArrayList<String>());
        
        ObservableList<sendNotice> unUpdateList = (ObservableList<sendNotice>) DataReadWrite.readObjectToFile("DOHSNotice.bin", notice);
       
        for (sendNotice data : unUpdateList  ){
            if ( data.getNoticeForPeopleType().equals("Maintenace Department") ) {
                noticeList.add(data);
            }
        }
        
        noticeTableView.getItems().addAll(noticeList);
    }    

    @FXML
    private void loadFullNoticeButtonOnClick(ActionEvent event) {
        try{
            // Throwing an Exception if Table row is not Selected.
            if ( noticeTableView.getSelectionModel().getSelectedItem() == null ) throw new RuntimeException("Exception");
            // Clearing the Text Of noticeExpandedView.
              noticeExpandedView.clear();
            // Adding the selected data description in the noticeExpandedView Text Area from Table.
            for ( sendNotice tmp : noticeList ){
                if ( tmp == noticeTableView.getSelectionModel().getSelectedItem() ){
                    for ( String data : tmp.getNoticeDescription() ){
                        noticeExpandedView.appendText(data + "\n");
                }
            }
        }
        }
        catch( RuntimeException e ) {
            GenerateAlerts.unsuccessfulAlert("Please Select the File from Table to Load.");
        }
    }

    private void goBackBuuttonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/MaintenanceOfficerDashboard.fxml");
    }

    @FXML
    private void downloadPDFButtonOnClick(ActionEvent event) {
        try{
            if ( noticeTableView.getSelectionModel().getSelectedItem() == null ) throw new RuntimeException("Exception");
            else downloadNoticePDF.downloadNoticePDF((sendNotice) noticeTableView.getSelectionModel().getSelectedItem());
        }
        catch(RuntimeException ee ){
            GenerateAlerts.unsuccessfulAlert("Please Select the File from Table to Load.");
        }
    }

    @FXML
    private void goBackButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/MdHasibHasan/MaintenanceOfficer/MaintenanceOfficerDashboard.fxml");
    
    }
    
}
