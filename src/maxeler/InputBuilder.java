/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxeler;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 *
 * @author robpd
 */
public class InputBuilder {

    private String A1 = "RULURULU";
    private String A2 = "LURULURU";
    private String A3 = "DRDLDRDL";

    private String B1 = "DRURDRUR";
    private String B2 = "DLULDLUL";
    private String B3 = "LDLULDLU";

    private String C1 = "URDRURDR";
    private String C2 = "ULDLULDL";

    private String D1 = "RURDRURD";
    private String D2 = "LULDLULD";

    private String E1 = "RDRURDRU";

    private String ROffset = "R";
    private String LOffset = "L";
    private String UOffset = "U";
    private String DOffset = "D";

    private int currentX = 0;
    private int currentY = 0;

    private int currentSizeX = 10;
    private int currentSizeY = 10;

    public InputBuilder() {

    }
    
    //Takes array of shapes and an order to process and outputs string of form "LLLUU...X"
    public String createInput(ArrayList<Shape> shapes, int[] shapeOrder) {

        StringBuilder input = new StringBuilder();

        ArrayList<String> inputs = new ArrayList<String>();

        for (int i = 0; i < shapeOrder.length; i++) {
            //Offset
            String offsetString = drawOffset(shapes.get(shapeOrder[i]));

            //Resize
            String resizeString = "";
            if (shapes.get(shapeOrder[i]).getSize() != currentX) {
                resizeString = drawSize(shapes.get(shapeOrder[i]));
            }

            //Draw
            String shapeString = drawShape(shapes.get(shapeOrder[i]));

            input.append(offsetString);
            input.append(resizeString);
            input.append(shapeString);
        }

        input.append("X");
        return input.toString();
    }
    
    //Creates String to recentre drawer
    private String drawOffset(Shape shape) {
        if (currentX == shape.getDesiredX() && currentY == shape.getDesiredY()) {
            return "";
        }

        StringBuilder offset = new StringBuilder();

        //set drawing length to 10 - could be optimised
        offset.append(drawSize(new Shape("A1", 0, 0, 10)));
        
        offset.append("P");
        
        while (currentX != shape.getDesiredX()) {
            if (Math.abs(currentX - shape.getDesiredX()) < currentSizeX) {
                //Offset is only ever 5 or 10
                offset.append("JJJJJ");
                currentSizeX = 5;
            }

            if (currentX < shape.getDesiredX()) {
                offset.append("R");
                currentX += currentSizeX;
            } else {
                offset.append("L");
                currentX -= currentSizeX;
            }
        }
        while (currentY != shape.getDesiredY()) {
            if (Math.abs(currentY - shape.getDesiredY()) < currentSizeY) {
                //Offset is only ever 5 or 10
                offset.append("MMMMM");
                currentSizeY = 5;
            }

            if (currentY < shape.getDesiredY()) {
                offset.append("U");
                currentY += currentSizeY;
            } else {
                offset.append("D");
                currentY -= currentSizeY;
            }
        }
        
        //Reset current size to 10
        if (currentSizeX == 5) {
            offset.append("KKKKK");
            currentSizeX = 10;
        }

        if (currentSizeY == 5) {
            offset.append("NNNNN");
            currentSizeY = 10;
        }

        offset.append("P");
        return offset.toString();
    }
    
    //Creates String to set drawing size to required size
    private String drawSize(Shape shape) {
        StringBuilder sb = new StringBuilder();

        while (currentSizeX != shape.getSize()) {
            if (currentSizeX < shape.getSize()) {
                sb.append("K");
                currentSizeX++;
            } else {
                sb.append("J");
                currentSizeX--;
            }
        }

        while (currentSizeY != shape.getSize()) {
            if (currentSizeY < shape.getSize()) {
                sb.append("N");
                currentSizeY++;
            } else {
                sb.append("M");
                currentSizeY--;
            }
        }

        return sb.toString();

    }

    //Creates String to draw a shape of desired size
    private String drawShape(Shape shape) {
        switch (shape.getType()) {
            case ("A1"):
                currentX += currentSizeX * 0;
                currentY += currentSizeY * 4;
                return A1;
            case ("A2"):
                currentX += currentSizeX * 0;
                currentY += currentSizeY * 4;
                return A2;
            case ("A3"):
                currentX += currentSizeX * 0;
                currentY -= currentSizeY * 4;
                return A3;
            case ("B1"):
                currentX += currentSizeX * 4;
                currentY += currentSizeY * 0;
                return B1;
            case ("B2"):
                currentX -= currentSizeX * 4;
                currentY -= currentSizeY * 0;
                return B2;
            case ("B3"):
                currentX -= currentSizeX * 4;
                currentY -= currentSizeY * 0;
                return B3;
            case ("C1"):
                currentX += currentSizeX * 4;
                currentY += currentSizeY * 0;
                return C1;
            case ("C2"):
                currentX -= currentSizeX * 4;
                currentY -= currentSizeY * 0;
                return C2;
            case ("D1"):
                currentX += currentSizeX * 4;
                currentY -= currentSizeY * 0;
                return D1;
            case ("D2"):
                currentX -= currentSizeX * 4;
                currentY -= currentSizeY * 0;
                return D2;
            case ("E1"):
                currentX += currentSizeX * 4;
                currentY += currentSizeX * 0;
                return E1;

        }
        return "";
    }

}
