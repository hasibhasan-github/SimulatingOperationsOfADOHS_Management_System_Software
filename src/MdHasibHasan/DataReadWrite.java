/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;

import MdHasibHasan.DummyUser.Resident;
import MdMasumBilla.BudgetingAndForecasting;
import MdMasumBilla.accountsAndFinanceOfficer;
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
    
    public static <T> Boolean writeObjectToFile(String str, T instance){
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        File f = null;
        try{
            f = new File(str);
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
    public static <T> ObservableList<?> readObjectToFile(String str, T instance){
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
        
        
        try{
            if ( instance instanceof Resident ){
                    f = new File(str);
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
                    f = new File(str);
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
                    f = new File(str);
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
        
        
        return loginData;
        
        
    }
    
}
