import java.util.Scanner;

public class Main {

    public static int convert(Long val) {
        // write your code here
        if (val == null) {
            return 0;
        }

        if (val.compareTo((long) Integer.MAX_VALUE) > 0) {
            return Integer.MAX_VALUE;
        }

        if (val.compareTo((long) Integer.MIN_VALUE) < 0) {
            return Integer.MIN_VALUE;
        }

        return val.intValue();
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.nextLine();
        Long longVal = "null".equals(val) ? null : Long.parseLong(val);
        System.out.println(convert(longVal));
    }
}