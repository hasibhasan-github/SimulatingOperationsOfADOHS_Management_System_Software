/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdMasumBilla;

import java.io.Serializable;

/**
 *
 * @author MD Masum Billa
 */
public class FinancialRisk implements Serializable{
    private String riskName;
    private String description;
    private double likelihood;
    private double impact;

    public FinancialRisk(String riskName, String description, double likelihood, double impact) {
        this.riskName = riskName;
        this.description = description;
        this.likelihood = likelihood;
        this.impact = impact;
    }

    public String getRiskName() {
        return riskName;
    }

    public String getDescription() {
        return description;
    }

    public double getLikelihood() {
        return likelihood;
    }

    public double getImpact() {
        return impact;
    }
    
    @Override
    public String toString() {
        return "FinancialRisk{" + "riskName=" + riskName + ", description=" + description + ", likelihood=" + likelihood + ", impact=" + impact + '}';
    }
    
}
