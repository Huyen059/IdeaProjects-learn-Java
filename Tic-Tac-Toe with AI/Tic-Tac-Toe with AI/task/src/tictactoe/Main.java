package tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int DIMENSION = 3;
    public static final int TOTAL_LENGTH_OF_FIELD = 9;
    static Scanner scanner = new Scanner(System.in);
    static GameState state;

    public static void main(String[] args) {
        // write your code here
        String[][] game = startGame();
        displayGame(game);
        boolean isXPlaying = isXTurn(game);
        boolean isGameEnd = false;
        state = GameState.NOT_FINISH;
        while (!isGameEnd) {
            if (isXPlaying) {
                userMove(game);
            } else {
                computerMoveLevelEasy(game);
            }

            displayGame(game);

            if (checkThreeInALine(game)) {
                isGameEnd = true;
                state = isXPlaying ? GameState.X_WIN : GameState.O_WIN;
            } else {
                if (!hasEmptyElement(game)) {
                    isGameEnd = true;
                    state = GameState.DRAW;
                }
            }

            isXPlaying = !isXPlaying;
        }
        System.out.println(state.message);
    }

    static String[][] startGame() {
        String[][] game = new String[DIMENSION][DIMENSION];
        String input = " ".repeat(9);
        int i = 0;
        for (int j = 0; j < DIMENSION; j++) {
            for (int k = 0; k < DIMENSION; k++) {
                game[j][k] = String.valueOf(input.charAt(i));
                i++;
            }
        }
        return game;
    }

    static boolean isXTurn(String[][] matrix) {
        int numberX = 0;
        int numberO = 0;
        for (int i = 0; i < DIMENSION; i++) {
            for (int j = 0; j < DIMENSION; j++) {
                if (matrix[i][j].equals("X")) {
                    numberX++;
                }
                if (matrix[i][j].equals("O")) {
                    numberO++;
                }
            }
        }
        return numberX <= numberO;
    }

    static void displayGame(String[][] game) {
        System.out.println("-".repeat(TOTAL_LENGTH_OF_FIELD));
        for (int i = 0; i < DIMENSION; i++) {
            System.out.print("| ");
            for (int j = 0; j < DIMENSION; j++) {
                System.out.print(game[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("-".repeat(9));
    }

    static int[] getCoordinates() {
        System.out.print("Enter the coordinates: ");
        StringBuilder input = new StringBuilder();
        input.append(scanner.next());
        input.append(scanner.nextLine());
        String[] numbersAsString = input.toString().split(" ");

        try {
            int[] coordinates = Arrays.stream(numbersAsString)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int coordinate : coordinates) {
                if (coordinate > DIMENSION || coordinate < 1) {
                    System.out.println("Coordinates should be from 1 to 3!");
                    return getCoordinates();
                }
            }
            return coordinates;
        } catch (Exception e) {
            System.out.println("You should enter numbers!");
            return getCoordinates();
        }


    }

    static boolean isOccupied(String[][] matrix, int[] indexes) {
        return !matrix[indexes[0]][indexes[1]].equals(" ");
    }

    static int[] convertCoordinateToIndex(int[] coordinates) {
        return new int[]{DIMENSION - coordinates[1], coordinates[0] - 1};
    }

    static boolean rowHasEmptyElement(String[] row) {
        for (int i = 0; i < DIMENSION; i++) {
            if (row[i].equals(" ")) {
                return true;
            }
        }
        return false;
    }

    static boolean hasEmptyElement(String[][] matrix) {
        for (int row = 0; row < DIMENSION; row++) {
            if (rowHasEmptyElement(matrix[row])) {
                return true;
            }
        }
        return false;
    }

    static boolean checkThreeInALine(String[][] matrix) {
        for (int i = 0; i < DIMENSION; i++) {
            // check each row i
            if (matrix[i][0].equals(matrix[i][1])) {
                if (matrix[i][2].equals(matrix[i][0])) {
                    if (!matrix[i][0].equals(" ")) {
                        return true;
                    }
                }
            }

            // check each column i
            if (matrix[0][i].equals(matrix[1][i])) {
                if (matrix[2][i].equals(matrix[0][i])) {
                    if (!matrix[0][i].equals(" ")) {
                        return true;
                    }
                }
            }
        }

        // check main diagonal
        if (matrix[0][0].equals(matrix[1][1])) {
            if (matrix[0][0].equals(matrix[2][2])) {
                if (!matrix[0][0].equals(" ")) {
                    return true;
                }
            }
        }

        // check side diagonal
        if (matrix[0][2].equals(matrix[1][1])) {
            if (matrix[1][1].equals(matrix[2][0])) {
                if (!matrix[0][2].equals(" ")) {
                    return true;
                }
            }
        }

        return false;
    }

    static void userMove(String[][] game) {
        int[] coordinates = getCoordinates();
        int[] indexes = convertCoordinateToIndex(coordinates);
        while (isOccupied(game, indexes)) {
            System.out.println("This cell is occupied! Choose another one!");
            coordinates = getCoordinates();
            indexes = convertCoordinateToIndex(coordinates);
        }
        game[indexes[0]][indexes[1]] = "X";
    }

    static void computerMoveLevelEasy(String[][] game) {
        System.out.println("Making move level \"easy\"");
        Random random = new Random(3);
        int[] indexes = new int[2];
        indexes[0] = random.nextInt(3);
        indexes[1] = random.nextInt(3);
        while (isOccupied(game, indexes)) {
            indexes[0] = random.nextInt(3);
            indexes[1] = random.nextInt(3);
        }
        game[indexes[0]][indexes[1]] = "O";
    }
}

enum GameState {
    X_WIN("X wins"),
    O_WIN("O wins"),
    DRAW("Draw"),
    NOT_FINISH("Game not finished");
    String message;

    GameState(String message) {
        this.message = message;
    }
}