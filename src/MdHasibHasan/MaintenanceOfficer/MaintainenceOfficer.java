/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.CantonmentBoardMember.CantonmentBoardMember;
import MdHasibHasan.CantonmentBoardMember.crucialTaskPermissionRequest;
import MdHasibHasan.DataReadWrite;
import MdHasibHasan.Employee;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.signUpData;
import MdMasumBilla.accountsAndFinanceOfficer;
import MdMasumBilla.realEstateAgent;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Map;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Hasib
 */
public class MaintainenceOfficer extends Employee implements Serializable {

    public MaintainenceOfficer(LocalDate dateOoJoin, float salary, String department, String designation, int id, String name, String gender, String email, String userType, LocalDate deathOfBirth, long contactNo) {
        super(dateOoJoin, salary, department, designation, id, name, gender, email, userType, deathOfBirth, contactNo);
    }

    @Override
    protected void applyForLeave() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public static ObservableList<carStickerRequest> approveCarStickerRequest(ObservableList<carStickerRequest> stickerRequestData, carStickerRequest instanceOfCarStickerRequest ){
        for ( int i = 0; i <  stickerRequestData.size(); ++i ){
            // Updating the Application Status
            if ( stickerRequestData.get(i).getEmail().equals(instanceOfCarStickerRequest.getEmail())) stickerRequestData.get(i).setApplicationStatus("Accepted");
            // Writing updated data on the File.
            if ( i == 0 ) DataReadWrite.overWriteObjectToFile("CarStickerRequestData.bin", stickerRequestData.get(i));
            else DataReadWrite.writeObjectToFile("CarStickerRequestData.bin", stickerRequestData.get(i));
        }
        return stickerRequestData;  
    }
    
    public static ObservableList<maintenanceFee> collectAndViewMaintenanceFee(ObservableList<maintenanceFee> feeList, String month, String year){
        ObservableList<maintenanceFee> updatedFeeList = FXCollections.observableArrayList();
            for ( maintenanceFee data : feeList ){
                if ( data.getMonth().equals(month)  && data.getYear().equals(year) ){
                    updatedFeeList.add(data);
                }
            }            
        return updatedFeeList;
    }
    
    public static void createYearlyMaintenanceBudget(Map<String, Float> budgetProjectAndAmountList, String budgetYear){
        float totalBudgetAmount = 0;
        for (Map.Entry<String, Float> mapData : budgetProjectAndAmountList.entrySet()){
            totalBudgetAmount += mapData.getValue();
        }
        yearlyBudget newBudget = new yearlyBudget(budgetYear, totalBudgetAmount, budgetProjectAndAmountList);
        
        DataReadWrite.writeObjectToFile("YearlyBudgetOfMaintenanceDept.bin", newBudget);
        GenerateAlerts.successfulAlert("Yearly Budget Created Successfully.");
    } 
    
    public static void createMonthlyExpenditureReport(Map<String, Double> expendedOrgAndAmountList, String year, String month){
        Double totalBudgetAmount = 0.0;
        for (Map.Entry<String, Double> mapData : expendedOrgAndAmountList.entrySet()){
            totalBudgetAmount += mapData.getValue();
        }
        // yearlyBudget newBudget = new yearlyBudget(budgetYear, totalBudgetAmount, budgetProjectAndAmountList);
        
        monthlyReport report = new monthlyReport (month, year, totalBudgetAmount, expendedOrgAndAmountList);
        
        DataReadWrite.writeObjectToFile("MonthlyReportOfMaintenanceDept.bin", report);
        GenerateAlerts.successfulAlert("Monthly Report Submitted Successfully.");
    } 
    
    public static ObservableList<signUpData> deleteDOHSSoftwareUser(ObservableList<signUpData> loginInfo, signUpData delInstance){
        ObservableList<signUpData> updatedSignUpData = FXCollections.observableArrayList();
        for ( signUpData data : loginInfo ){
            if ( data.getId() == delInstance.getId() && data.getEmail().equals(delInstance.getEmail()) ){
                continue;
            }
            else{
                updatedSignUpData.add(data);
            }
        }
        for ( int i = 0; i < updatedSignUpData.size(); ++i){
            if ( i == 0 ) DataReadWrite.overWriteObjectToFile("LoginData.bin", updatedSignUpData.get(i));
            else DataReadWrite.writeObjectToFile("LoginData.bin", updatedSignUpData.get(i));
        }
        for ( signUpData data1 : updatedSignUpData ){
            data1.setPassword("*****");
        }
        return updatedSignUpData;
    }
    
    public static <T> void regsiterNewUser(T instance, signUpData loginData, String fileName, int ID){
        if ( fileName.equals("MaintenanceDepartment.bin") ) DataReadWrite.overWriteObjectToFile("MaintenanceDepartment.bin", instance);
        else if ( fileName.equals("AccountsAndFinanceOfficer.bin") ) DataReadWrite.overWriteObjectToFile("AccountsAndFinanceOfficer.bin", instance);
        else if ( fileName.equals("CantonmentBoardMember.bin") ) DataReadWrite.overWriteObjectToFile("CantonmentBoardMember.bin", instance);
        else if ( fileName.equals("RealEstateAgent.bin") ) DataReadWrite.overWriteObjectToFile("RealEstateAgent.bin", instance);
        else if ( fileName.equals("SecurityDepartment.bin") ) DataReadWrite.writeObjectToFile("SecurityDepartment.bin", instance);
        
        
        DataReadWrite.writeObjectToFile("LoginData.bin", loginData);
        
        GenerateAlerts.successfulAlert("Registration Successful.\n" + 
                                        "You DOHS user id is: " + ID);
    }
    
    public static ObservableList<PublicProperties> seeAllPublicPropertyFunds(PublicProperties donation){
        ObservableList<PublicProperties> donationList  = (ObservableList<PublicProperties>) DataReadWrite.readObjectToFile("PublicPropertyMaintanenceFund.bin", donation);
        ObservableList<PublicProperties> updateDonationList  = FXCollections.observableArrayList();
        
        for ( PublicProperties donationData : donationList ){
            if ( donationData.getMonth().equals(donation.getMonth()) && donationData.getYear().equals(donation.getYear()) ){
                if ( donationData.getOrganizationType().equals(donation.getOrganizationType()) ){
                    updateDonationList.add(donationData);
                }
            }
        }
        
        return updateDonationList;
    }
    
    public static void requestCrucialTaskPermissionFromDohsHigherAuthorities (crucialTaskPermissionRequest newReq){
        DataReadWrite.writeObjectToFile("CrucialTaskPermissionRequest.bin", newReq);
        GenerateAlerts.successfulAlert("Your request has been sended.\n Please Have Patience!");
    }
}
