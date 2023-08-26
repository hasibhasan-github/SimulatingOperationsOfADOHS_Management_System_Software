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
public class CheckPointData implements Serializable{
    String checkpointNo, oOfOfficers;
    LocalDate date;

    public CheckPointData(String checkpointNo, String oOfOfficers, LocalDate date) {
        this.checkpointNo = checkpointNo;
        this.oOfOfficers = oOfOfficers;
        this.date = date;
    }

    public String getCheckpointNo() {
        return checkpointNo;
    }

    public String getoOfOfficers() {
        return oOfOfficers;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setCheckpointNo(String checkpointNo) {
        this.checkpointNo = checkpointNo;
    }

    public void setoOfOfficers(String oOfOfficers) {
        this.oOfOfficers = oOfOfficers;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "CheckPointData:" + "checkpointNo=" + checkpointNo + ", oOfOfficers=" + oOfOfficers + ", date=" + date + "\n";
    }
    
    
    
    
    
    
    
}
