/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MdHasibHasan;

/**
 *
 * @author Hasib
 */

import java.util.Random;

public class CustomRandom extends Random {
    
    public int nextInt(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException("Start cannot be greater than end");
        }
        
        int range = end - start + 1;
        return nextInt(range) + start;
    }
}

