import java.time.LocalTime;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        LocalTime arrive = LocalTime.of(20, 0);
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < num; i++) {
            String store = scanner.next();
            LocalTime close = LocalTime.parse(scanner.next());
            if (arrive.isBefore(close)) {
                output.append(store + "\n");
            }
        }
        System.out.println(output);
    }
}
