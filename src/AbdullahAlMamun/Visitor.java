/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AbdullahAlMamun;

import java.io.Serializable;
import java.time.LocalDate;


/**
 *
 * @author user
 */
public class Visitor implements Serializable{
    private String name, nidNo, phoneNo, puposeOfVisit, timeSlot,gender;
    private LocalDate date;

    public Visitor(String name, String nidNo, String phoneNo, String puposeOfVisit, String timeSlot, String gender, LocalDate date) {
        this.name = name;
        this.nidNo = nidNo;
        this.phoneNo = phoneNo;
        this.puposeOfVisit = puposeOfVisit;
        this.timeSlot = timeSlot;
        this.gender = gender;
        this.date = date;
    }
   
    

    public String getName() {
        return name;
    }

    public String getNidNo() {
        return nidNo;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getPuposeOfVisit() {
        return puposeOfVisit;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getGender() {
        return gender;
    }

    

    public void setName(String name) {
        this.name = name;
    }

    public void setNidNo(String nidNo) {
        this.nidNo = nidNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setPuposeOfVisit(String puposeOfVisit) {
        this.puposeOfVisit = puposeOfVisit;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Visitor:" + "name=" + name + ", nidNo=" + nidNo + ", phoneNo=" + phoneNo + ", puposeOfVisit=" + puposeOfVisit + ", timeSlot=" + timeSlot + ", gender=" + gender + ", date=" + date + '\n';
    }

    

    
    
    
    
    
}
