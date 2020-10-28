import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int hour = scanner.nextInt();
        int min = scanner.nextInt();
        LocalDateTime time = LocalDateTime.parse(input);
        LocalDateTime output = time.minusHours(hour).plusMinutes(min);
        System.out.println(output);
    }
}
