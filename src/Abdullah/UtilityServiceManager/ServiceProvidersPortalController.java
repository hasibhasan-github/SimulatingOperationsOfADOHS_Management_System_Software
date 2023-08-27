/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Abdullah.UtilityServiceManager;

import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.sceneChanging;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ServiceProvidersPortalController implements Initializable {

    @FXML
    private TextField providerNameFxid;
    @FXML
    private TextField licenceNofxid;
    @FXML
    private ComboBox<String> serviceTypeComboBoxfxid;
    @FXML
    private DatePicker issueDateFxid;
    @FXML
    private TextField activeWorkersFxid;
    @FXML
    private TextField contractDurationFxid;
    @FXML
    private Button addNewProviderBtn;
    @FXML
    private TextField contactNo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        serviceTypeComboBoxfxid.getItems().addAll("Gas Service", "Electricity Service", "Water Service");
        
    }    

    @FXML
    private void addNewProviderBtnOnClick(ActionEvent event) {
        try{
            String providerName = providerNameFxid.getText();
            String licenceNo = licenceNofxid.getText();
            String serviceType = serviceTypeComboBoxfxid.getValue();
            LocalDate issueDate = issueDateFxid.getValue();
            String activeWorkers = activeWorkersFxid.getText();
            String contractDuration = contractDurationFxid.getText();
            String contactNumber = contactNo.getText();

            if (providerName.isEmpty() || licenceNo.isEmpty() || serviceType == null ||
                issueDate == null || activeWorkers.isEmpty() || contractDuration.isEmpty() || contactNumber.isEmpty()) {
                GenerateAlerts.unsuccessfulAlert("Please fill in all fields.");
                return; 
                }
            ServiceProvider sp = new ServiceProvider(providerName, serviceType, licenceNo, contactNumber, contractDuration, activeWorkers,issueDate);
            UtilityServiceManager.addNewServiceProvider(sp);
            addNewProviderBtn.setDisable(true);
        }
        catch(Exception ee){
            GenerateAlerts.unsuccessfulAlert("An error occurred. Please try again.");
        }
        
        
        
    }

    @FXML
    private void seeProviderListButtonOnClick(ActionEvent event) throws IOException {
        ServiceProvider pb = new ServiceProvider("","","","","","",LocalDate.of(2023,07,07));
        sceneChanging newwscene = new sceneChanging();
        newwscene.windowSwitchingWithDataPassing( "/Abdullah/UtilityServiceManager/ProviderDetails.fxml", "ServiceProvider", pb);
    }
    
}
