package PizzaSlicerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import PizzaSlicer.PizzaSlicer;

public class PizzaSlicerTestClass {

    @Test
    public void testEnoughSlicesForEveryone() {
        String result = PizzaSlicer.calcSlices(4, 8, 3, 6);
        String expected = """
                          Total number of slices of pizza \t : 32
                          Total number of slices for adults \t : 6
                          Total number of slices for children \t : 26
                          Number of slices per child \t\t : 4
                          Number of slices left over \t\t : 2
                          """;
        assertEquals(expected, result);
    }

    @Test
    public void testNotEnoughSlicesForAdults() {
        String result = PizzaSlicer.calcSlices(2, 8, 5, 3);
        String expected = "You did not purchase enough pizza. Do better.";
        assertEquals(expected, result);
    }

    @Test
    public void testNotEnoughSlicesForChildren() {
        String result = PizzaSlicer.calcSlices(3, 6, 9, 8);
        String expected = "You did not purchase enough pizza. Do better.";
        assertEquals(expected, result);
    }

    @Test
    public void testNotEnoughSlicesPerChild() {
        String result = PizzaSlicer.calcSlices(1, 8, 2, 5);
        String expected = "You did not purchase enough pizza. Do better.";
        assertEquals(expected, result);
    }
}
