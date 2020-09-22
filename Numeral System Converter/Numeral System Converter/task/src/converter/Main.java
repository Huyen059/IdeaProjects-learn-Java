package converter;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static final int MAX_FRACTION = 5;

    public static String convertNumber(int sourceRadix, String sourceNumber, int targetRadix) {
        if (sourceRadix < 1 || targetRadix < 1 || sourceRadix > 36 || targetRadix > 36) {
            return "error";
        }
        String[] splitSourceNumber = sourceNumber.split("\\.");
        if (splitSourceNumber.length == 1) {
            return convertInteger(sourceRadix, sourceNumber, targetRadix);
        }
        return convertInteger(sourceRadix, splitSourceNumber[0], targetRadix)
                + "."
                + convertFraction(sourceRadix, splitSourceNumber[1], targetRadix);
    }

    public static String convertInteger(int sourceRadix, String sourceNumber, int targetRadix) {
        int outputInDecimal;
        String output;

        if (sourceRadix == 1) {
            outputInDecimal = sourceNumber.length();
        } else {
            outputInDecimal = Integer.parseInt(sourceNumber, sourceRadix);
        }

        if (targetRadix == 1) {
            output = "1".repeat(outputInDecimal);
        } else {
            output = Integer.toString(outputInDecimal, targetRadix);
        }
        return output;
    }

    public static String convertFraction(int sourceRadix, String sourceFraction, int targetRadix) {
//        int length = sourceFraction.toCharArray().length;
//        if (length <= MAX_FRACTION) {
//            sourceFraction += "0".repeat(MAX_FRACTION - length);
//        } else {
//            StringBuilder cutString = new StringBuilder();
//            for (int i = 0; i < MAX_FRACTION; i++) {
//                cutString.append(sourceFraction.charAt(i));
//            }
//            sourceFraction = cutString.toString();
//        }

        double fractionInDecimal = 0;
        if (sourceRadix == 10) {
            String fraction = "0." + sourceFraction;
            fractionInDecimal = Double.parseDouble(fraction);
        } else {
            for (int i = 0; i < Math.min(5, sourceFraction.length()); i++) {
//                String character = String.valueOf(sourceFraction.charAt(i));
//                double num = Integer.parseInt(character, sourceRadix);
                double num = Character.getNumericValue(sourceFraction.charAt(i));
                fractionInDecimal += num / Math.pow(sourceRadix, i + 1);
            }
        }

        StringBuilder output = new StringBuilder();
        int length = String.valueOf(fractionInDecimal).length() - 2;
        double remainder = fractionInDecimal;
        for (int i = 0; i < 5; i++) {
            double resultInDouble = remainder * targetRadix;
            int value = (int) resultInDouble;
            String valueInString = Integer.toString(value, targetRadix);
            output.append(valueInString);
            remainder = resultInDouble % value;
        }

        return String.valueOf(output);
    }

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
//        int sourceRadix = scanner.nextInt();
//        int sourceNumber = scanner.nextInt();
//        int targetRadix = scanner.nextInt();
//        int outputInDecimal;
//        String output;
//
//        if (sourceRadix == 1) {
//            outputInDecimal = String.valueOf(sourceNumber).length();
//        } else {
//            outputInDecimal = Integer.parseInt(String.valueOf(sourceNumber), sourceRadix);
//        }
//
//        if (targetRadix == 1) {
//            output = "1".repeat(outputInDecimal);
//        } else {
//            output = Integer.toString(outputInDecimal, targetRadix);
//        }
//
//        System.out.println(output);

//        Stage 5
        try {
            int sourceRadix = scanner.nextInt();
            String sourceNumber = scanner.next();
            int targetRadix = scanner.nextInt();

            System.out.println(convertNumber(sourceRadix, sourceNumber, targetRadix));
        } catch (Exception e) {
            System.out.println("error");
        }


    }
}
