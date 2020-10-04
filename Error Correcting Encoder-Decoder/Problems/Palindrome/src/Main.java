import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StringBuilder input = new StringBuilder(scanner.next());
            if (input.toString().equals(input.reverse().toString())) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}