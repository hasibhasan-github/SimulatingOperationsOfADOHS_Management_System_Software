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
public class PublicProperties implements Serializable {
    private int id;
    private String email,  month, year, organizationType;
    private double donatedAmount;

    public PublicProperties(int id, String email, String month, String year, String organizationType, double donatedAmount) {
        this.id = id;
        this.email = email;
        this.month = month;
        this.year = year;
        this.organizationType = organizationType;
        this.donatedAmount = donatedAmount;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getOrganizationType() {
        return organizationType;
    }

    public double getDonatedAmount() {
        return donatedAmount;
    }


}
