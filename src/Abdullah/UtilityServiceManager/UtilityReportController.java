/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Abdullah.UtilityServiceManager;

import MdHasibHasan.DataReadWrite;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;


/**
 * FXML Controller class
 *
 * @author user
 */
public class UtilityReportController implements Initializable {

    /**
     * Initializes the controller class.
     */
     private ObservableList<ServiceProvider> spList;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createPdfBtnOnClick(ActionEvent event) {
        ServiceProvider pb = new ServiceProvider("","","","","","",LocalDate.of(2023,07,07));
        spList = (ObservableList<ServiceProvider>) DataReadWrite.readObjectToFile("ServiceProviders.bin", pb);
        
        UtilityServiceManager.crreatePdfReport(spList);
        
    }
    
}
