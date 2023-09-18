/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;



import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Hasib
 */

public class iconTitleclass {
    // Parent root = FXMLLoader.load(getClass().getResource("dohsLoginPage.fxml"));

    public void setIconAndTitle(Stage stg){
        stg.setTitle("DOHS Management System Software");
        
        Image icon = new Image(getClass().getResourceAsStream("mirpurdohslogo.png"));
        stg.getIcons().add(icon);
    }
}
