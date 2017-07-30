/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxeler;

/**
 *
 * @author robpd
 */
//Holds all data required to draw shape
//TO DO implement Type as enum
public class Shape {
    private String type;
    private int desiredX;
    private int desiredY;
    private int size;
    
    public Shape(String type, int desiredX, int desiredY, int size){
        this.type = type;
        this.desiredX = desiredX;
        this.desiredY = desiredY;
        this.size = size;
    }
    
    public String getType(){
        return type;
    }
    
    public int getDesiredX(){
        return desiredX;
    }
    
    public int getDesiredY(){
        return desiredY;
    }
    
    public int getSize(){
        return size;
    }
}
