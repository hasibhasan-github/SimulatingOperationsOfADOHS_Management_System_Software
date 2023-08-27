/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdMasumBilla;

import java.io.Serializable;

/**
 *
 * @author Masum
 */
public class FinishingWorks implements Serializable {
    private String workType,applicationStatus;
    private int estimatedDurationInDays;
    private boolean isCompleted;

    public FinishingWorks(String workType, int estimatedDurationInDays,String applicationStatus) {
        this.workType = workType;
        this.estimatedDurationInDays = estimatedDurationInDays;
        this.applicationStatus = applicationStatus;
        this.isCompleted = false;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public String getWorkType() {
        return workType;
    }

    public int getEstimatedDurationInDays() {
        return estimatedDurationInDays;
    }

    public boolean isCompleted() {
        return isCompleted;
    }
    
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "FinishingWorks{" + "workType=" + workType + ", estimatedDurationInDays=" + estimatedDurationInDays + ", applicationStatus=" + applicationStatus + ", isCompleted=" + isCompleted + '}';
    }

    
}
