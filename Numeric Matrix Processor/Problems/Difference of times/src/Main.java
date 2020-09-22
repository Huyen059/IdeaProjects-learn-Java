import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int start = 0;
        int end = 0;
        for (int i = 0; i < 3; i++) {
            start += scanner.nextInt() * Math.pow(60, 2-i);
        }
        for (int i = 0; i < 3; i++) {
            end += scanner.nextInt() * Math.pow(60, 2-i);
        }

        System.out.println(end - start);
    }
}