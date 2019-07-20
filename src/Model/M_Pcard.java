/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Álvaro
 */
public class M_Pcard {
    
    private int id;
    private int cost;
    private String name;
    private String type;
    private String effect;
    private int wpChange;
    private int hpChange;
    private int enrgChange;

    public M_Pcard(int id, int cost, String name, String type, String effect) {
        this.cost = cost;
        this.id = id;
        this.name = name;
        this.type = type;
        this.effect = effect;
    }
    
    public M_Pcard(int id, int cost, String name, String type, String effect, int wpChange, int hpChange, int enrgChange) {
        this.cost = cost;
        this.id = id;
        this.name = name;
        this.type = type;
        this.effect = effect;
        this.enrgChange = enrgChange;
        this.hpChange = hpChange;
        this.wpChange = wpChange;
    }
    
    public M_Pcard(){
        
    }

    public int getWpChange() {
        return wpChange;
    }

    public void setWpChange(int wpChange) {
        this.wpChange = wpChange;
    }

    public int getHpChange() {
        return hpChange;
    }

    public void setHpChange(int hpChange) {
        this.hpChange = hpChange;
    }

    public int getEnrgChange() {
        return enrgChange;
    }

    public void setEnrgChange(int enrgChange) {
        this.enrgChange = enrgChange;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEffect() {
        return effect;
    }

    public void setEffect(String effect) {
        this.effect = effect;
    }
    
}
