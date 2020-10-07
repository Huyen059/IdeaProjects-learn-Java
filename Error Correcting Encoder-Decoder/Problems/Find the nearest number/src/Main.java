import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // write your code here
        try (Scanner scanner = new Scanner(System.in)) {
            List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            int target = scanner.nextInt();
            Integer diff = Integer.MAX_VALUE;
            for (Integer num : list) {
                if (Math.abs(num - target) < diff) {
                    diff = Math.abs(num - target);
                }
            }
            List<Integer> result = new ArrayList<>();
            for (Integer num : list) {
                if (Math.abs((num - target)) == diff) {
                    result.add(num);
                }
            }

            Collections.sort(result);
            for (Integer num : result) {
                System.out.print(num + " ");
            }
        }

    }
}