/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;

import AbdullahAlMamun.VisitorRequest;
import MdHasibHasan.CantonmentBoardMember.crucialTaskPermissionRequest;
import MdHasibHasan.CantonmentBoardMember.developementProject;
import MdHasibHasan.CantonmentBoardMember.dohsPolicies;
import MdHasibHasan.DummyUser.Resident;
import MdHasibHasan.MaintenanceOfficer.PublicProperties;
import MdMasumBilla.BudgetingAndForecasting;
import MdMasumBilla.accountsAndFinanceOfficer;
import MdHasibHasan.MaintenanceOfficer.carStickerRequest;
import MdHasibHasan.MaintenanceOfficer.maintenanceFee;
import MdHasibHasan.MaintenanceOfficer.yearlyBudget;
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
        ObservableList<Resident> people = FXCollections.observableArrayList();
        ObservableList<signUpData> loginData  = FXCollections.observableArrayList();
        ObservableList<BudgetingAndForecasting> pieChartData  = FXCollections.observableArrayList();
        ObservableList<carStickerRequest> carStickerRequestData  = FXCollections.observableArrayList();
        ObservableList<dohsPolicies> policy  = FXCollections.observableArrayList();
        ObservableList<developementProject> project  = FXCollections.observableArrayList();
        ObservableList<maintenanceFee> fee  = FXCollections.observableArrayList();
        ObservableList<yearlyBudget> budgetYearly  = FXCollections.observableArrayList();
        ObservableList<VisitorRequest> visitReq  = FXCollections.observableArrayList();
        ObservableList<PublicProperties> donation  = FXCollections.observableArrayList();
        ObservableList<crucialTaskPermissionRequest> crucTaskReq  = FXCollections.observableArrayList();
        
        
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
               //  System.out.println("Hasib");               
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
        else if ( instance instanceof BudgetingAndForecasting ) return pieChartData;
        else if ( instance instanceof carStickerRequest ) return carStickerRequestData;
        else if ( instance instanceof dohsPolicies ) return policy;
        else if ( instance instanceof developementProject ) return project;
        else if ( instance instanceof maintenanceFee ) return fee;
        else if ( instance instanceof yearlyBudget ) return budgetYearly;
        else if ( instance instanceof VisitorRequest ) return visitReq;
        else if ( instance instanceof PublicProperties ) return donation;
        else if ( instance instanceof crucialTaskPermissionRequest ) return crucTaskReq;
        
        
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
