/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Abdullah.UtilityServiceManager;

import AbdullahAlMamun.FeedBack;
import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author user
 */
public class UtilitySereviceManagerResidentPortalController implements Initializable {

    @FXML
    private ComboBox<String> selectfeedBackTypeComboBox;
    @FXML
    private TableView<FeedBack> feedbackTableVIew;
    @FXML
    private TableColumn<FeedBack, String> deptTableCol;
    @FXML
    private TableColumn<FeedBack, String> residentIdTableCol;
    @FXML
    private TableColumn<FeedBack, String> houseNoTableViewfxid;
    @FXML
    private TableColumn<FeedBack, String> announcementTypeTableViewfxid;
    @FXML
    private TableColumn<FeedBack, String> announcementTextTableViewfxid;
    @FXML
    private TableColumn<FeedBack, LocalDate> dateTableViewfxid;
    
    private ObservableList<FeedBack> fbList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        selectfeedBackTypeComboBox.getItems().addAll("Suggestions for Improvement", "New connection", "Connectivity Isue");
        
         // For Table
        deptTableCol.setCellValueFactory(new PropertyValueFactory<FeedBack, String>("Dept"));
        residentIdTableCol.setCellValueFactory(new PropertyValueFactory<FeedBack, String>("residentId"));
        houseNoTableViewfxid.setCellValueFactory(new PropertyValueFactory<FeedBack, String>("houseNo"));
        announcementTypeTableViewfxid.setCellValueFactory(new PropertyValueFactory<FeedBack, String>("annType"));
        announcementTextTableViewfxid.setCellValueFactory(new PropertyValueFactory<FeedBack, String>("announceText"));
        dateTableViewfxid.setCellValueFactory(new PropertyValueFactory<FeedBack, LocalDate>("date"));
        
        
        
        
    }    

    @FXML
    private void loadToTableBtnOnClick(ActionEvent event) {
        FeedBack fb = new FeedBack("","","","","",LocalDate.of(2023,07,07));
        fbList = (ObservableList<FeedBack>) DataReadWrite.readObjectToFile("FeedBack.bin", fb);
        
        for(FeedBack x : fbList){
            if(x.getDept().equals("Utility Service Manager")){
                if(x.getAnnType().equals(selectfeedBackTypeComboBox.getValue())){
                    feedbackTableVIew.getItems().add(x);
                }
                else{
                GenerateAlerts.unsuccessfulAlert("No Feedback for this Type");
            }
            }
            else{
                GenerateAlerts.unsuccessfulAlert("No Feedback for the user Security cheif");
            }
        }
        
    }

    @FXML
    private void seeDetailsInTextAreaBtnOnClick(ActionEvent event) {
    }
    
}
