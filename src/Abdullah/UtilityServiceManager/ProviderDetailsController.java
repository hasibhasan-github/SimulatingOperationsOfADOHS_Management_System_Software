/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Abdullah.UtilityServiceManager;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ProviderDetailsController implements Initializable {

    @FXML
    private ListView<String> providerNameList;
    @FXML
    private TextArea providerDetailsTextArea;
    
    private ObservableList<ServiceProvider> spList;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceProvider pb = new ServiceProvider("","","","","","",LocalDate.of(2023,07,07));
        spList = (ObservableList<ServiceProvider>) DataReadWrite.readObjectToFile("ServiceProviders.bin", pb);
        
        for(ServiceProvider x : spList){
            String name = x.getProviderName();
            providerNameList.getItems().add(name);
            
        }
        
    }    

    @FXML
    private void loadDetailsButtonOnClick(ActionEvent event) {
        try{
            providerDetailsTextArea.clear();
            if ( providerNameList.getSelectionModel().getSelectedItem() == null ) throw new RuntimeException("Exception");
            for(ServiceProvider y : spList){
                if(providerNameList.getSelectionModel().getSelectedItem().equals(y.getProviderName())){
                    providerDetailsTextArea.appendText(y.toString());
                }
            }
            
        }
         catch( RuntimeException e ) {
            GenerateAlerts.unsuccessfulAlert("Please Select the File from Table to Load.");
        }
    }
    
}
