/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdMasumBilla;

/**
 *
 * @author MD Masum Billa
 */
public class RiskAnalyzer {
    public static String analyzeRisk(FinancialRisk risk) {
        double riskScore = risk.getLikelihood() * risk.getImpact();
        String riskStatus = "Low";

        if (riskScore > 0.5) {
            riskStatus = "Moderate";
        }

        if (riskScore > 0.7) {
            riskStatus = "High";
        }

        return "Risk Name: " + risk.getRiskName() + "\n"+
               "Description: " + risk.getDescription() + "\n"+
               "Likelihood: " + risk.getLikelihood() + "\n"+
               "Impact: " + risk.getImpact() + "\n"+
               "Risk Score: " + riskScore + "\n"+
               "Risk Status: " + riskStatus + "\n";
    }
}
