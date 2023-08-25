/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbdullahAlMamun;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.Employee;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.ObservableList;

/**
 *
 * @author user
 */
public class SecurityCheif extends Employee implements Serializable{

    public SecurityCheif(LocalDate dateOoJoin, float salary, String department, String designation, int id, String name, String gender, String email, String userType, LocalDate deathOfBirth, long contactNo) {
        super(dateOoJoin, salary, department, designation, id, name, gender, email, userType, deathOfBirth, contactNo);
    }

    @Override
    protected void applyForLeave() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    public static ObservableList<VisitorRequest> gantAccessPermission(ObservableList<VisitorRequest> visitorRequestData, VisitorRequest instance){
          for ( int i = 0; i <  visitorRequestData.size(); ++i ){
            // Updating the Application Status
            if (visitorRequestData.get(i).getPhoneNo().equals(instance.getPhoneNo())) visitorRequestData.get(i).setApplicationStatus("Approved");
            // Writing updated data on the File.
            if ( i == 0 ) DataReadWrite.overWriteObjectToFile("VisitorRequest.bin", visitorRequestData.get(i));
            else DataReadWrite.writeObjectToFile("VisitorRequest.bin", visitorRequestData.get(i));
        }
        return visitorRequestData; 
        
        
        
    }
    
}
