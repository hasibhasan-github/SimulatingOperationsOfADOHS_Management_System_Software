/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.DummyUser;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.MaintenanceOfficer.carStickerRequest;
import MdHasibHasan.MaintenanceOfficer.maintenanceFee;
import MdHasibHasan.sceneChanging;
import MdHasibHasan.signUpData;
import java.io.IOException;
import java.net.URL;
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        maintenanceFeeStatusLabel.setText("Unpaid");
        //System.out.println(currentlyLoggedInUserInfo.getEmail());
        applicationStatusLabel.setText("Not Applied");
        loadPolicies.setText("Noise Control Policy: Residents must keep noise levels at a reasonable level between 10:00 PM and 8:00 AM to ensure a peaceful living environment.\n" + 
                                        "Parking Regulation: Residents must use their designated parking spaces only, and visitor parking is strictly reserved for guests." +"\n"+ "Unauthorized parking in visitor spots may result in penalties.\n" +
                                        "Waste Management Policy: All residents must follow the society's waste disposal guidelines, including separating recyclables and putting \n out trash only during designated collection times.\n" + 
                                        "Alteration Approval Process: Any structural changes or renovations to units require prior approval from the society management to \n ensure compliance with safety and aesthetic standards.\n" + 
                                        "Smoking is prohibited in all indoor and outdoor common areas to maintain a healthy and smoke-free environment for all residents. Designated smoking areas may be provided for those who smoke.\n"+
                                        "Residents are allowed to decorate their balconies and exteriors within specified guidelines. Decorations should not obstruct views, create safety hazards, or adversely affect the overall appearance of the building.\n" + 
                                        "Usage of amenities such as the gym, pool, and clubhouse should adhere to designated quiet hours. This ensures that residents can enjoy these facilities without disturbing others.");
        maintenceFeeMonthComboBox.getItems().addAll("January", "February", "March", "April", "May",
                "June", "July", "August", "September", "October", "November", "December");
        maintenceFeeYearComboBox.getItems().addAll("2023", "2024", "2025", "2026", "2027", "2028");
        
        refreshMaintenanceFeeDataList();
        
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
        carStickerRequest application = new carStickerRequest(currentlyLoggedInUserInfo.getId(), "Pending",
                                            currentlyLoggedInUserInfo.getEmail(), "Done");
        System.out.println(application.getEmail());
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
    
}
