/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import java.io.Serializable;

/**
 *
 * @author Hasib
 */

public class residentVote implements Serializable {
    private String voterEmail, residentVote;
    private int voterId;
    private developementProject votingProject;

    public residentVote(String voterEmail, String residentVote, int voterId, developementProject votingProject) {
        this.voterEmail = voterEmail;
        this.residentVote = residentVote;
        this.voterId = voterId;
        this.votingProject = votingProject;
    }

    public void setResidentVote(String residentVote) {
        this.residentVote = residentVote;
    }

    public String getVoterEmail() {
        return voterEmail;
    }

    public String getResidentVote() {
        return residentVote;
    }

    public int getVoterId() {
        return voterId;
    }

    public developementProject getVotingProject() {
        return votingProject;
    }
    
    
}
