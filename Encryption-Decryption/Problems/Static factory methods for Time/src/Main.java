import java.util.Scanner;

class Time {

    int hour;
    int minute;
    int second;

    public static Time noon() {
        return Time.of(12, 0, 0);
    }

    public static Time midnight() {
        return Time.of(0, 0, 0);
    }

    public static Time ofSeconds(long seconds) {
            long secondsExcludeDays = seconds % (3600 * 24);
            int hour = (int) secondsExcludeDays / 3600;
            long secondsExcludeHour = secondsExcludeDays % 3600;
            int minute = (int) secondsExcludeHour / 60;
            int second = (int) secondsExcludeHour % 60;

            return Time.of(hour, minute, second);
    }

    public static Time of(int hour, int minute, int second) {
        // write your code here
        if ((hour < 0 || hour > 23) || (minute < 0 || minute > 59) || (second < 0 || second > 59)) {
            return null;
        }

        Time time = new Time();
        time.hour = hour;
        time.minute = minute;
        time.second = second;
        return time;
    }
}

/* Do not change code below */
public class Main {

    public static void main(String[] args) {
        Time test = Time.ofSeconds(500000);

        final Scanner scanner = new Scanner(System.in);

        final String type = scanner.next();
        Time time = null;

        switch (type) {
            case "noon":
                time = Time.noon();
                break;
            case "midnight":
                time = Time.midnight();
                break;
            case "hms":
                int h = scanner.nextInt();
                int m = scanner.nextInt();
                int s = scanner.nextInt();
                time = Time.of(h, m, s);
                break;
            case "seconds":
                time = Time.ofSeconds(scanner.nextInt());
                break;
            default:
                time = null;
                break;
        }

        if (time == null) {
            System.out.println(time);
        } else {
            System.out.println(String.format("%s %s %s", time.hour, time.minute, time.second));
        }
    }
}