/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdMasumBilla;

/**
 *
 * @author MD Masum Billa
 */
import javafx.collections.ObservableList;

public class ProjectManagement {
    private String projectName;
    private String projectManager;
    private int teamSize;
    private ObservableList<String> projectPhases;

    public ProjectManagement(String projectName, String projectManager, int teamSize, ObservableList<String> projectPhases) {
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.teamSize = teamSize;
        this.projectPhases = projectPhases;
    }
    
    public String getProjectName() {
        return projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public ObservableList<String> getProjectPhases() {
        return projectPhases;
    }
    
    @Override
    public String toString() {
        return "ProjectManagement{" + "projectName=" + projectName + ", projectManager=" + projectManager + ", teamSize=" + teamSize + ", projectPhases=" + projectPhases + '}';
    }
}
