/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Hasib
 */
public class sceneChanging {
    
    public void sceneSwitchingWithoutDataPassing(Stage stage, String str) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(str)); 
    
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        
        //Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        stage.setScene(scene);
        stage.show();
        
        
    }
}
