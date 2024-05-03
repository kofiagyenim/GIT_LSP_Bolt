package org.howard.edu.lsp.oopfinal.question3;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ShapeFactoryTest {
    @Test
    public void testCreateCircle() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("CIRCLE");
        assertTrue(shape instanceof Circle);
        shape.draw(); // To visually confirm the output (not typically done in unit tests)
    }

    @Test
    public void testCreateRectangle() {
        ShapeFactory factory = new ShapeFactory();
        Shape shape = factory.getShape("RECTANGLE");
        assertTrue(shape instanceof Rectangle);
        shape.draw(); // To visually confirm the output (not typically done in unit tests)
    }
}
