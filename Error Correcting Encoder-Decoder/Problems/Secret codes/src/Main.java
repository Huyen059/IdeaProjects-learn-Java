import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    private static List<String> extractCodes(List<String> codes) {

        return codes.stream()
                .dropWhile(code -> !code.equals("#0000"))
                .takeWhile(code -> !code.equals("#FFFF"))
                .filter(code -> !code.equals("#0000"))
                .collect(Collectors.toList());
    }

    /* Please do not modify the code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> codes = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .collect(Collectors.toList());

        System.out.println(String.join(" ", extractCodes(codes)));
    }
}
