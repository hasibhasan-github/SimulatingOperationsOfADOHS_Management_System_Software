/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import MdHasibHasan.User;
import java.io.Serializable;
import java.time.LocalDate;

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
    
}
