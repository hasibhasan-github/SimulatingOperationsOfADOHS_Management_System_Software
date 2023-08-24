/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package MdMasumBilla;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author MD Masum Billa
 */
public class RealEstateAgentDashboardController implements Initializable {

    @FXML
    private ComboBox<String> TitleComboBox;
    @FXML
    private ComboBox<String> DescriptionComboBoox;
    @FXML
    private TextField PriceTextField;
    @FXML
    private ComboBox<String> LocationComboBox;
    @FXML
    private TableView<PropertyListing> tableId;
    @FXML
    private TableColumn<PropertyListing, String> PropertyTitle;
    @FXML
    private TableColumn<PropertyListing, String> PropertyDescription;
    @FXML
    private TableColumn<PropertyListing, Double> PropertyPrice;
    @FXML
    private TableColumn<PropertyListing, String> PropertyLocation;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        TitleComboBox.getItems().addAll( "Modern Downtown Apartment with Stunning Views",
                "Charming Family Home in Suburban Oasis",
                "Luxury Waterfront Villa with Private Dock");
        
        DescriptionComboBoox.getItems().addAll("Discover the epitome of urban living in this downtown apartment, boasting modern design and breathtaking city views",
                "A cozy family home located in a peaceful suburban neighborhood, perfect for comfortable living and creating lasting memories.",
                "An exquisite waterfront villa boasting breathtaking views, luxurious amenities, and direct access to a private dock for aquatic adventures");
        
        LocationComboBox.getItems().addAll("100/a","101/b","102/c");
        
        PropertyTitle.setCellValueFactory(new PropertyValueFactory<PropertyListing,String>("Title"));
        PropertyDescription.setCellValueFactory(new PropertyValueFactory<PropertyListing,String>("Description"));
        PropertyPrice.setCellValueFactory(new PropertyValueFactory<PropertyListing, Double>("Price"));
        PropertyLocation.setCellValueFactory(new PropertyValueFactory<PropertyListing,String>("Location"));
    }     

    @FXML
    private void AddPropertyOnClick(ActionEvent event) {
        PropertyListing property = new PropertyListing(
                TitleComboBox.getValue(),
        DescriptionComboBoox.getValue(),
                Double.parseDouble(PriceTextField.getText()),
                LocationComboBox.getValue());
        
        ObservableList<PropertyListing>property2=tableId.getItems();
        property2.add(property);
        tableId.setItems(property2);
    }

    @FXML
    private void createBinFileOncCick(ActionEvent event) {
    }
    
    @FXML
    void RemoveSelectedIemOnClick(ActionEvent event) {
        int SelectedId = tableId.getSelectionModel().getSelectedIndex();
        tableId.getItems().remove(SelectedId);
    }
}