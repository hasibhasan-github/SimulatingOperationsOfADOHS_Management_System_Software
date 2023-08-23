/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.DataReadWrite;
import MdHasibHasan.GenerateAlerts;
import MdHasibHasan.User;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Hasib
 */
public class CantonmentBoardMember extends User implements Serializable {
    private String militaryRank;

    public CantonmentBoardMember(String militaryRank, int id, String name, String gender, String email, String userType, LocalDate deathOfBirth, long contactNo) {
        super(id, name, gender, email, userType, deathOfBirth, contactNo);
        this.militaryRank = militaryRank;
    }
    
    public static void implyNewPoliciesAndGuidelines(dohsPolicies policy){
        DataReadWrite.writeObjectToFile("DOHSPOLICIES.bin", policy);
        // Generating successful Alert.
        GenerateAlerts.successfulAlert("Policy added Successfully.");
    }
    
    public static ObservableList<dohsPolicies> deleteAnOldPolicy(dohsPolicies policy){ 
        // Creating Dummy Instance
        dohsPolicies dummyInstance = new dohsPolicies("", LocalDate.of(2023, 02, 02),
                                                LocalDate.of(2023, 02, 02), new ArrayList<String>());
        ObservableList<dohsPolicies> policyListOfDohs = (ObservableList<dohsPolicies>) DataReadWrite.readObjectToFile("DOHSPOLICIES.bin", dummyInstance);
        
        ObservableList<dohsPolicies> updatedPolicyListOfDohs = FXCollections.observableArrayList();
        // Updating the data in a new list.
        for ( dohsPolicies policyData : policyListOfDohs ){
            if (policyData.getPolicyName().equals(policy.getPolicyName())) continue;
            else updatedPolicyListOfDohs.add(policyData);
        }
        // Writing the new List Data to Binary File 
        for ( int i = 0; i < updatedPolicyListOfDohs.size(); i++ ){
            if ( i == 0 ) DataReadWrite.overWriteObjectToFile("DOHSPOLICIES.bin", updatedPolicyListOfDohs.get(i));
            else DataReadWrite.writeObjectToFile("DOHSPOLICIES.bin", updatedPolicyListOfDohs.get(i));
        }
        // Returning the updated List
        return updatedPolicyListOfDohs;
    }
        
}
