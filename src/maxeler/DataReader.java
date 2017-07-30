/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxeler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author robpd
 */
//
public class DataReader {

    public static int[] readFile(String fileLocation, int[] data) {
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileLocation));

            String dataSizeStr = in.readLine();
            int dataSize = Decoder.convertHexToInt(dataSizeStr);
            int imageSize = Decoder.convertHexToInt(in.readLine());

            data = new int[dataSize];

            for (int i = 0; i < imageSize; i++) {
                data[i] = (Decoder.convertHexToInt(in.readLine()));
            }
            
        } catch (IOException ex) {
            System.out.println("Read file not found");
        }
        return data;
    }

//    public static int readByte(Scanner reader) throws IOException {
//        byte input = reader.nextByte();
//        return input & 0xFF;
//    }

}
