/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxeler;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author robpd
 */
public class run {

    public static void main(String[] args) {
        ArrayList<Shape> inputShapes = createShapes();
        int[] shapeOrder = createShapeOrder();

        String VMOutputFile = "output.svg";
        String InputBuilderFile = "resultPart2.txt";

        VirtualMachine vm = new VirtualMachine();
        InputBuilder ib = new InputBuilder();

        String input = ib.createInput(inputShapes, shapeOrder);

        writeInputBuilderOutputToFile(input, InputBuilderFile);

        ArrayList<Integer> outputBuffer = vm.run("task2.bin", input);

        if (outputBuffer.size() > 0) {
            writeVMOutputToFile(outputBuffer, VMOutputFile);
        }
        //Output length of input command
        //System.out.println(input.length());
    }

    //Creates ArrayList holding shapes required to draw SVG
    //TO DO - rename shape types to be more descriptive
    private static ArrayList<Shape> createShapes() {
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        shapes.add(new Shape("A1", 0, 0, 10));      //0
        shapes.add(new Shape("B1", 105, 65, 10));   //1
        shapes.add(new Shape("B1", 180, 45, 10));   //2
        shapes.add(new Shape("E1", 255, 65, 10));   //3
        shapes.add(new Shape("A2", 400, 0, 10));    //4
        shapes.add(new Shape("B2", 350, 120, 10));  //5
        shapes.add(new Shape("E1", 330, 195, 10));  //6
        shapes.add(new Shape("D1", 310, 270, 10));  //7
        shapes.add(new Shape("A2", 400, 360, 10));  //8
        shapes.add(new Shape("C2", 295, 325, 10));  //9
        shapes.add(new Shape("D2", 220, 345, 10));  //10
        shapes.add(new Shape("D2", 145, 325, 10));  //11
        shapes.add(new Shape("A3", 0, 400, 10));    //12
        shapes.add(new Shape("C1", 50, 270, 10));   //13
        shapes.add(new Shape("B1", 30, 195, 10));   //14
        shapes.add(new Shape("B1", 50, 120, 10));   //15
        shapes.add(new Shape("B1", 120, 160, 40));   //16
        shapes.add(new Shape("B3", 260, 200, 30));  //17
        shapes.add(new Shape("B1", 160, 240, 20));  //18
        shapes.add(new Shape("B3", 220, 260, 10));  //19
        shapes.add(new Shape("B1", 190, 280, 5));   //20

        return shapes;
    }

    //Creates array that contains order shapes should be printed in
    private static int[] createShapeOrder() {
        int[] shapeOrder = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; //828

        return shapeOrder;

    }

    //Saves output to file
    private static void writeVMOutputToFile(List<Integer> outputBuffer, String VMOutputFile) {
        char[] output = new char[outputBuffer.size()];
        for (int i = 0; i < outputBuffer.size(); i++) {
            //Convert Integer to int to allow type casting
            int outputBufferInt = outputBuffer.get(i);
            output[i] = (char) outputBufferInt;
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(VMOutputFile));
            bufferedWriter.write(output);
            bufferedWriter.close();
        } catch (IOException e) {
            //TO DO - implement meaningful Exception handling
        }
    }

    private static void writeInputBuilderOutputToFile(String input, String inputBuilderFile) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(inputBuilderFile));
            bufferedWriter.write(input);
            bufferedWriter.close();
        } catch (IOException e) {
            //TO DO - implement meaningful Exception handling 
        }
    }

}
