/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author Hasib
 */

public class GenerateAlerts {
    public static void successfulAlert(String str){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Information alert");
            alert.setContentText(str);
            alert.showAndWait();
    }
    public static void unsuccessfulAlert(String str){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText("Error!");
            alert.setContentText(str);
            alert.showAndWait(); 
    }
    public static boolean confirmationAlert(){
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Confirmation");
        confirmationAlert.setHeaderText("This is a confirmation alert");
        confirmationAlert.setContentText("Do you want to proceed?");
        
        ButtonType result = confirmationAlert.showAndWait().orElse(ButtonType.CANCEL);
        
        return result == ButtonType.OK;
    }
}
