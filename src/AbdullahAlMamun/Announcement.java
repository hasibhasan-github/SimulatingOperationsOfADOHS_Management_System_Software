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
public class Announcement implements Serializable{
    String annType, annText;
    LocalDate date;

    public Announcement(String annType, String annText, LocalDate date) {
        this.annType = annType;
        this.annText = annText;
        this.date = date;
    }

    public String getAnnType() {
        return annType;
    }

    public String getAnnText() {
        return annText;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setAnnType(String annType) {
        this.annType = annType;
    }

    public void setAnnText(String annText) {
        this.annText = annText;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Announcement\n" + "Date:" +date+"\n" + "Announcement Type:"+ annType+"\n" + annText;
    }
    
    
    
}
