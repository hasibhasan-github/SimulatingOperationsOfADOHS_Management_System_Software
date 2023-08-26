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
public class BudgetingAndForecasting implements Serializable {
    
    private String item;
    private float value;
        
    public BudgetingAndForecasting(String item,float value){
        this.item = item;
        this.value = value;
    }
        
    public String getItem(){
        return item;
    }
        
    public float getValue(){
        return value;
    }
        
    public String setItem(String item){
        this.item = item;
        return item;
    }
        
    public float setValue(float value){
        this.value = value;
        return value;
    }

    @Override
    public String toString() {
        return "BudgetingAndForecasting{" + "item=" + item + ", value=" + value + '}';
    }     
}   
