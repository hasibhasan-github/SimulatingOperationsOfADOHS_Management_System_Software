/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.DummyUser;

import MdHasibHasan.CantonmentBoardMember.dohsPolicies;
import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.MaintenanceOfficer.PublicProperties;
import MdHasibHasan.MaintenanceOfficer.carStickerRequest;
import MdHasibHasan.MaintenanceOfficer.maintenanceFee;
import MdHasibHasan.sceneChanging;
import MdHasibHasan.signUpData;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Hasib
 */
public class ResidentDashboardController implements Initializable {
    
    @FXML
    private TextField applicationStatusLabel;
    
    private signUpData currentlyLoggedInUserInfo;
    
    private boolean applied;
    @FXML
    private TextArea loadPolicies;
    @FXML
    private Button applyForCarStickerLabel;
    @FXML
    private TextField maintenanceFeeStatusLabel;
    @FXML
    private ComboBox<String> maintenceFeeMonthComboBox;
    @FXML
    private ComboBox<String> maintenceFeeYearComboBox;
    @FXML
    private Button payMaintenanceFeeButton;
    
    private ObservableList<maintenanceFee> feeList;
    @FXML
    private ComboBox<String> donationMonthComboBox;
    @FXML
    private ComboBox<String> donationYearComboBox;
    @FXML
    private ComboBox<String> donatingOrganizationComboBox;
    @FXML
    private TextField donationgAmountTextField;
    @FXML
    private Button donateButton;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        maintenanceFeeStatusLabel.setText("Unpaid");
        //System.out.println(currentlyLoggedInUserInfo.getEmail());
        applicationStatusLabel.setText("Not Applied");
        
        maintenceFeeMonthComboBox.getItems().addAll("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December");
        maintenceFeeYearComboBox.getItems().addAll("2023", "2024", "2025", "2026", "2027", "2028");
        
        donationMonthComboBox.getItems().addAll(maintenceFeeMonthComboBox.getItems());
        donationYearComboBox.getItems().addAll(maintenceFeeYearComboBox.getItems());
        donatingOrganizationComboBox.getItems().addAll("Mosque", "Hospital", "Park", "School");
        
        refreshMaintenanceFeeDataList();
        
        // Creating Dummy Instance of dohsPolicies.
        dohsPolicies dummyInstance = new dohsPolicies("", LocalDate.of(2023, 02, 02),
                                                LocalDate.of(2023, 02, 02), new ArrayList<String>());
        // Creating Dummy Instance of dohsPolicies.
        
        // Reading data from DOHSPOLICIES.bin file.
        ObservableList<dohsPolicies> policyListOfDohs = (ObservableList<dohsPolicies>) DataReadWrite.readObjectToFile("DOHSPOLICIES.bin", dummyInstance);
        // Reading data from DOHSPOLICIES.bin file.
        
