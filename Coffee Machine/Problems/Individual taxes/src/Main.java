import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] incomes = new int[size];
        for (int i = 0; i < size; i++) {
            incomes[i] = scanner.nextInt();
        }

        int[] taxRates = new int[size];
        for (int i = 0; i < size; i++) {
            taxRates[i] = scanner.nextInt();
        }

        double[] taxes = new double[size];
        double max = 0;
        int company = 0;
        for (int i = 0; i < size; i++) {
            taxes[i] = (double) incomes[i] * taxRates[i] / 100;
            if (taxes[i] > max) {
                max = taxes[i];
                company = i + 1;
            }
        }

        System.out.println(company);
    }
}