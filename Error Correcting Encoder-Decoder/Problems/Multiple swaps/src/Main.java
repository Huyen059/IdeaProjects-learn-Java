import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        int times = scanner.nextInt();
        for (int i = 0; i < times; i++) {
            int pos1 = scanner.nextInt();
            int pos2 = scanner.nextInt();
            Collections.swap(list, pos1, pos2);
        }

        for (String el : list) {
            System.out.print(el + " ");
        }
    }
}
