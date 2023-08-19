/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.ObservableList;

/**
 *
 * @author Hasib
 */
public class dohsPolicies implements Serializable {
    private String policyName;
    private LocalDate policyCreationDate;
    private LocalDate policyLastEditedDate;
    private ArrayList<String> policyDescription;

    public dohsPolicies(String policyName, LocalDate policyCreationDate, LocalDate policyLastEditedDate, ArrayList<String> policyDescription) {
        this.policyName = policyName;
        this.policyCreationDate = policyCreationDate;
        this.policyLastEditedDate = policyLastEditedDate;
        this.policyDescription = policyDescription;
    }

    public String getPolicyName() {
        return policyName;
    }

    public LocalDate getPolicyCreationDate() {
        return policyCreationDate;
    }

    public LocalDate getPolicyLastEditedDate() {
        return policyLastEditedDate;
    }

    public ArrayList<String> getPolicyDescription() {
        return policyDescription;
    }

    public void setPolicyLastEditedDate(LocalDate policyLastEditedDate) {
        this.policyLastEditedDate = policyLastEditedDate;
    }

    public void setPolicyDescription(ArrayList<String> policyDescription) {
        this.policyDescription = policyDescription;
    }
}
