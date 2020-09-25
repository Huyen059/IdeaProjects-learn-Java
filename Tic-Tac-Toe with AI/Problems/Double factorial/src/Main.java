import java.math.BigInteger;


class DoubleFactorial {
    public static BigInteger calcDoubleFactorial(int n) {
        // type your java code here
        if (n == 0 || n == 1) {
            return BigInteger.ONE;
        }

        if (n == 2) {
            return BigInteger.valueOf(2);
        }

        return BigInteger.valueOf(n).multiply(calcDoubleFactorial(n - 2));
    }

}