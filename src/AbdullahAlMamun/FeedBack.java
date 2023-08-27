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
public class FeedBack implements Serializable{
    private String Dept, residentId, houseNo, annType, announceText;
    LocalDate date;

    public FeedBack(String Dept, String residentId, String houseNo, String annType, String announceText, LocalDate date) {
        this.Dept = Dept;
        this.residentId = residentId;
        this.houseNo = houseNo;
        this.annType = annType;
        this.announceText = announceText;
        this.date = date;
    }

    public String getAnnounceText() {
        return announceText;
    }

   

    public String getDept() {
        return Dept;
    }

    public String getResidentId() {
        return residentId;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public String getAnnType() {
        return annType;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDept(String Dept) {
        this.Dept = Dept;
    }

    public void setResidentId(String residentId) {
        this.residentId = residentId;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public void setAnnType(String annType) {
        this.annType = annType;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAnnounceText(String announceText) {
        this.announceText = announceText;
    }
    

    @Override
    public String toString() {
        return  "Date"+ date +"\n"+ "To: " + Dept + "\n" + residentId + "," + houseNo + "\n"+ ", annType=" + annType +"\n" + announceText;
    }
    
    
    
    
    
}
