import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner scanner = new Scanner(System.in)) {
            int numberOfWordsInDictionary = Integer.parseInt(scanner.nextLine());
            Set<String> dictionary = new HashSet<>();
            for (int i = 0; i < numberOfWordsInDictionary; i++) {
                dictionary.add(scanner.nextLine().trim().toLowerCase());
            }
            Set<String> input = new HashSet<>();
            int numberOfInputLines = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < numberOfInputLines; i++) {
                input.addAll(
                        Arrays.stream(scanner.nextLine().split("\\s+"))
                                .collect(Collectors.toList())
                );
            }

            for (String word : input) {
                if (!dictionary.contains(word.toLowerCase())) {
                    System.out.println(word);
                }
            }
        }
    }
}