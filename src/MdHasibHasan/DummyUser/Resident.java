/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.DummyUser;

import MdHasibHasan.User;
import java.time.LocalDate;

/**
 *
 * @author Hasib
 */
public class Resident extends User {
    private String plotNo, holdingOrFlatNo;

    public Resident(String plotNo, String holdingOrFlatNo, int id, String name, String gender, String email, String userType, LocalDate deathOfBirth, long contactNo) {
        super(id, name, gender, email, userType, deathOfBirth, contactNo);
        this.plotNo = plotNo;
        this.holdingOrFlatNo = holdingOrFlatNo;
    }

    public String toStringM() {
        return " Resident{" + "plotNo=" + plotNo + ", holdingOrFlatNo=" + holdingOrFlatNo + '}'+"\n";
    }
    
    
}
