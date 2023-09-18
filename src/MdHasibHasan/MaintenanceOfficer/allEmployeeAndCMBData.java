/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import java.io.Serializable;

/**
 *
 * @author Hasib
 */

public class allEmployeeAndCMBData implements Serializable {
    private int id;
    private String employeeOrCMBName, designation, department;
    private long contactNo;

    public allEmployeeAndCMBData(int id, String employeeOrCMBName, String designation, String department, long contactNo) {
        this.id = id;
        this.employeeOrCMBName = employeeOrCMBName;
        this.designation = designation;
        this.department = department;
        this.contactNo = contactNo;
    }

    public int getId() {
        return id;
    }

    public String getEmployeeOrCMBName() {
        return employeeOrCMBName;
    }

    public String getDesignation() {
        return designation;
    }

    public String getDepartment() {
        return department;
    }

    public long getContactNo() {
        return contactNo;
    }

    @Override
    public String toString() {
        return "allEmployeeAndCMBData{" + "id=" + id + ", employeeOrCMBName=" + employeeOrCMBName + ", designation=" + designation + ", department=" + department + ", contactNo=" + contactNo + '}';
    }
    
}
