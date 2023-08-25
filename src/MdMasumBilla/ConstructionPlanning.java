/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdMasumBilla;

import java.time.LocalDate;

/**
 *
 * @author MD Masum Billa
 */

public class ConstructionPlanning {
    private String projectTitle;
    private String projectScope;
    private LocalDate startDate;
    private LocalDate endDate;
    private double budget;

    public ConstructionPlanning(String projectTitle, String projectScope, LocalDate startDate, LocalDate endDate, double budget) {
        this.projectTitle = projectTitle;
        this.projectScope = projectScope;
        this.startDate = startDate;
        this.endDate = endDate;
        this.budget = budget;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public String getProjectScope() {
        return projectScope;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public double getBudget() {
        return budget;
    }
    
    @Override
    public String toString() {
        return "ConstructionPlanning{" + "projectTitle=" + projectTitle + ", projectScope=" + projectScope + ", startDate=" + startDate + ", endDate=" + endDate + ", budget=" + budget + '}';
    }
}

