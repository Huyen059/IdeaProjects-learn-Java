import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        long result = 1L;
        for (int i = start; i < end; i++) {
            result *= i;
        }

        System.out.println(result);
    }
}