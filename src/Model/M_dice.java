/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Random;

/**
 *
 * @author Álvaro
 */
public class M_dice {
    
    private final String[] values;
    private final Random rand;

    public M_dice() {
        this.values = new String[]{"one","two","three","heart","claw","energy"};
        this.rand = new Random();
    }
    
    public String roll(){
        return values[rand.nextInt(6)];
    }
    
}
