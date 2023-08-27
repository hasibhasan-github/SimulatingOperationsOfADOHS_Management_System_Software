/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import java.io.Serializable;

/**
 *
 * @author Hasib
 */
public class SupportForum implements Serializable {
    private String name, userType, contactNo, subject, description;

    public SupportForum(String name, String userType, String contactNo, String subject, String description) {
        this.name = name;
        this.userType = userType;
        this.contactNo = contactNo;
        this.subject = subject;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getUserType() {
        return userType;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }
    
    
}
