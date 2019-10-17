/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nu.te4.enemyapp.enteties;

/**
 *
 * @author Daniel
 */
public class Enemy {
    private int id;
    private String name; 
    private int defence; 
    private int attack; 
    private int health; 

    public Enemy(int id, String name, int defence, int attack, int health) {
        this.id = id;
        this.name = name;
        this.defence = defence;
        this.attack = attack;
        this.health = health;
    }

    public Enemy() {
    }

    public Enemy(String name, int defence, int attack, int health) {
        this.name = name;
        this.defence = defence;
        this.attack = attack;
        this.health = health;
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

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
    
}
