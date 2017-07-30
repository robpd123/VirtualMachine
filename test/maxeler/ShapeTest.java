/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxeler;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author robpd
 */
public class ShapeTest {

    public ShapeTest() {
    }

    @Test
    public void testSomeMethod() {
        InputBuilder ib = new InputBuilder();
        String output;

        ArrayList<Shape> shapes = new ArrayList<Shape>();
        shapes.add(new Shape("A1", 0, 0, 10));
        shapes.add(new Shape("A2", 400, 0, 10));
        shapes.add(new Shape("B1", 120, 160, 30));
        shapes.add(new Shape("B1", 30, 195, 10));

        int[] shapeOrder = {0, 1, 2, 3};

        output = ib.createInput(shapes, shapeOrder);

        System.out.println(output);
    }

}
