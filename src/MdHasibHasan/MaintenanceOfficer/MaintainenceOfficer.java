/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.Employee;
import java.io.Serializable;
import java.time.LocalDate;
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
    
}
