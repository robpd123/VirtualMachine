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

//Takes care of any radix/type changes
public class Decoder {

    public static Instruction decode(int instruction) {
        String binary = convertIntToBinaryString(instruction);

        int op = convertBinaryToInt(binary.substring(0, 1));
        int operation = convertBinaryToInt(binary.substring(1, 8));
        int optional = convertBinaryToInt(binary.substring(8, 32));

        return new Instruction(op, operation, optional);
    }

    //Converts signed int to 32 bit binary string
    public static String convertIntToBinaryString(int integer) {
        String converted = Integer.toBinaryString(integer);
        
        int length = converted.length();
        if (length < 32) {
            for (int i = 0; i < 32 - length; i++) {
                converted = "0" + converted;
            }
        }

        return converted;
    }

    //Converts Binary String to Integer
    public static int convertBinaryToInt(String binaryString) {
        return (int) Long.parseLong(binaryString, 2);
    }
    
    //Converts hex String to Signed Integer
    public static int convertHexToInt(String hexString){
        return (int) Long.parseLong(hexString,16);
    }

}
