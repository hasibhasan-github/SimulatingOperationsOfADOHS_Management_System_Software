/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package MdMasumBilla;

/**
 *
 * @author MD Masum Billa
 */

//public class FinancialAnalysis {
    /*
    private double totalIncome;
    private double totalExpenses;
    private double netIncome;
    //private double currentRatio;
    //private double debtToEquityRatio;
    private double netProfitMargin;
    private double returnOnAssets;
    private double assetTurnover;
    private double averageTotalAssets;

    public FinancialAnalysis(double totalIncome, double totalExpenses, double netIncome,
                             //double currentRatio, double debtToEquityRatio,
                             double netProfitMargin, double returnOnAssets, double assetTurnover,
                             double averageTotalAssets) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.netIncome = netIncome;
        //this.currentRatio = currentRatio;
        //this.debtToEquityRatio = debtToEquityRatio;
        this.netProfitMargin = netProfitMargin;
        this.returnOnAssets = returnOnAssets;
        this.assetTurnover = assetTurnover;
        this.averageTotalAssets = averageTotalAssets;
    }

    public double getAverageTotalAssets() {
        return averageTotalAssets;
    }
    
    public double getTotalIncome() {
        return totalIncome;
    }

    public double getTotalExpenses() {
        return totalExpenses;
    }

    public double getNetIncome() {
        netIncome = getTotalIncome() - getTotalExpenses();
        return netIncome;
    }
/*
    public double getCurrentRatio() {
        return currentRatio;
    }

    public double getDebtToEquityRatio() {
        return debtToEquityRatio;
    }

    public double getNetProfitMargin() {
        netProfitMargin = (getNetIncome() / getTotalIncome()) * 100;
        return netProfitMargin;
    }

    public double getReturnOnAssets() {
        returnOnAssets = getNetIncome() / getAverageTotalAssets();
        return returnOnAssets;
    }

    public double getAssetTurnover() {
        assetTurnover = getTotalIncome() / getAverageTotalAssets();
        return assetTurnover;
    }

   
    public String generateReport() {
        double riskScore = (likelihood * impact);
        String riskStatus;

        if (riskScore >= 0.7) {
            riskStatus = "High Risk";
        } else if (riskScore >= 0.4) {
            riskStatus = "Medium Risk";
        } else {
            riskStatus = "Low Risk";
        }

        return "Risk: " + riskName +
               "\nDescription: " + description +
               "\nLikelihood: " + likelihood +
               "\nImpact: " + impact +
               "\nRisk Score: " + riskScore +
               "\nRisk Status: " + riskStatus + "\n";
    }
*/
//}

package MdMasumBilla;

import java.io.Serializable;

public class FinancialAnalysis implements Serializable{
    private double totalIncome;
    private double totalExpenses;
    private double netIncome;
    private double netProfitMargin;
    private double returnOnAssets;
    private double assetTurnover;
    private double averageTotalAssets;

    public FinancialAnalysis(double totalIncome, double totalExpenses,
                             double averageTotalAssets) {
        this.totalIncome = totalIncome;
        this.totalExpenses = totalExpenses;
        this.averageTotalAssets = averageTotalAssets;
        
        this.netIncome = totalIncome - totalExpenses;
        this.netProfitMargin = (netIncome / totalIncome) * 100.0;
        this.returnOnAssets = netIncome / averageTotalAssets;
        this.assetTurnover = totalIncome / averageTotalAssets;
    }

    public double getNetIncome() {
        return netIncome;
    }

    public double getNetProfitMargin() {
        return netProfitMargin;
    }

    public double getReturnOnAssets() {
        return returnOnAssets;
    }

    public double getAssetTurnover() {
        return assetTurnover;
    }

    public double getAverageTotalAssets() {
        return averageTotalAssets;
    }

    @Override
    public String toString() {
        return "FinancialAnalysis{" + "totalIncome=" + totalIncome + ", totalExpenses=" + totalExpenses + ", netIncome=" + netIncome + ", netProfitMargin=" + netProfitMargin + ", returnOnAssets=" + returnOnAssets + ", assetTurnover=" + assetTurnover + ", averageTotalAssets=" + averageTotalAssets + '}';
    }
}

