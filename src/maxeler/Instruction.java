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

//Holds all data for single instruction
//TO DO- implement operations as ENUM
public class Instruction {
    public final int binop;
    public final int operation;
    public final int optionalData;
    
    
    public Instruction(int binop, int operation, int optionalData){
        this.binop = binop;      
        this.operation =  operation;
        this.optionalData = optionalData;   
    }
    
}
