/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import java.io.Serializable;

/**
 *
 * @author Hasib
 */

public class reportFromSecurityDepartment implements Serializable {
    private String chatDataType;
    private String timeSlotOrPurposeOfVisit;
    private double timeSlotOrPurposeOfVisitCount;

    public reportFromSecurityDepartment(String chatDataType, String timeSlotOrPurposeOfVisit, double timeSlotOrPurposeOfVisitCount) {
        this.chatDataType = chatDataType;
        this.timeSlotOrPurposeOfVisit = timeSlotOrPurposeOfVisit;
        this.timeSlotOrPurposeOfVisitCount = timeSlotOrPurposeOfVisitCount;
    }

    public String getChatDataType() {
        return chatDataType;
    }

    public String getTimeSlotOrPurposeOfVisit() {
        return timeSlotOrPurposeOfVisit;
    }

    public double getTimeSlotOrPurposeOfVisitCount() {
        return timeSlotOrPurposeOfVisitCount;
    }

    
    
    
    
  
    
}
