/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;

import Abdullah.UtilityServiceManager.ServiceProvider;
import AbdullahAlMamun.CheckPointData;
import AbdullahAlMamun.FeedBack;
import AbdullahAlMamun.VisitorRequest;
import MdHasibHasan.CantonmentBoardMember.crucialTaskPermissionRequest;
import MdHasibHasan.CantonmentBoardMember.developementProject;
import MdHasibHasan.CantonmentBoardMember.developementProjectVoting;
import MdHasibHasan.CantonmentBoardMember.dohsPolicies;
import MdHasibHasan.CantonmentBoardMember.reportFromSecurityDepartment;
import MdHasibHasan.CantonmentBoardMember.residentVote;
import MdHasibHasan.CantonmentBoardMember.sendNotice;
import MdHasibHasan.DummyUser.Resident;
import MdHasibHasan.MaintenanceOfficer.PublicProperties;
import MdHasibHasan.MaintenanceOfficer.SupportForum;
import MdMasumBilla.BudgetingAndForecasting;
import MdMasumBilla.accountsAndFinanceOfficer;
import MdHasibHasan.MaintenanceOfficer.carStickerRequest;
import MdHasibHasan.MaintenanceOfficer.maintenanceFee;
import MdHasibHasan.MaintenanceOfficer.monthlyReport;
import MdHasibHasan.MaintenanceOfficer.yearlyBudget;
import MdMasumBilla.FinancialAnalysis;
import MdMasumBilla.FinancialRisk;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Hasib
 */

public class DataReadWrite {
    
