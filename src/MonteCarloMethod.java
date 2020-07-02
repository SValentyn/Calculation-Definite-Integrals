import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class MonteCarloMethod {

    public final static int NUMBER_OF_POINTS = 100_000;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Scanner scanner = new Scanner(System.in);
        double a, b;

        System.out.println("Find an approximate solution to the integral. Integrand: (x^2 + 1.8) / (x^3 + 7.9)");

        System.out.print("Enter the lower limit of integration a = ");
        a = scanner.nextDouble();

        System.out.print("Enter the upper limit of integration b = ");
        b = scanner.nextDouble();

        if (a == b) {
            System.out.println("\nThe value of the integral equals: 0.0");
            return;
        } else if (a > b) {
            System.out.print("\nAttention! The lower limit of the integral is greater than the upper. That was the idea, right?");
        }

        System.out.printf("\nThe approximate value of the integral using average values: %.6f", calculationIntegralUsingAverageValues(a, b));
        System.out.printf("\nThe approximate value of the integral using random points: %.6f", calculationIntegralUsingRandomPoints(a, b));
    }

    /**
     * Calculation of average values of a function at random locations
     */
    public static double calculationIntegralUsingAverageValues(double a, double b) {
        double sum = 0.0;
        double x;

        // Calculation of average values of a function at random locations within the interval
        for (int i = 0; i < NUMBER_OF_POINTS; i++) {
            x = Math.random() * (b - a) + a;
            sum += function(x);
        }

        // Multiply average values of function by interval's width
        return (b - a) * sum / NUMBER_OF_POINTS;
    }

    /**
     * Calculation of the integral by generating random points
     */
    public static double calculationIntegralUsingRandomPoints(double a, double b) {
        Random random = new Random();

        double max; // maximum function value
        double min; // minimum function value

        if (function(a) >= function(b)) {
            max = function(a);
            min = function(b);
        } else {
            max = function(b);
            min = function(a);
        }

        double[] x = new double[NUMBER_OF_POINTS];
        double[] y = new double[NUMBER_OF_POINTS];

        int count = 0; // the number of points in the region of the bounded curve

        // Random point generation
        for (int i = 0; i < NUMBER_OF_POINTS; i++) {
            x[i] = a + (b - a) * random.nextDouble();
            y[i] = min + (max - min) * random.nextDouble();

            // Count increases by 1 if the generated number falls within the area bounded by the curve
            if (y[i] < function(x[i])) {
                count++;
            }
        }

        System.out.println("\nNumber of points in the integral area: " + count);
        return count * (b - a) * ((max - min) / NUMBER_OF_POINTS);
    }

    private static double function(double x) {
        return (Math.pow(x, 2) + 1.8) / (Math.pow(x, 3) + 7.9);
    }
}
