import java.util.Locale;
import java.util.Scanner;

public class RombergMethod {

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

        if (a == b) {
            System.out.println("\nThe value of the integral equals: 0.0");
            return;
        } else if (a > b) {
            System.out.print("\nAttention! The lower limit of the integral is greater than the upper. That was the idea, right?");
        }

        System.out.printf("\nThe approximate value of the integral equals: %.6f", calculationIntegral(a, b));
    }

    public static double calculationIntegral(double a, double b) {
        double[] values = new double[NUMBER_OF_PARTITIONS];
        double temp = 0.0;

        for (int i = 1; i < NUMBER_OF_PARTITIONS; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) {
                    temp = values[j];
                    values[j] = TrapezoidalMethod.calculationIntegral(a, b);
                } else {
                    values[i] = (Math.pow(4, j - 1) * values[j - 1] - temp) / (Math.pow(4, j - 1) - 1);
                    temp = values[j];
                    values[j] = values[i];
                }
            }
        }

        return values[NUMBER_OF_PARTITIONS - 1];
    }

    private static double function(double x) {
        return (Math.pow(x, 2) + 1.8) / (Math.pow(x, 3) + 7.9);
    }
}
