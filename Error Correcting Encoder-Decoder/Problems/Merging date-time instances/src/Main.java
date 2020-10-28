import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public static LocalDateTime merge(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        int year = Math.max(dateTime1.getYear(), dateTime2.getYear());
        int month = Math.max(dateTime1.getMonth().getValue(), dateTime2.getMonth().getValue());
        int day = Math.max(dateTime1.getDayOfMonth(), dateTime2.getDayOfMonth());
        int hour = Math.max(dateTime1.getHour(), dateTime2.getHour());
        int min = Math.max(dateTime1.getMinute(), dateTime2.getMinute());
        int sec = Math.max(dateTime1.getSecond(), dateTime2.getSecond());

        return LocalDateTime.of(year, month, day, hour, min, sec);
    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final LocalDateTime firstDateTime = LocalDateTime.parse(scanner.nextLine());
        final LocalDateTime secondDateTime = LocalDateTime.parse(scanner.nextLine());
        System.out.println(merge(firstDateTime, secondDateTime));
    }
}
