
import java.math.BigInteger;
import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        BigInteger m = scanner.nextBigInteger();
        long n = 0;
        while (calcFactorial(n).compareTo(m) < 0) {
            n++;
        }
        System.out.println(n - 1);
    }

    public static BigInteger calcFactorial(long n) {
        // type your java code here
        BigInteger[] factorials = new BigInteger[(int) n];

        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        if (n == 2) {
            return BigInteger.valueOf(2);
        }
        factorials[0] = BigInteger.ONE;
        factorials[1] = BigInteger.ONE;
        factorials[2] = BigInteger.valueOf(2);
        for (int i = 3; i < n; i++) {
            factorials[i] = BigInteger.valueOf(i).multiply(factorials[i - 1]);
        }
        return factorials[(int) n - 1];
    }
}
