/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.CantonmentBoardMember;

import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.ObservableList;

/**
 *
 * @author Hasib
 */
public class dohsPolicies implements Serializable {
    private String policcyName;
    private LocalDate policyCreationDate;

    public dohsPolicies(String policcyName, LocalDate policyCreationDate) {
        this.policcyName = policcyName;
        this.policyCreationDate = policyCreationDate;
    }

    public String getPoliccyName() {
        return policcyName;
    }

    public void setPoliccyName(String policcyName) {
        this.policcyName = policcyName;
    }

    public LocalDate getPolicyCreationDate() {
        return policyCreationDate;
    }

    public void setPolicyCreationDate(LocalDate policyCreationDate) {
        this.policyCreationDate = policyCreationDate;
    }
    
    public static ObservableList<dohsPolicies> seeAllThePolicies(){
        
        return null;
        
    }

}
