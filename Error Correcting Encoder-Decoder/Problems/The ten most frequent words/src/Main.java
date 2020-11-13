import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        var list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(word -> word.replaceAll("[^0-9a-zA-Z_\\s]", ""))
                .map(String::toLowerCase)
                .collect(Collectors.toList());

        var map = list.stream()
                .collect(Collectors.groupingBy(word -> Collections.frequency(list, word)));

        var sortMap = new TreeMap<>(map);
        sortMap.descendingMap().values().stream()
                .flatMap(word -> word.stream().distinct().sorted())
                .limit(10)
                .forEach(System.out::println);
    }
}
