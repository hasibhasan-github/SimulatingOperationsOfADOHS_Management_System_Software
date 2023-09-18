/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package simulatingoperationsofdohs_management_system_software;

import MdHasibHasan.iconTitleclass;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hasib
 */

public class SimulatingOperationsOfDOHS_Management_System_Software extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
        
        Scene scene = new Scene(root);
        
        // Code For setting Scene Icon and Title
        stage.setScene(scene);
        iconTitleclass sp = new iconTitleclass();
        sp.setIconAndTitle(stage);
        //stage.setTitle("DOHS Management System Software");
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
