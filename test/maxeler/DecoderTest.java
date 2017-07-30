/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxeler;

import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author robpd
 */
public class DecoderTest {
    
    public DecoderTest() {
    }

//    @Ignore
//    public void testConvertHexToBinaryString() {
//        String testInput = "84000000";
//        
//        String expected = "10000100000000000000000000000000";
//        String result = Decoder.convertHexToBinaryString(testInput);
//        assertEquals(expected, result);
//    }
    
    @Test
    public void testConvertHexToInt(){
        String test = "0a000000";
        
        int expected = 167772160;
        int result = Decoder.convertHexToInt(test);
        
        assertEquals(expected,result);
    }
    
    @Ignore 
    public void testConvertIntToBinaryString(){
        String testInput = "84000000";
        
        int testInputInt = (int) Long.parseLong(testInput, 16);
            
        System.out.println("testInputInt " + testInputInt);
        
        String expected = "10000100000000000000000000000000";
        String result = Decoder.convertIntToBinaryString(testInputInt);
        
        System.out.println("Test output - " + result);
        
        assertEquals(expected, result);
        
        
    }
    
    @Ignore
    public void testConvertBinaryToInt(){
        String testInput = "100011";
        
        int expected = 35;
        int result = Decoder.convertBinaryToInt(testInput);
        
        assertEquals(expected, result);
         
    }
    
    @Ignore
    public void testDecode(){
        String testInput = "84000000";
        
        
       // Instruction instr = Decoder.decode(testInput);
        
        int i = 0;
    }
    
}
