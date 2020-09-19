import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        boolean output = true;
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        if (num2 != 0) {
            if (num2 == num1) {
                num2 = scanner.nextInt();
            }
            boolean ascending = true;
            if (num2 < num1) {
                ascending = false;
            }
            int current = num2;
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num == 0) {
                    break;
                }

                if (ascending && num < current || !ascending && num > current) {
                    output = false;
                    break;
                }

                current = num;

//                if (ascending) {
//                    if (num < current) {
//                        output = false;
//                        break;
//                    }
//                    current = num;
//                }
//
//                if (!ascending) {
//                    if (num > current) {
//                        output = false;
//                        break;
//                    }
//                    current = num;
//                }
            }
        }
        System.out.println(output);
    }
}