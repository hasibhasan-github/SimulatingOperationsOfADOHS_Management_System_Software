/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author Hasib
 */

public class yearlyBudget implements Serializable {
    private String budgetYear;
    private float totalBudgetAmount;
    private Map<String, Float> budgetProjectAndAmountList;

    public yearlyBudget(String budgetYear, float totalBudgetAmount, Map<String, Float> budgetProjectAndAmountList) {
        this.budgetYear = budgetYear;
        this.totalBudgetAmount = totalBudgetAmount;
        this.budgetProjectAndAmountList = budgetProjectAndAmountList;
    }

    public String getBudgetYear() {
        return budgetYear;
    }

    public float getTotalBudgetAmount() {
        return totalBudgetAmount;
    }

    public Map<String, Float> getBudgetProjectAndAmountList() {
        return budgetProjectAndAmountList;
    }

    @Override
    public String toString() {
        return "yearlyBudget{" + "budgetYear=" + budgetYear + ", totalBudgetAmount=" + totalBudgetAmount + ", budgetProjectAndAmountList=" + budgetProjectAndAmountList + '}';
    }

}