        // Showing the Policies in policyTextArea.
        for ( dohsPolicies policyData : policyListOfDohs ){
            loadPolicies.appendText(policyData.getPolicyName() + "\n");
            for ( int i = 0; i < policyData.getPolicyDescription().size(); ++i ){
                loadPolicies.appendText(policyData.getPolicyDescription().get(i)+"\n");
            }
        }
        // Showing the Policies in policyTextArea
        
    }
    
    private void refreshMaintenanceFeeDataList(){
        maintenanceFee dummy = new maintenanceFee(0, "", "", "", false);
        feeList = (ObservableList<maintenanceFee>) DataReadWrite.readObjectToFile("MainteneceFee.bin", dummy);
    }

    public void helperOfDataPassing(signUpData userDetails){
        //resident = people;
        //System.out.println("Hasib");
        System.out.println(userDetails.getEmail());
        currentlyLoggedInUserInfo = new signUpData(userDetails.getId(),userDetails.getEmail(), 
                                        userDetails.getPassword(), userDetails.getUserType());
        
        carStickerRequest requestSticker = new carStickerRequest(0,"","","");
        ObservableList<carStickerRequest> listCarStickerRequest = (ObservableList<carStickerRequest>) DataReadWrite.readObjectToFile("CarStickerRequestData.bin", requestSticker);
        boolean flag = false;
        boolean flag2 = false;
        // applied = false;
        for ( carStickerRequest approvedList : listCarStickerRequest ){
            if ( approvedList.getEmail().equals(currentlyLoggedInUserInfo.getEmail()) &&  approvedList.getApplicationStatus().equals("Accepted") ){
                applicationStatusLabel.setText("Accepted");
                flag = true;
                applyForCarStickerLabel.setDisable(true);
                break;
            }
        }
        if (!flag){ 
        for ( carStickerRequest approvedList : listCarStickerRequest ){
            if ( approvedList.getEmail().equals(currentlyLoggedInUserInfo.getEmail()) ){
                // applicationStatusLabel.setText("Accepted");
                flag2 = true;
                break;
            }
        }
        System.out.println(flag + " " + flag2);
        if (!flag && flag2){
            applicationStatusLabel.setText("Pending");
            applyForCarStickerLabel.setDisable(true);
        }
        else{
            applicationStatusLabel.setText("Not Applied");
        } 
        }       
    }


    @FXML
    private void applyForCarStickerOnClick(ActionEvent event) {
        // System.out.println(currentlyLoggedInUserInfo.getEmail());
        applied = true;
        applyForCarStickerLabel.setDisable(true);
        applicationStatusLabel.setText("Pending");
        carStickerRequest application = new carStickerRequest(currentlyLoggedInUserInfo.getId(), "Pending",
                                            currentlyLoggedInUserInfo.getEmail(), "Done");
        DataReadWrite.writeObjectToFile("CarStickerRequestData.bin", application);
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        newwscene.sceneSwitchingWithoutDataPassing(stage, "/simulatingoperationsofdohs_management_system_software/login.fxml");
        GenerateAlerts.successfulAlert("Have a good day!" + "\n" + "Please visit Again");
    }

    @FXML
    private void payMaintenanceFeeButtonOnClick(ActionEvent event) {
        maintenanceFee fee = new maintenanceFee(currentlyLoggedInUserInfo.getId(), maintenceFeeMonthComboBox.getValue(),
                            maintenceFeeYearComboBox.getValue(), currentlyLoggedInUserInfo.getEmail(), true );
        DataReadWrite.writeObjectToFile("MainteneceFee.bin", fee);
        payMaintenanceFeeButton.setDisable(true);
        maintenanceFeeStatusLabel.setText("Paid");
    }

    @FXML
    private void loadPaymentStatusButtonOnClick(ActionEvent event) {
        refreshMaintenanceFeeDataList();
        boolean checker = true;
        for ( maintenanceFee tmp:  feeList ){
            if ( (tmp.getResidentEmail().equals(currentlyLoggedInUserInfo.getEmail()) && tmp.getMonth().equals(maintenceFeeMonthComboBox.getValue())) 
                    && tmp.getYear().equals(maintenceFeeYearComboBox.getValue())){
                if ( tmp.isPaymentStatus() ){
                    maintenanceFeeStatusLabel.setText("Paid");
                    payMaintenanceFeeButton.setDisable(true);
                    checker = false;
                    break;
                }
            }
        }
        if (checker) {
            maintenanceFeeStatusLabel.setText("Unpaid");
            payMaintenanceFeeButton.setDisable(false);           
        }
        
    }

    @FXML
    private void donateButtonOnClick(ActionEvent event) {
        try{
            PublicProperties donation = new PublicProperties(currentlyLoggedInUserInfo.getId(), currentlyLoggedInUserInfo.getEmail()  ,donationMonthComboBox.getValue(), 
                    donationYearComboBox.getValue(), donatingOrganizationComboBox.getValue(), Double.parseDouble(donationgAmountTextField.getText()));
            
            DataReadWrite.writeObjectToFile("PublicPropertyMaintanenceFund.bin", donation);
            
            GenerateAlerts.successfulAlert("Thank you for your Donation.");
            donationMonthComboBox.setValue(null);
            donationYearComboBox.setValue(null);
            donatingOrganizationComboBox.setValue(null);
            donationgAmountTextField.clear();
        }
        catch(Exception eo){
            
        }
    }
    
}
