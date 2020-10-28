import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input1 = scanner.next();
        String input2 = scanner.next();
        int time1 = LocalTime.parse(input1).toSecondOfDay();
        int time2 = LocalTime.parse(input2).toSecondOfDay();
        System.out.println(Math.abs(time2 - time1));
    }
}
