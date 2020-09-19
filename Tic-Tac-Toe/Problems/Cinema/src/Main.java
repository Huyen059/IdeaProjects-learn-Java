import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size1 = scanner.nextInt();
        int size2 = scanner.nextInt();

        int[][] seats = new int[size1][size2];
        for (int i = 0; i < size1; i++) {
            for (int j = 0; j < size2; j++) {
                seats[i][j] = scanner.nextInt();
            }
        }

        int wantToBuySeats = scanner.nextInt();
        int rowAvailable = 0;

        for (int i = 0; i < size1; i++) {
            if (rowAvailable != 0) {
                break;
            }

            for (int j = 0; j < size2; j++) {

                if (seats[i][j] == 1) {
                    continue;
                }

                boolean isSatisfied = true;
                // check if the rest of the row has more seats than the required
                if (j + wantToBuySeats > size2) {
                    isSatisfied = false;
                    break;
                }
                // loop over the number of required seats, starting from the current position
                for (int k = j; k < j + wantToBuySeats; k++) {
                    if (seats[i][k] == 1) {
                        isSatisfied = false;
                        break;
                    }
                }

                if (isSatisfied) {
                    rowAvailable = i + 1;
                    break;
                }
            }
        }

        System.out.println(rowAvailable);
    }
}