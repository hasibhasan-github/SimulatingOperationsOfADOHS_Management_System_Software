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
    private String purposeOfVisitToDohsData, timeSlotOfVisitToDohs;
    private int purposeOfVisitCount, totalTimeSlotVisitCount;

    public reportFromSecurityDepartment(String purposeOfVisitToDohsData, String timeSlotOfVisitToDohs, int purposeOfVisitCount, int totalTimeSlotVisitCount) {
        this.purposeOfVisitToDohsData = purposeOfVisitToDohsData;
        this.timeSlotOfVisitToDohs = timeSlotOfVisitToDohs;
        this.purposeOfVisitCount = purposeOfVisitCount;
        this.totalTimeSlotVisitCount = totalTimeSlotVisitCount;
    }

    public String getPurposeOfVisitToDohsData() {
        return purposeOfVisitToDohsData;
    }

    public String getTimeSlotOfVisitToDohs() {
        return timeSlotOfVisitToDohs;
    }

    public int getPurposeOfVisitCount() {
        return purposeOfVisitCount;
    }

    public int getTotalTimeSlotVisitCount() {
        return totalTimeSlotVisitCount;
    }
    
}
