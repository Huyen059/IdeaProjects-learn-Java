import java.util.Scanner;

public class Main {

    public static long fib(long n) {
        if (n <= 1) {
            return n;
        }

        long[] sequence = new long[(int) n + 1];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i <= n; i++) {
            sequence[i] = (long) Math.pow(-1, i - 1) * (Math.abs(sequence[i - 1]) + Math.abs(sequence[i - 2]));
        }
        return sequence[(int) n];
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fib(n));
    }
}