/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import java.io.Serializable;
import java.util.Map;

/**
 *
 * @author Hasib
 */

public class monthlyReport implements Serializable {
    private String month, year;
    private Double totalExpendedAmount;
    private Map<String, Double> expendedOrgAndAmount;

    public monthlyReport(String month, String year, Double totalExpendedAmount, Map<String, Double> expendedOrgAndAmount) {
        this.month = month;
        this.year = year;
        this.totalExpendedAmount = totalExpendedAmount;
        this.expendedOrgAndAmount = expendedOrgAndAmount;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public Double getTotalExpendedAmount() {
        return totalExpendedAmount;
    }

    public Map<String, Double> getExpendedOrgAndAmount() {
        return expendedOrgAndAmount;
    }
 
}
