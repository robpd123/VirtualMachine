/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxeler;

import java.util.ArrayList;

/**
 *
 * @author robpd
 */
public class VirtualMachine {

    private int ip = 0;
    private int sp;
    private int[] data;

    private boolean cont = true;
    private ArrayList<Integer> outputBuffer = new ArrayList<>();

    private char[] inputStream;
    private int inputStreamCtr = 0;

    public VirtualMachine() {
    }
    
    //Runs VM using input file for instructions and input stream as StdIn input
    public ArrayList<Integer> run(String inputFile, String inputStream) {
        Instruction currentInstruction;

        this.inputStream = inputStream.toCharArray();

        data = DataReader.readFile(inputFile, data);
        sp = data.length;

        while (cont) {
            currentInstruction = Decoder.decode(data[ip]);
            ip++;
            execute(currentInstruction);
        }

        return outputBuffer;
    }
    
    //Executes current instruction
    private void execute(Instruction currentInstruction) {
        int addr;
        int output;
        int st_data;
        int x;

        if (currentInstruction.binop == 0) {
            switch (currentInstruction.operation) {
                case 0:
                    sp = sp + 1;
                    break;
                case 1:
                    f(currentInstruction.optionalData);
                    break;
                case 2:
                    f(ip);
                    break;
                case 3:
                    f(sp);
                    break;
                case 4:
                    addr = g();
                    f(data[addr]);
                    break;

                case 5:
                    st_data = g();
                    addr = g();
                    data[addr] = st_data;
                    break;
                case 6:
                    int cond = g();
                    addr = g();

                    if (cond != 0) {
                        ip = addr;
                    }
                    break;
                case 7:
                    if (g() == 0) {
                        f(1);
                    } else {
                        f(0);
                    }
                    break;
                case 8:
                    output = g();
                    output = output & 0xff;
                    outputBuffer.add(output);
                    break;
                case 9:
                    x = inputStream[inputStreamCtr];
                    inputStreamCtr++;
                    f(x);
                    break;
                case 10:
                    cont = false;
                    break;
            }
        } else if (currentInstruction.binop == 1) {
            int b = g();
            int a = g();
            switch (currentInstruction.operation) {
                case 0:
                    f(a + b);
                    break;
                case 1:
                    f(a - b);
                    break;
                case 2:
                    f(a * b);
                    break;
                case 3:
                    f(a / b);
                    break;
                case 4:
                    f(a & b);
                    break;
                case 5:
                    f(a | b);
                    break;
                case 6:
                    f(a ^ b);
                    break;
                case 7:
                    a = (a == b) ? 1 : 0;
                    f(a);
                    break;
                case 8:
                    a = (a < b) ? 1 : 0;
                    f(a);
                    break;
            }
        }
    }

    private void f(int v) {
        sp = sp - 1;
        data[sp] = v;
    }

    private int g() {
        int v = data[sp];
        sp = sp + 1;
        return v;
    }

}
