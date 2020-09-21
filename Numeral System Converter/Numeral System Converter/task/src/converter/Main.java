package converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Stage 2
//        int input = scanner.nextInt();
//        int radix = scanner.nextInt();
//        String output = Integer.toOctalString(input);
//        System.out.println(output.charAt(output.length() - 1));

//        Stage 3
//        int input = scanner.nextInt();
//        int radix = scanner.nextInt();
//        String prefix = "";
//        switch (radix) {
//            case 2:
//                prefix = "0b";
//                break;
//            case 8:
//                prefix = "0";
//                break;
//            case 16:
//                prefix = "0x";
//                break;
//        }
//        System.out.println(prefix + Long.toString(input, radix));

//        Stage 4
        int sourceRadix = scanner.nextInt();
        int sourceNumber = scanner.nextInt();
        int targetRadix = scanner.nextInt();
        int outputInDecimal;
        String output;

        if (sourceRadix == 1) {
            outputInDecimal = String.valueOf(sourceNumber).length();
        } else {
            outputInDecimal = Integer.parseInt(String.valueOf(sourceNumber), sourceRadix);
        }

        if (targetRadix == 1) {
            output = "1".repeat(Math.max(0, outputInDecimal));
        } else {
            output = Integer.toString(outputInDecimal, targetRadix);
        }

        System.out.println(output);
    }
}
