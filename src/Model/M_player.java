/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Álvaro
 */
public class M_player {
    
    private int id;
    private String name;
    private int hp;
    private int wp;
    private int energy;
    private boolean tctrl;
    private int rollsAvailable;
    private ArrayList<M_Pcard> cards;

    public M_player(int id, String name) {
        this.id = id;
        this.hp = 10;
        this.wp = 0;
        this.energy = 999;
        this.tctrl = false;
        this.rollsAvailable = 3;
        this.name = name;
        this.cards = new ArrayList<>();
    }
    
    public M_player() {
        
    }

    public ArrayList<M_Pcard> getCards() {
        return cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getWp() {
        return wp;
    }

    public void setWp(int wp) {
        this.wp = wp;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public boolean isTctrl() {
        return tctrl;
    }

    public void setTctrl(boolean tctrl) {
        this.tctrl = tctrl;
    }

    public int getRollsAvailable() {
        return rollsAvailable;
    }

    public void setRollsAvailable(int rollsAvailable) {
        this.rollsAvailable = rollsAvailable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
