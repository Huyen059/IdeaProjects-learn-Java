import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        LocalDate firstDate = LocalDate.of(year, month, 1);
        LocalDate lastDate = firstDate.plusMonths(1).minusDays(1);
        System.out.print(firstDate + " " + lastDate);
    }
}
