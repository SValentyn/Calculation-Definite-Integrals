import java.util.Locale;
import java.util.Scanner;

public class SimpsonMethod {

    public final static int NUMBER_OF_PARTITIONS = 100;

    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);

        Scanner scanner = new Scanner(System.in);
        double a, b;

        System.out.println("Find an approximate solution to the integral. Integrand: (x^2 + 1.8) / (x^3 +7.9)");

        System.out.print("Enter the lower limit of integration a = ");
        a = scanner.nextDouble();

        System.out.print("Enter the upper limit of integration b = ");
        b = scanner.nextDouble();

        if (a == b) {
            System.out.println("\nThe approximate value of the integral equals: 0.0");
            return;
        } else if (a > b) {
            System.out.print("\nAttention! The lower limit of the integral is greater than the upper. That was the idea, right?");
        }

        System.out.printf("\nThe approximate value of the integral equals: %.6f", calculationIntegral(a, b));
    }

    private static double calculationIntegral(double a, double b) {
        double h = (b - a) / NUMBER_OF_PARTITIONS; // step size
        double k1 = 0, k2 = 0;

        for (int i = 1; i < NUMBER_OF_PARTITIONS; i += 2) {
            k1 += function(a + i * h);
            k2 += function(a + (i + 1) * h);
        }

        return (h / 3) * (function(a) + 4 * k1 + 2 * k2);
    }

    private static double function(double x) {
        return (Math.pow(x, 2) + 1.8) / (Math.pow(x, 3) + 7.9);
    }
}
