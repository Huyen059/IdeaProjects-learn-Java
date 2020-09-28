package tictactoe;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int DIMENSION = 3;
    public static final int TOTAL_LENGTH_OF_FIELD = 9;
    static Scanner scanner = new Scanner(System.in);
    static GameState state;
    static Player[] allPlayerRoles = Player.values();
    static Player player1;
    static Player player2;
    static boolean exit = false;

    public static void main(String[] args) {
        // write your code here
        getCommand();
        while (!exit) {
            String[][] game = startGame();
            displayGame(game);
            boolean isXPlaying = true;
            String character;
            boolean isGameEnd = false;
            state = GameState.NOT_FINISH;
            Player currentPlayer;
            while (!isGameEnd) {
                if (isXPlaying) {
                    character = "X";
                    currentPlayer = player1;
                } else {
                    character = "O";
                    currentPlayer = player2;
                }

                if (currentPlayer == Player.USER) {
                    userMove(game, character);
                } else if (currentPlayer == Player.COMPUTER_EASY) {
                    System.out.println("Making move level \"easy\"");
                    computerMoveLevelEasy(game, character);
                } else if (currentPlayer == Player.COMPUTER_MEDIUM) {
                    System.out.println("Making move level \"medium\"");
                    computerMoveLevelMedium(game, character);
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
            getCommand();
        }
    }

    static void getCommand() {
        System.out.print("Input command: ");
        String input = scanner.nextLine();
        if (input.equals("exit")) {
            exit = true;
            return;
        }
        getPlayers(input);
    }

    static void getPlayers(String command) {
        String[] inputs = command.split(" ");
        if (inputs.length != 3) {
            System.out.println("Bad parameters!");
            getCommand();
            return;
        }

        for (Player role : allPlayerRoles) {
            if (inputs[1].equals(role.name)) {
                player1 = role;
            }

            if (inputs[2].equals(role.name)) {
                player2 = role;
            }
        }

        if (player1 == null || player2 == null) {
            System.out.println("Please enter correct players.");
            getCommand();
        }
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
        String input = scanner.next() +
                scanner.nextLine();
        String[] numbersAsString = input.split(" ");

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
            if (!matrix[i][0].equals(" ")
                    && matrix[i][0].equals(matrix[i][1])
                    && matrix[i][2].equals(matrix[i][0])) {
                return true;
            }

            // check each column i
            if (!matrix[0][i].equals(" ")
                    && matrix[0][i].equals(matrix[1][i])
                    && matrix[2][i].equals(matrix[0][i])) {
                return true;
            }
        }

        // check main diagonal
        if (!matrix[0][0].equals(" ")
                && matrix[0][0].equals(matrix[1][1])
                && matrix[0][0].equals(matrix[2][2])) {
            return true;
        }

        // finally, check side diagonal
        return !matrix[0][2].equals(" ")
                && matrix[0][2].equals(matrix[1][1])
                && matrix[1][1].equals(matrix[2][0]);
    }

    static void userMove(String[][] game, String character) {
        int[] coordinates = getCoordinates();
        int[] indexes = convertCoordinateToIndex(coordinates);
        while (isOccupied(game, indexes)) {
            System.out.println("This cell is occupied! Choose another one!");
            coordinates = getCoordinates();
            indexes = convertCoordinateToIndex(coordinates);
        }
        game[indexes[0]][indexes[1]] = character;
    }

    static void computerMoveLevelEasy(String[][] game, String character) {
        Random random = new Random(System.currentTimeMillis());
        int[] indexes = new int[2];
        indexes[0] = random.nextInt(3);
        indexes[1] = random.nextInt(3);
        while (isOccupied(game, indexes)) {
            indexes[0] = random.nextInt(3);
            indexes[1] = random.nextInt(3);
        }
        game[indexes[0]][indexes[1]] = character;
    }

    static void computerMoveLevelMedium(String[][] game, String character) {
        for (int i = 0; i < DIMENSION; i++) {
            if (game[i][0].equals(game[i][1]) && !game[i][0].equals(" ")) {
                if (!isOccupied(game, new int[] {i, 2})) {
                    game[i][2] = character;
                    return;
                }
            }

            if (game[i][0].equals(game[i][2]) && !game[i][0].equals(" ")) {
                if (!isOccupied(game, new int[] {i, 1})) {
                    game[i][1] = character;
                    return;
                }
            }

            if (game[i][1].equals(game[i][2]) && !game[i][1].equals(" ")) {
                if (!isOccupied(game, new int[] {i, 0})) {
                    game[i][0] = character;
                    return;
                }
            }

            if (game[0][i].equals(game[1][i]) && !game[0][i].equals(" ")) {
                if (!isOccupied(game, new int[] {2, i})) {
                    game[2][i] = character;
                    return;
                }
            }

            if (game[0][i].equals(game[2][i]) && !game[0][i].equals(" ")) {
                if (!isOccupied(game, new int[] {1, i})) {
                    game[1][i] = character;
                    return;
                }
            }

            if (game[1][i].equals(game[2][i]) && !game[1][i].equals(" ")) {
                if (!isOccupied(game, new int[] {0, i})) {
                    game[0][i] = character;
                    return;
                }
            }
        }

        if (game[0][0].equals(game[1][1]) && !game[0][0].equals(" ")) {
            if (!isOccupied(game, new int[] {2, 2})) {
                game[2][2] = character;
                return;
            }
        }

        if (!game[0][0].equals(" ")
                && (game[0][0].equals(game[2][2])
                || game[0][2].equals(game[2][0]))) {
            if (!isOccupied(game, new int[] {1, 1})) {
                game[1][1] = character;
                return;
            }
        }

        if (game[2][2].equals(game[1][1]) && !game[1][1].equals(" ")) {
            if (!isOccupied(game, new int[] {0, 0})) {
                game[0][0] = character;
                return;
            }
        }

        if (game[0][2].equals(game[1][1]) && !game[1][1].equals(" ")) {
            if (!isOccupied(game, new int[] {2, 0})) {
                game[2][0] = character;
                return;
            }
        }

        if (game[2][0].equals(game[1][1]) && !game[1][1].equals(" ")) {
            if (!isOccupied(game, new int[] {0, 2})) {
                game[0][2] = character;
                return;
            }
        }

        computerMoveLevelEasy(game, character);
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

enum Player {
    USER("user"),
    COMPUTER_EASY("easy"),
    COMPUTER_MEDIUM("medium");
    String name;

    Player(String name) {
        this.name = name;
    }
}