import java.time.LocalDateTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDateTime time1 = LocalDateTime.parse(scanner.next());
        LocalDateTime time2 = LocalDateTime.parse(scanner.next());

        LocalDateTime start = time1.isBefore(time2) ? time1 : time2;
        LocalDateTime end = time1.isBefore(time2) ? time2 : time1;

        int num = scanner.nextInt();
        int count = 0;
        for (int i = 0; i < num; i++) {
            LocalDateTime time = LocalDateTime.parse(scanner.next());
            if (time.isBefore(start) || time.isEqual(end) || time.isAfter(end)) {
                continue;
            }
            count++;
        }

        System.out.println(count);
    }
}
