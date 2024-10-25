package src.main.java.PizzaSlicer;
import java.util.Scanner;

public class PizzaSlicer {

    public static String calcSlices(int pizzas, int slicesPer, int adults, int children) {
        int slices = pizzas * slicesPer;
        int adultSlices = adults * 2;

        if (adultSlices > slicesPer) { return notEnoughSlices(); };

        int childSlices = slices - adultSlices;
        if (childSlices < children) { return notEnoughSlices(); };

        int slicePerChild = childSlices / children;
        if (slicePerChild < 1) { return notEnoughSlices(); };

        int leftover = childSlices - slicePerChild * children;
        leftover = (leftover < 0) ? 0 : leftover;

        return String.format("" +
                "Total number of slices of pizza \t : %d%n" +
                "Total number of slices for adults \t : %d%n" +
                "Total number of slices for children \t : %d%n" +
                "Number of slices per child \t\t : %d%n" +
                "Number of slices left over \t\t : %d%n",
                slices,
                adultSlices,
                childSlices,
                slicePerChild,
                leftover
                );
    }

    private static String notEnoughSlices() {
        return "You did not purchase enough pizza. Do better.";
    }

    public static void main(String[] args) {
        
        var con = System.console();
        
        if (con != null) {
            try (Scanner in = new Scanner(con.reader())) {
                System.out.println("Enter the number of pizzas purchased: ");
                int pizzas = in.nextInt();
                
                System.out.println("Enter number of slices per pizza: ");
                int slicesPer = in.nextInt();
                
                
                System.out.println("Enter number of adults: ");
                int adults = in.nextInt();
                
                
                
                System.out.println("Enter number of children: ");
                int children = in.nextInt();
                
                String result = calcSlices(pizzas, slicesPer, adults, children);
                System.out.println(result);
            }
        }
    }
}
