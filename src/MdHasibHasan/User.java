/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Hasib
 */

public abstract class User implements Serializable {
    protected int id;
    protected String name, gender, email, userType;
    protected final String societyName = "MIRPUR DOHS";
    protected LocalDate deathOfBirth;
    protected long contactNo;

    public User(int id, String name, String gender, String email, String userType, LocalDate deathOfBirth, long contactNo) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.email = email;
        this.userType = userType;
        this.deathOfBirth = deathOfBirth;
        this.contactNo = contactNo;
    }

    public void setContactNo(long contactNo) {
        this.contactNo = contactNo;
    }
    
    
    public void loginToTheDashboard(){
        
    }
    
    public void changePassword(){
        
    }
    
    protected final int totalDOHSResident(){
        
        return 0;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", gender=" + gender + ", email=" + email + ", userType=" + userType + ", societyName=" + societyName + ", deathOfBirth=" + deathOfBirth + ", contactNo=" + contactNo + '}';
    }
    
    
    
}
