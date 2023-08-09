/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Hasib
 */
public abstract class Employee extends User implements Serializable {
    protected LocalDate dateOoJoin;
    protected float salary;
    protected String department, designation;

    public Employee(int id, String name, String gender, String email, String userType, LocalDate deathOfBirth, long contactNo) {
        super(id, name, gender, email, userType, deathOfBirth, contactNo);
    }
    
    protected abstract void applyForLeave();
}
