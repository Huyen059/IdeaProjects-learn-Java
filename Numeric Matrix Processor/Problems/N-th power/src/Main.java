import java.util.Scanner;

public class Main {

    public static double pow(double a, long n) {
        double result = 0;
        if (n == 0) {
            return 1;
        }

        if (n == 1) {
            return a;
        }

        if (n == 2) {
            return a * a;
        }

        double square = a * a;
        if (n % 2 == 0) {
            result = pow(square, n / 2);
        } else {
            result = a * pow(a, n - 1);
        }

        return result;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final double a = Double.parseDouble(scanner.nextLine());
        final int n = Integer.parseInt(scanner.nextLine());
        System.out.println(pow(a, n));
    }
}