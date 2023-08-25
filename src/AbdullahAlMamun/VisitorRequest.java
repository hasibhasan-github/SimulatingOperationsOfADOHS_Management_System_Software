/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbdullahAlMamun;

import java.io.Serializable;

/**
 *
 * @author user
 */
public class VisitorRequest implements Serializable{
    private String name, phoneNo, purposeOfVisit, timeSlot, applicationStatus;

    public VisitorRequest(String name, String phoneNo, String purposeOfVisit, String timeSlot, String applicationStatus) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.purposeOfVisit = purposeOfVisit;
        this.timeSlot = timeSlot;
        this.applicationStatus = applicationStatus;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPurposeOfVisit() {
        return purposeOfVisit;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setPurposeOfVisit(String purposeOfVisit) {
        this.purposeOfVisit = purposeOfVisit;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    
    
    
    
}
