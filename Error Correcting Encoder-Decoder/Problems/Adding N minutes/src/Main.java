import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int toAdd = scanner.nextInt();

        LocalDateTime time = LocalDateTime.parse(input);
        LocalDateTime output = time.plusMinutes(toAdd);
        System.out.print(output.getYear() + " ");
        System.out.print(output.getDayOfYear() + " ");
        LocalTime t = LocalTime.of(output.getHour(), output.getMinute(), output.getSecond());
        System.out.print(t);
    }
}
