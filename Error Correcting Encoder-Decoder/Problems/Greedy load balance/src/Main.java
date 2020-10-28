import java.util.*;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfTask = Integer.parseInt(scanner.nextLine());
            Queue<Integer> firstQueue = new ArrayDeque<>();
            Queue<Integer> secondQueue = new ArrayDeque<>();
            int firstQueueLoad = 0;
            int secondQueueLoad = 0;

            for (int i = 0; i < numberOfTask; i++) {
                List<Integer> task = Arrays.stream(scanner.nextLine().trim().split("\\s+"))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());
                if (firstQueueLoad <= secondQueueLoad) {
                    firstQueue.offer(task.get(0));
                    firstQueueLoad += task.get(1);
                } else {
                    secondQueue.offer(task.get(0));
                    secondQueueLoad += task.get(1);
                }
            }

            firstQueue.forEach(num -> System.out.print(num + " "));
            System.out.print("\n");
            secondQueue.forEach(num -> System.out.print(num + " "));
        }
    }
}