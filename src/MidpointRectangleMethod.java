import java.util.Locale;
import java.util.Scanner;

public class MidpointRectangleMethod {

    public final static int NUMBER_OF_PARTITIONS = 100;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Scanner scanner = new Scanner(System.in);
        double a, b;

        System.out.println("Find an approximate solution to the integral. Integrand: (x^2 + 1.8) / (x^3 + 7.9)");

        System.out.print("Enter the lower limit of integration a = ");
        a = scanner.nextDouble();

        System.out.print("Enter the upper limit of integration b = ");
        b = scanner.nextDouble();

        System.out.printf("\nThe approximate value of the integral equals: %.6f", calculationIntegral(a, b));
    }

    /**
     * The approximate value of the integral is equal to the sum of the areas of the rectangles.
     */
    private static double calculationIntegral(double a, double b) {
        double h = (b - a) / NUMBER_OF_PARTITIONS; // step size
        double sum = 0.0;                          // area

        for (int i = 0; i < NUMBER_OF_PARTITIONS; i++) {
            sum += function(a + (i + 0.5) * h);
        }

        return (sum * h);
    }

    private static double function(double x) {
        return (Math.pow(x, 2) + 1.8) / (Math.pow(x, 3) + 7.9);
    }
}
