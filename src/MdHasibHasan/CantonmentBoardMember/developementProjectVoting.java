/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Hasib
 */
public class developementProjectVoting implements Serializable {
    private String projectName;
    private developementProject votingProject;
    private LocalDate votingStartDate;

    public developementProjectVoting(String projectName, developementProject votingProject, LocalDate votingStartDate) {
        this.projectName = projectName;
        this.votingProject = votingProject;
        this.votingStartDate = votingStartDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public developementProject getVotingProject() {
        return votingProject;
    }

    public LocalDate getVotingStartDate() {
        return votingStartDate;
    }
    
    
}
