import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int day = scanner.nextInt();
        LocalDate inputDate = LocalDate.ofYearDay(year, day);
        LocalDate nextDate = inputDate.plusDays(1);
        if (nextDate.getMonth() == inputDate.getMonth()) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }
}
