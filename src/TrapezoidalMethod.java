import java.util.Locale;
import java.util.Scanner;

public class TrapezoidalMethod {

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

        System.out.printf("\nThe approximate value of the integral equals: %.6f", calculationIntegral(a, b));
    }

    private static double calculationIntegral(double a, double b) {
        double h = (b - a) / NUMBER_OF_PARTITIONS; // step size
        double sum = function(a) + function(b);    // area

        for (int i = 1; i < NUMBER_OF_PARTITIONS; i++) {
            sum += 2 * (function(a + h * i));
        }

        return ((b - a) / (2 * NUMBER_OF_PARTITIONS)) * sum;
    }

    private static double function(double x) {
        return (Math.pow(x, 2) + 1.8) / (Math.pow(x, 3) + 7.9);
    }
}
