import java.time.LocalDate;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LocalDate current = LocalDate.parse(scanner.next());
        int gap = scanner.nextInt();
        LocalDate newYear = current.plusYears(1).withDayOfYear(1);
        LocalDate addedDate = current.plusDays(gap);
        if (addedDate.isBefore(newYear)) {
            System.out.println(false);
        } else {
            System.out.println(true);
        }
    }
}
