/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Hasib
 */

public class developementProject implements Serializable {
    private String projectName;
    private LocalDate projectStartDate;
    private ArrayList<String> projectDescription;

    public developementProject(String projectName, LocalDate projectStartDate, ArrayList<String> projectDescription) {
        this.projectName = projectName;
        this.projectStartDate = projectStartDate;
        this.projectDescription = projectDescription;
    }

    public String getProjectName() {
        return projectName;
    }

    public LocalDate getProjectStartDate() {
        return projectStartDate;
    }

    public ArrayList<String> getProjectDescription() {
        return projectDescription;
    }
    

}
