/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdMasumBilla;

import java.io.Serializable;

/**
 *
 * @author Masum
 */
public class PropertyTransaction implements Serializable {
    private String propertyType;
    private String title;
    private String description;
    private double price;
    private String location;

    public PropertyTransaction(String propertyType, String title, String description, double price, String location) {
        this.propertyType = propertyType;
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Property Type: " + propertyType + "\n"
                + "Title: " + title + "\n"
                + "Description: " + description + "\n"
                + "Price: " + price + "\n"
                + "Location: " + location;
    }
}
