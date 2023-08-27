/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Abdullah.UtilityServiceManager;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author user
 */
public class ServiceProvider implements Serializable{
    private String providerName, serviceType, LicenceNo, contactNo, contactDuration, activeWorkers;
    private LocalDate date;

    public ServiceProvider(String providerName, String serviceType, String LicenceNo, String contactNo, String contactDuration, String activeWorkers, LocalDate date) {
        this.providerName = providerName;
        this.serviceType = serviceType;
        this.LicenceNo = LicenceNo;
        this.contactNo = contactNo;
        this.contactDuration = contactDuration;
        this.activeWorkers = activeWorkers;
        this.date = date;
    }

    public String getProviderName() {
        return providerName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getLicenceNo() {
        return LicenceNo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public String getContactDuration() {
        return contactDuration;
    }

    public String getActiveWorkers() {
        return activeWorkers;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public void setLicenceNo(String LicenceNo) {
        this.LicenceNo = LicenceNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public void setContactDuration(String contactDuration) {
        this.contactDuration = contactDuration;
    }

    public void setActiveWorkers(String activeWorkers) {
        this.activeWorkers = activeWorkers;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Provider Name: " + providerName + "\n" + "Service Type: "+ serviceType +"\n"+  "Contact No " 
                + contactNo + "\n" + "Active Workers " + activeWorkers + "\n" + "Contract Duration: " + contactDuration;
    }
    
    
    
    
    
    
}
