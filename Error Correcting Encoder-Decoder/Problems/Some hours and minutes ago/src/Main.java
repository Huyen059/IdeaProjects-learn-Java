import java.time.LocalTime;
import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int mH = scanner.nextInt();
        int mM = scanner.nextInt();
        LocalTime time = LocalTime.parse(input);
        LocalTime output = time.minusHours(mH).minusMinutes(mM);
        System.out.println(output);
    }
}
