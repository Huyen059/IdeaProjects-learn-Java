import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 != 0) {
                    result.add(list.get(i));
                }
            }
            Collections.reverse(result);
            result.forEach(el -> System.out.print(el + " "));
        }
    }
}