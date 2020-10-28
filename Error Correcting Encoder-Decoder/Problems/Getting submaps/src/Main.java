import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(System.in)) {
            int from = scanner.nextInt();
            int to = Integer.parseInt(scanner.nextLine().trim());
            int total = Integer.parseInt(scanner.nextLine().trim());
            TreeMap<Integer, String> map = new TreeMap<>();
            for (int i = 0; i < total; i++) {
                map.put(scanner.nextInt(), scanner.nextLine().trim());
            }

            Map<Integer, String> subMap = map.subMap(from, to + 1);
            subMap.forEach((key, value) -> System.out.println(key + " " + value));
        }
    }
}