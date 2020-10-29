import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();

        List<Integer[]> table = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            Integer[] list = new Integer[col];
            for (int j = 0; j < col; j++) {
                list[j] = scanner.nextInt();
            }
            table.add(i, list);
        }

        int step = scanner.nextInt();

        Collections.rotate(table, step);

        for (Integer[] li : table) {
            for (Integer num : li) {
                System.out.print(num + " ");
            }
            System.out.println("");
        }
    }
}
