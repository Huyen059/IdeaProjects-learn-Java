import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int len = scanner.nextInt();
        int[] numbers = new int[len];
        for (int i = 0; i < len; i++) {
            numbers[i] = scanner.nextInt();
        }

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        boolean output = true;

        for (int i = 0; i < len; i++) {
            if (numbers[i] == num1) {
                if (i - 1 >= 0 && numbers[i - 1] == num2) {
                    output = false;
                    break;
                }

                if (i + 1 < len && numbers[i + 1] == num2) {
                    output = false;
                    break;
                }
            }

            if (numbers[i] == num2) {
                if (i - 1 >= 0 && numbers[i - 1] == num1) {
                    output = false;
                }

                if (i + 1 < len && numbers[i + 1] == num1) {
                    output = false;
                }
            }
        }

        System.out.println(output);
    }
}