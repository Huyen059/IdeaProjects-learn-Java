import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean result = true;
            ArrayDeque<String> stack = Arrays.stream(scanner.nextLine().trim().split("")).collect(Collectors.toCollection(ArrayDeque::new));
            ArrayDeque<String> tmp = new ArrayDeque<>();
            String current = stack.poll();
            while (current != null) {
                if (current.equals("(") || current.equals("{") || current.equals("[")) {
                    tmp.addLast(current);
                } else {
                    String open = tmp.pollLast();
                    if (open == null) {
                        result = false;
                        break;
                    }

                    if (current.equals(")") && !"(".equals(open)
                            || current.equals("}") && !"{".equals(open)
                            || current.equals("]") && !"[".equals(open)) {
                        result = false;
                        break;
                    }
                }
                current = stack.poll();
            }

            if (tmp.size() > 0) {
                result = false;
            }

            System.out.println(result);
        }
    }
}