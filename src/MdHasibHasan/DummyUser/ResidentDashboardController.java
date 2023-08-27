/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdHasibHasan.DummyUser;

import AbdullahAlMamun.FeedBack;
import MdHasibHasan.CantonmentBoardMember.CantonmentBoardMember;
import MdHasibHasan.CantonmentBoardMember.developementProject;
import MdHasibHasan.CantonmentBoardMember.developementProjectVoting;
import MdHasibHasan.CantonmentBoardMember.dohsPolicies;
import MdHasibHasan.CantonmentBoardMember.residentVote;
import MdHasibHasan.CantonmentBoardMember.sendNotice;
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
import javafx.scene.control.DatePicker;
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
    @FXML
    private TextField ongoingVotingProjectName;
    @FXML
    private TextField votersVote;
    @FXML
    private ComboBox<String> selectVoteComboBoxFxId;
    
    private ObservableList<developementProject> projectDevPlan;
    
    private ObservableList<developementProjectVoting> votingProj;
    
    private ObservableList<residentVote> rVoteProj;
    @FXML
    private Button submitVoteButton;
    @FXML
    private TextArea notificationViewTextArea;
    @FXML
    private ComboBox<String> selectDepComboboxfxid;
    @FXML
    private Button loadBtn;
    @FXML
    private TextArea announcementTextAreafxid;
    @FXML
    private TextField residentHouseNoFxid;
    @FXML
    private ComboBox<String> feedbackTypeFxid;
    @FXML
    private TextField residentIDfxid;
    @FXML
    private DatePicker todaysDateFxid;
    @FXML
    private TextArea feedbackTextAreaFxid;
    @FXML
    private Button sendBtnFxid;
    @FXML
    private ComboBox<String> selectDeptFeedbackfxid;
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
        
        selectVoteComboBoxFxId.getItems().addAll("Positive", "Negative", "Neutral");
        selectVoteComboBoxFxId.setValue("Neutral");
        votersVote.setText("Neutral");
        
        //  Creating Dummy Instance to Read The File Data of "DevelopmentProjects.bin".
        developementProject dummyDevelopementProject = new developementProject("", LocalDate.of(2023, 03, 10), new ArrayList<String>());
        // Reading the data From File.
        projectDevPlan = (ObservableList<developementProject>) DataReadWrite.readObjectToFile("DevelopmentProjects.bin", dummyDevelopementProject);
        
        developementProjectVoting dummyProj = new developementProjectVoting("", dummyDevelopementProject, LocalDate.of(2023, 03, 10) );
        
        votingProj = (ObservableList<developementProjectVoting>) DataReadWrite.readObjectToFile("developementProjectVoting.bin", dummyProj);
        
        System.out.println();
        ongoingVotingProjectName.setText(votingProj.get(0).getProjectName());
        if ( votingProj.get(0).getProjectName().equals("Empty") ){
            submitVoteButton.setDisable(true);
            votersVote.setText("Voting Off");
            selectVoteComboBoxFxId.setDisable(true);
        }
        
        loadNotifcationsData();
        comboBoxInitializeForFeedBack();
        
    }
    
    private void loadNotifcationsData(){
        sendNotice notice = new sendNotice("", "", "", LocalDate.of(2023, 02, 02), new ArrayList<String>());
        
        ObservableList<sendNotice> unUpdateList = (ObservableList<sendNotice>) DataReadWrite.readObjectToFile("DOHSNotice.bin", notice);
       
        for (sendNotice data : unUpdateList  ){
            if ( data.getNoticeForPeopleType().equals("Resident") ) {
                notificationViewTextArea.appendText(data.getNoticeName() + "\n Subject: " + data.getNoticeSubject());
            }
        }
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
        developementProject dummyDevelopementProject = new developementProject("", LocalDate.of(2023, 03, 10), new ArrayList<String>());
        residentVote dummyResidentVote = new residentVote ("", "", 1, dummyDevelopementProject );
        
        rVoteProj  = (ObservableList<residentVote>) DataReadWrite.readObjectToFile("ResidentVoteOnDevelopementProject.bin", dummyResidentVote);
        
        for ( residentVote dataCheck : rVoteProj ){
            if ( dataCheck.getVoterEmail().equals(currentlyLoggedInUserInfo.getEmail()) && dataCheck.getVotingProject().getProjectName().equals(votingProj.get(0).getVotingProject().getProjectName()) ){
                submitVoteButton.setDisable(true);
                votersVote.setText(dataCheck.getResidentVote());
                selectVoteComboBoxFxId.setDisable(true);
                break;
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

    @FXML
    private void downloadProjectPDFButtonOnClick(ActionEvent event) {
        for (  developementProject data: projectDevPlan ){
            if ( data.getProjectName().equals(votingProj.get(0).getProjectName()) ){
                CantonmentBoardMember.generateDevelopementProjectPDF(votingProj.get(0).getVotingProject());
                break;
            }
        }
    }

    @FXML
    private void selectVoteComboBoxOnSelection(ActionEvent event) {
        if ( selectVoteComboBoxFxId.getValue().equals("Positive") ){
            votersVote.setText("Positive");
        }
        else if ( selectVoteComboBoxFxId.getValue().equals("Neutral") ){
            votersVote.setText("Neutral");
        }
        else if ( selectVoteComboBoxFxId.getValue().equals("Negative") ){
            votersVote.setText("Negative");
        }
    }

    @FXML
    private void submitVoteButtonOnClick(ActionEvent event) {
        residentVote vtDev = new residentVote(currentlyLoggedInUserInfo.getEmail(), selectVoteComboBoxFxId.getValue(), 
                            currentlyLoggedInUserInfo.getId(), votingProj.get(0).getVotingProject());
        if ( GenerateAlerts.confirmationAlert() ){
            DataReadWrite.writeObjectToFile("ResidentVoteOnDevelopementProject.bin", vtDev);
            submitVoteButton.setDisable(true);
            GenerateAlerts.successfulAlert("Thank you for your Vote.");
        }
    }

    @FXML
    private void viewAllNotificationsInDetailsButtonOnClick(ActionEvent event) throws IOException {
        sceneChanging newwscene = new sceneChanging();
        newwscene.windowSwitchingWithoutDataPassing( "/MdHasibHasan/DummyUser/notificationsSceneResident.fxml");
    }

    @FXML
    private void loadBtnOnClick(ActionEvent event) {
        
        
    }

    @FXML
    private void sendFeedBackBtnONClick(ActionEvent event) {
        try{
            if(selectDeptFeedbackfxid.getValue() == null || residentIDfxid.getText()==null || residentHouseNoFxid.getText()==null || feedbackTypeFxid.getValue()==null || feedbackTextAreaFxid.getText()==null || todaysDateFxid.getValue()==null){
                GenerateAlerts.unsuccessfulAlert("Please fill in all fields.");
                return;                           
            }
            FeedBack fb = new FeedBack(selectDeptFeedbackfxid.getValue(), residentIDfxid.getText(), residentHouseNoFxid.getText(), feedbackTypeFxid.getValue(), feedbackTextAreaFxid.getText(), todaysDateFxid.getValue());
            DataReadWrite.writeObjectToFile("FeedBack.bin", fb);
            sendBtnFxid.setDisable(true);
            GenerateAlerts.successfulAlert("Your Feedback has been sended");
        }
        catch(Exception ee){
            GenerateAlerts.unsuccessfulAlert("An error occurred. Please try again.");
        }
        
    }
    
    private void comboBoxInitializeForFeedBack(){
        selectDeptFeedbackfxid.getItems().addAll("Security Cheif", "Utility Service Manager");
        if(selectDeptFeedbackfxid.getValue().equals("Security Cheif")){
            feedbackTypeFxid.getItems().addAll("Security Concerns","Emergency Response","Access Issues","Suggestions for Improvement","Incidents Reporting");
        }
        else{
            feedbackTypeFxid.getItems().addAll("Suggestions for Improvement","New connection", "Connectivity Isue");
            
        }
        
    }
    
}
