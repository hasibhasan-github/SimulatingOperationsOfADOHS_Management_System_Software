/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.downloadNoticePDF;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

public class SendNoticceSceneController implements Initializable {

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
    @FXML
    private TextField noticeNameTxtField;
    @FXML
    private DatePicker noticeDatePicker;
    @FXML
    private ComboBox<String> noticeForPeopleTypeComboBox;
    @FXML
    private TextField noticeSubjectTxtField;
    @FXML
    private TextField noticeDescriptionTxtField;
    @FXML
    private TextArea noticeDescriptionViewTxtArea;
    
    private ArrayList<String> noticeDescriptionList;
    
    private ObservableList<sendNotice> noticeList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        noticeDescriptionList = new ArrayList<String>();
        
        noticeForPeopleTypeComboBox.getItems().addAll("Resident", "Visitor", "Maintenace Department");
        
        noticeTableColoumn.setCellValueFactory(new PropertyValueFactory<sendNotice, String>("noticeName"));
        subjectTableColoumn.setCellValueFactory(new PropertyValueFactory<sendNotice, String>("noticeSubject"));
        departmentTableColoumn.setCellValueFactory(new PropertyValueFactory<sendNotice, String>("noticeForPeopleType"));
        dateTableColoumn.setCellValueFactory(new PropertyValueFactory<sendNotice, LocalDate>("noticeDate"));
        noticeDescriptionTableColoumn.setCellValueFactory(new PropertyValueFactory<sendNotice, ArrayList<String>>("noticeDescription"));
        
        sendNotice notice = new sendNotice("", "", "", LocalDate.of(2023, 02, 02), new ArrayList<String>());
        
        noticeList = (ObservableList<sendNotice>) DataReadWrite.readObjectToFile("DOHSNotice.bin", notice);
       
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

    @FXML
    private void deleteNoticeButtonOnClick(ActionEvent event) {
        try{
            if ( noticeTableView.getSelectionModel().getSelectedItem() == null ) throw new RuntimeException("Exception");
            if ( GenerateAlerts.confirmationAlert() ){
                ObservableList<sendNotice> updateNoticeList = CantonmentBoardMember.deleteNotice(noticeTableView.getSelectionModel().getSelectedItem());
                noticeTableView.getItems().clear();
                noticeTableView.getItems().addAll(updateNoticeList);
                noticeDescriptionTxtField.clear();
                noticeExpandedView.clear();
            }
        }
        catch(RuntimeException ee){
            GenerateAlerts.unsuccessfulAlert("Please Select the File from Table to Load.");
        }
    }

    @FXML
    private void addNoticeDescriptionButtonOnClick(ActionEvent event) {
        try{
            if (noticeDescriptionTxtField.getText().isEmpty() ) throw new RuntimeException("Notice description cannot be empty.");
            else noticeDescriptionList.add(noticeDescriptionTxtField.getText());
            noticeDescriptionViewTxtArea.appendText(noticeDescriptionTxtField.getText() + "\n");
            noticeDescriptionTxtField.clear();
        }
        catch ( RuntimeException e){
            GenerateAlerts.unsuccessfulAlert("Please write Notice Description.");
        }
    }

    @FXML
    private void sendNoticeButtonOnClick(ActionEvent event) {
        try{
            sendNotice newNotice = new sendNotice(noticeNameTxtField.getText(), noticeSubjectTxtField.getText(), 
            noticeForPeopleTypeComboBox.getValue(), noticeDatePicker.getValue(), noticeDescriptionList );
            if ( GenerateAlerts.confirmationAlert() ) {
                CantonmentBoardMember.sendImportantNotice(newNotice);
            }
            noticeDescriptionList.clear();
            noticeNameTxtField.clear();
            noticeSubjectTxtField.clear();
            noticeForPeopleTypeComboBox.setValue(null);
            noticeDatePicker.setValue(null);
            noticeDescriptionViewTxtArea.clear();
        }
        catch ( Exception e ){
            GenerateAlerts.unsuccessfulAlert("Please Fill all the Information Carefully and try again.");
        }
    }

    @FXML
    private void downloadNoticePDFButtonOnClick(ActionEvent event) {
        try{
            if ( noticeTableView.getSelectionModel().getSelectedItem() == null ) throw new RuntimeException("Exception");
            else downloadNoticePDF.downloadNoticePDF(noticeTableView.getSelectionModel().getSelectedItem());
        }
        catch(RuntimeException ee ){
            GenerateAlerts.unsuccessfulAlert("Please Select the File from Table to Load.");
        }
    }

    @FXML
    private void refreshTableButtonOnClick(ActionEvent event) {
        noticeExpandedView.clear();
        ObservableList<sendNotice> noticeNewList = (ObservableList<sendNotice>) DataReadWrite.readObjectToFile("DOHSNotice.bin", noticeList.get(0));
        noticeTableView.getItems().clear();
        noticeList.clear();
        noticeList.addAll(noticeNewList);
        noticeTableView.getItems().addAll(noticeNewList);
    } 
    
}