    public static <T> Boolean writeObjectToFile(String fileName, T instance){
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        File f = null;
        try{
            f = new File(fileName);
            if (f.exists() ){
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            try {
                oos.writeObject(instance);
                oos.close();
                return true;
            }
            catch(IOException ex){
                GenerateAlerts.unsuccessfulAlert("Error while writing the File." + "\n" +
                                                "Please Check your Storage Efficiency, File type and name.");
            }
        }
        catch (Exception e){
            GenerateAlerts.unsuccessfulAlert("Data is Vulnerable." + "\n" + "Please try again rechecking your data" + 
                                                "If you can't solve the issue. Contact Software maintainer.");
        }
        finally {
            try{
                if ( oos != null){
                    oos.close();
                }
            }
            catch (IOException ex){
                GenerateAlerts.unsuccessfulAlert("Error while closing the Binary File.");
                return false;
            }
        } 
        return false;
        
    }
//ObservableList<?>
    public static <T> ObservableList<?> readObjectToFile(String fileName, T instance){
        System.out.println("Hasib11");
        File f = null;
        FileInputStream fw = null;
        ObjectInputStream ois = null;  
        //ArrayList<Facultyclass> arrayfaculty = new ArrayList<Facultyclass>();
        //ArrayList<CourseClass> coursefaculty = new ArrayList<CourseClass>();
        //ArrayList<OfferedCourseClass> offercourse = new ArrayList<OfferedCourseClass>();
        //ArrayList<RegisteredCourse> recourse = new ArrayList<RegisteredCourse>();
        ObservableList<ServiceProvider> spList  = FXCollections.observableArrayList();
        ObservableList<Resident> people = FXCollections.observableArrayList();
        ObservableList<SupportForum> listDataForum = FXCollections.observableArrayList();
        ObservableList<sendNotice> noticeList = FXCollections.observableArrayList();
        ObservableList<signUpData> loginData  = FXCollections.observableArrayList();
        ObservableList<BudgetingAndForecasting> pieChartData  = FXCollections.observableArrayList();
        ObservableList<carStickerRequest> carStickerRequestData  = FXCollections.observableArrayList();
        ObservableList<dohsPolicies> policy  = FXCollections.observableArrayList();
        ObservableList<developementProject> project  = FXCollections.observableArrayList();
        ObservableList<maintenanceFee> fee  = FXCollections.observableArrayList();
        ObservableList<yearlyBudget> budgetYearly  = FXCollections.observableArrayList();
        ObservableList<VisitorRequest> visitReq  = FXCollections.observableArrayList();
        ObservableList<PublicProperties> donation  = FXCollections.observableArrayList();
        ObservableList<reportFromSecurityDepartment> securityReport  = FXCollections.observableArrayList();
        ObservableList<developementProjectVoting> votingProj  = FXCollections.observableArrayList();
        ObservableList<residentVote> rVoteProj  = FXCollections.observableArrayList();
        ObservableList<crucialTaskPermissionRequest> crucTaskReq  = FXCollections.observableArrayList();
        ObservableList<CheckPointData> cpList  = FXCollections.observableArrayList();
        
        ObservableList<FinancialAnalysis> fAnalysis  = FXCollections.observableArrayList();
        ObservableList<FinancialRisk> fRisk = FXCollections.observableArrayList();
        ObservableList<FeedBack> fbList = FXCollections.observableArrayList();
        
        
        ObservableList<monthlyReport> reportOfMaintenance = FXCollections.observableArrayList();
        
        try{
            if ( instance instanceof Resident ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        people.add((Resident)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Hasib read exe");
                }
               //  System.out.println("Hasib");               
            }
            
            else if ( instance instanceof FinancialAnalysis ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        fAnalysis.add((FinancialAnalysis)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Financial Analysis read exe Signup Data");
                }             
            }
            
            else if ( instance instanceof FinancialRisk ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        fRisk.add((FinancialRisk)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Financial Risk read exe Signup Data");
                }              
            }
            
            else if ( instance instanceof signUpData ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        loginData.add((signUpData)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Hasib read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof monthlyReport ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        reportOfMaintenance.add((monthlyReport)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Monthly reportOfMaintenance read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof SupportForum ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        listDataForum.add((SupportForum)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Monthly reportOfMaintenance read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof BudgetingAndForecasting ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        pieChartData.add((BudgetingAndForecasting)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Masum read exe Signup Data");
                }               
            }
            else if ( instance instanceof carStickerRequest ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        carStickerRequestData.add((carStickerRequest)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Hasib carStickerRequest read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof reportFromSecurityDepartment ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        securityReport.add((reportFromSecurityDepartment)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Hasib reportFromSecurityDepartment read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof dohsPolicies ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        policy.add((dohsPolicies)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Hasib dohsPolicies read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof sendNotice ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        noticeList.add((sendNotice)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("sendNotice read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            
            else if ( instance instanceof developementProject ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        project.add((developementProject)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Hasib dohsPolicies read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof maintenanceFee ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        fee.add((maintenanceFee)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Hasib maintenanceFee read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof yearlyBudget ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        budgetYearly.add((yearlyBudget)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Hasib maintenanceFee read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof VisitorRequest ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        visitReq.add((VisitorRequest)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("VisitorRequest read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            
            else if ( instance instanceof CheckPointData ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        cpList.add((CheckPointData)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("CheckPointData read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof PublicProperties ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        donation.add((PublicProperties)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("PublicProperties read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof crucialTaskPermissionRequest ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        crucTaskReq.add((crucialTaskPermissionRequest)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("crucialTaskPermissionRequest read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof developementProjectVoting ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        votingProj.add((developementProjectVoting)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("developementProjectVoting read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof residentVote ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        rVoteProj.add((residentVote)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("residentVote read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof FeedBack ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        fbList.add((FeedBack)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("FeedBack read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
            else if ( instance instanceof ServiceProvider ){
                    f = new File(fileName);
                    fw = new FileInputStream(f);
                    ois = new ObjectInputStream(fw);
                try{
                    while (true) {
                        spList.add((ServiceProvider)ois.readObject());
                    }
                }
                catch(Exception e){
                    System.out.println("Service Provider read exe Signup Data");
                }
               //  System.out.println("Hasib");               
            }
        }
        catch(Exception e){
            System.out.println("Hasib False");
        }
        finally{
            try {
                if ( ois != null ){
                    ois.close();
                }
            }
            catch(IOException ex){
                
            }
        } 
                            
        /*for( Resident tmp: people){
                        System.out.println(tmp.toString());
                    
        }
*/
        if ( instance instanceof Resident ) return people;
        else if ( instance instanceof SupportForum ) return listDataForum;
        else if ( instance instanceof sendNotice ) return noticeList;
        else if ( instance instanceof monthlyReport ) return reportOfMaintenance;
        else if ( instance instanceof BudgetingAndForecasting ) return pieChartData;
        else if ( instance instanceof FinancialAnalysis ) return fAnalysis;
        else if ( instance instanceof FinancialRisk ) return fRisk;
        else if ( instance instanceof carStickerRequest ) return carStickerRequestData;
        else if ( instance instanceof dohsPolicies ) return policy;
        else if ( instance instanceof developementProject ) return project;
        else if ( instance instanceof maintenanceFee ) return fee;
        else if ( instance instanceof yearlyBudget ) return budgetYearly;
        else if ( instance instanceof VisitorRequest ) return visitReq;
        else if ( instance instanceof PublicProperties ) return donation;
        else if ( instance instanceof reportFromSecurityDepartment ) return securityReport;
        else if ( instance instanceof crucialTaskPermissionRequest ) return crucTaskReq;
        else if ( instance instanceof CheckPointData ) return cpList;
        else if ( instance instanceof developementProjectVoting ) return votingProj;
        else if ( instance instanceof residentVote ) return rVoteProj;
        else if ( instance instanceof FeedBack ) return fbList;
        else if ( instance instanceof ServiceProvider ) return spList;
        
        
        return loginData;
        
        
    }
    
    
    // Method For Overwritting On a Binary Data File.
    
    public static <T> Boolean overWriteObjectToFile(String fileName, T instance){
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        File f = null;
        try{
            f = new File(fileName);
            if (f.exists() ){
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            try {
                oos.writeObject(instance);
                oos.close();
                return true;
            }
            catch(IOException ex){
                GenerateAlerts.unsuccessfulAlert("Error while writing the File." + "\n" +
                                                "Please Check your Storage Efficiency, File type and name.");
            }
        }
        catch (Exception e){
            GenerateAlerts.unsuccessfulAlert("Data is Vulnerable." + "\n" + "Please try again rechecking your data" + 
                                                "If you can't solve the issue. Contact Software maintainer.");
        }
        finally {
            try{
                if ( oos != null){
                    oos.close();
                }
            }
            catch (IOException ex){
                GenerateAlerts.unsuccessfulAlert("Error while closing the Binary File.");
                return false;
            }
        } 
        return false;
        
    }
    
}
