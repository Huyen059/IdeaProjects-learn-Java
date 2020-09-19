import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int len = scanner.nextInt();
        for (int i = 0; i < len; i++) {
            sum += scanner.nextInt();
        }
        System.out.println(sum);
    }
}