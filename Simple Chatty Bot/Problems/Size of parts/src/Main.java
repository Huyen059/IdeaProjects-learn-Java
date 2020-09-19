import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int larger = 0;
        int smaller = 0;
        int perfect = 0;
        for (int i = 0; i < total; i++) {
            int num = scanner.nextInt();
            if (num == -1) {
                smaller++;
            } else if (num == 0) {
                perfect++;
            } else {
                larger++;
            }
        }

        System.out.println(perfect + " " + larger + " " + smaller);
    }
}