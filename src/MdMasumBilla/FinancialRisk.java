/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdMasumBilla;

/**
 *
 * @author MD Masum Billa
 */
public class FinancialRisk {
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
    
}
