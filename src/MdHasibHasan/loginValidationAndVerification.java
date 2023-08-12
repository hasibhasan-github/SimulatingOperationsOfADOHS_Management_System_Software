/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;

import java.time.LocalDate;
import java.time.Period;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author Hasib
 */
public final class loginValidationAndVerification {
    public static boolean isValidEmail(String email){
        String emailPattern = "^[A-Za-z0-9+_.-]+@(.+)$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    
    public static boolean isValidPassword(String password){
        String pass = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$";
        Pattern pattern = Pattern.compile(pass);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    public static boolean isValidId (String userId){
        String id = "^\\d{6}$";
        Pattern pattern = Pattern.compile(id);
        Matcher matcher = pattern.matcher(userId);
        return matcher.matches();
    }
    
    public static boolean isValidBirthDate(LocalDate dob){
        LocalDate today =   LocalDate.now();
        int period =  Period.between(dob, today).getYears();

        if ( period >= 18 ) return true;
        return false;
    }
    
    public static final boolean validationProcessOfData( String emailOrId, String pass, Label emailErrorLabel,
                                                       TextField emailOrIdTextField, Label passwordErrorLabel,
                                                       PasswordField passwordField){
        if ( emailOrId.length() > 6 ){
            if (loginValidationAndVerification.isValidEmail(emailOrId)){
                emailErrorLabel.setVisible(false);
                emailOrIdTextField.setStyle("-fx-border-color: transparent;");
            }
            else{
                emailErrorLabel.setText("Invalid Email");
                emailErrorLabel.setVisible(true);
                emailOrIdTextField.setStyle("-fx-border-color: red;");
                return false;
            }
        }
        else {
            if (loginValidationAndVerification.isValidId(emailOrId)){
                emailErrorLabel.setVisible(false);
                emailOrIdTextField.setStyle("-fx-border-color: transparent;");
            }
            else{
                emailErrorLabel.setText("Invalid ID");
                emailErrorLabel.setVisible(true);
                emailOrIdTextField.setStyle("-fx-border-color: red;");
                return false;
            }
        }
        if ( loginValidationAndVerification.isValidPassword(pass) ){
                passwordErrorLabel.setVisible(false);
                passwordField.setStyle("-fx-border-color: transparent;");
        }
        else{
                passwordErrorLabel.setText("*Password must content" + " One digit" + "\n" +
                                    "*One Uppercase and Lowercase letter" + "\n" + 
                                    "*One special character");
                passwordErrorLabel.setVisible(true);
                passwordField.setStyle("-fx-border-color: red;");
                return false;
        }
        return true;
        
    }

}
