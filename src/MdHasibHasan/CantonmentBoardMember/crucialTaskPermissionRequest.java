/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Hasib
 */

public class crucialTaskPermissionRequest implements Serializable {
    private int ID;
    private String eventNamme, department, permissionStatus;
    private LocalDate applicationDate, eventDate;
    private ArrayList<String> eventDescription;

    public crucialTaskPermissionRequest(int ID, String eventNamme, String department, LocalDate applicationDate, LocalDate eventDate, ArrayList<String> eventDescription) {
        this.ID = ID;
        this.eventNamme = eventNamme;
        this.department = department;
        this.applicationDate = applicationDate;
        this.eventDate = eventDate;
        this.eventDescription = eventDescription;
        this.permissionStatus = "Pending";
    }

    public void setPermissionStatus(String permissionStatus) {
        this.permissionStatus = permissionStatus;
    }

    public int getID() {
        return ID;
    }

    public String getEventNamme() {
        return eventNamme;
    }

    public String getDepartment() {
        return department;
    }

    public String getPermissionStatus() {
        return permissionStatus;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public ArrayList<String> getEventDescription() {
        return eventDescription;
    }
    
}
