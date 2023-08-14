/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan.MaintenanceOfficer;

import java.io.Serializable;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Hasib
 */
public class carStickerRequest implements Serializable {
    private int id;
    private String applicationStatus;
    private String email, paymentStatus;

    public carStickerRequest(int id, String applicationStatus, String email, String paymentStatus) {
        this.id = id;
        this.applicationStatus = applicationStatus; //new SimpleStringProperty (applicationStatus);
        this.email = email;
        this.paymentStatus = paymentStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public int getId() {
        return id;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public String getEmail() {
        return email;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }


    
    
}
