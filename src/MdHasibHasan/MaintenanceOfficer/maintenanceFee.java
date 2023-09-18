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

public class maintenanceFee implements Serializable {
    private int residentId;
    private String month, year, residentEmail;
    private final float maintenanceFee = (float) 5000.00;
    private boolean paymentStatus;

    public maintenanceFee(int residentId, String month, String year, String residentEmail, boolean paymentStatus) {
        this.residentId = residentId;
        this.month = month;
        this.year = year;
        this.residentEmail = residentEmail;
        this.paymentStatus = paymentStatus;
    }

    public int getResidentId() {
        return residentId;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getResidentEmail() {
        return residentEmail;
    }

    public float getMaintenanceFee() {
        return maintenanceFee;
    }

    public boolean isPaymentStatus() {
        return paymentStatus;
    }

    @Override
    public String toString() {
        return "maintenanceFee{" + "residentId=" + residentId + ", month=" + month + ", year=" + year + ", residentEmail=" + residentEmail + ", maintenanceFee=" + maintenanceFee + ", paymentStatus=" + paymentStatus + '}';
    }


}
