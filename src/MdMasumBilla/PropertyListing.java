/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdMasumBilla;

/**
 *
 * @author MD Masum Billa
 */
public class PropertyListing {
    private String title;
    private String description;
    private double price;
    private String location;
    
    public PropertyListing(String title, String description, double price, String location) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.location = location;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getDescription() {
        return description;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getLocation() {
        return location;
    }
}
