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
public class FinAnalysis implements Serializable {
    private String report;

    public FinAnalysis(String report) {
        this.report = report;
    }

    public String getReport() {
        return report;
    }
}
