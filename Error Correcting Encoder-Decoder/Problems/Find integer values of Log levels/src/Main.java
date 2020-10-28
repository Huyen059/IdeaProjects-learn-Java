import java.util.Scanner;
import java.util.logging.*;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String[] levels = scanner.nextLine().split("\\s+");
            int result = 0;
            for (String level : levels) {
                switch (level.toUpperCase()) {
                    case "SEVERE":
                        result += Level.SEVERE.intValue();
                        break;
                    case "WARNING":
                        result += Level.WARNING.intValue();
                        break;
                    case "INFO":
                        result += Level.INFO.intValue();
                        break;
                    case "CONFIG":
                        result += Level.CONFIG.intValue();
                        break;
                    case "FINE":
                        result += Level.FINE.intValue();
                        break;
                    case "FINER":
                        result += Level.FINER.intValue();
                        break;
                    case "FINEST":
                        result += Level.FINEST.intValue();
                        break;
                    default:
                        break;
                }
            }
            System.out.println(result);
        }
    }
}