import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size1 = scanner.nextInt();
        int size2 = scanner.nextInt();
        int[][] numbers = new int[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                numbers[i][j] = scanner.nextInt();
            }
        }

        int index1 = scanner.nextInt();
        int index2 = scanner.nextInt();
        int[][] numbersSwitch = new int[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                if (j == index1) {
                    numbersSwitch[i][j] = numbers[i][index2];
                } else if (j == index2) {
                    numbersSwitch[i][j] = numbers[i][index1];
                } else {
                    numbersSwitch[i][j] = numbers[i][j];
                }

                System.out.print(numbersSwitch[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
