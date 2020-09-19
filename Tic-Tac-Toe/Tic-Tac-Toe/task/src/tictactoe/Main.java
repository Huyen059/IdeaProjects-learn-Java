package tictactoe;

import java.util.Scanner;

public class Main {
    public static final String X_WINS = "X wins";
    public static final String O_WINS = "O wins";
    public static final String GAME_NOT_FINISHED = "Game not finished";
    public static final String DRAW = "Draw";
    public static final String IMPOSSIBLE = "Impossible";

    public static String[][] generateEmptyField() {
        String[][] characters = new String[3][3];
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < 3; j++) {
                characters[i][j] = "_";
            }
        }
        return characters;
    }

    public static void displayField(String[][] characters) {
        System.out.println("---------");
        for (String[] arr : characters) {
            System.out.print("| ");
            for (String character : arr) {
                System.out.print(character + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public static int[] askForCoordinates() {
        Scanner scanner = new Scanner(System.in);
        String msg = "Enter the coordinates:";
        System.out.println(msg);
        int coord1 = 0;
        int coord2 = 0;
        if (!scanner.hasNextInt()) {
            System.out.println("You should enter numbers!");
            int[] result = askForCoordinates();
            coord1 = result[0];
            coord2 = result[1];
        } else {
            coord1 = scanner.nextInt();
            if (!scanner.hasNextInt()) {
                System.out.println("You should enter numbers!");
                int[] result = askForCoordinates();
                coord1 = result[0];
                coord2 = result[1];
            } else {
                coord2 = scanner.nextInt();
            }
        }

        if (coord1 < 1 || coord1 > 3 || coord2 < 1 || coord2 > 3) {
            System.out.println("Coordinates should be from 1 to 3!");
            int[] result = askForCoordinates();
            coord1 = result[0];
            coord2 = result[1];
        }

        return new int[]{coord1, coord2};
    }

    public static int[] convertCoordToIndex(int[] coord) {
        return new int[]{3 - coord[1], coord[0] - 1};
    }

    public static int[] getMovePosition(String[][] characters) {
        int[] coord = askForCoordinates();
        int[] indices = convertCoordToIndex(coord);
        if (characters[indices[0]][indices[1]].equals("_")) {
            return indices;
        }

        System.out.println("This cell is occupied! Choose another one!");
        return getMovePosition(characters);
    }

    public static String getGameStatus(String[][] characters) {
        String msg = "";
        boolean isThreeXInARow = false;
        boolean isThreeOInARow = false;
        boolean hasEmptyCell = false;

        for (int i = 0; i < characters.length; i++) {
            // Check if there is empty cell
            if (!hasEmptyCell) {
                for (int j = 0; j < 3; j++) {
                    if (characters[i][j].equals("_")) {
                        hasEmptyCell = true;
                        break;
                    }
                }
            }

            // check if there are 3 same characters in a row
            if (characters[i][1].equals(characters[i][0]) && characters[i][2].equals(characters[i][0])) {
                if (characters[i][0].equals("_")) {
                    continue;
                }
                if (characters[i][0].equals("X")) {
                    isThreeXInARow = true;
                }
                if (characters[i][0].equals("O")) {
                    isThreeOInARow = true;
                }
            }

            //Check if there are 3 same characters in a column
            if (characters[1][i].equals(characters[0][i]) && characters[2][i].equals(characters[0][i])) {
                if (characters[0][i].equals("_")) {
                    continue;
                }
                if (characters[0][i].equals("X")) {
                    isThreeXInARow = true;
                }
                if (characters[0][i].equals("O")) {
                    isThreeOInARow = true;
                }
            }
        }

        // Check if the diagonal has 3 same characters
        if (characters[1][1].equals(characters[0][0]) && characters[2][2].equals(characters[0][0])) {
            if (characters[1][1].equals("X")) {
                isThreeXInARow = true;
            } else if (characters[1][1].equals("O")) {
                isThreeOInARow = true;
            }
        }

        if (characters[2][0].equals(characters[1][1]) && characters[0][2].equals(characters[1][1])) {
            if (characters[1][1].equals("X")) {
                isThreeXInARow = true;
            } else if (characters[1][1].equals("O")) {
                isThreeOInARow = true;
            }
        }

        if (isThreeXInARow && !isThreeOInARow) {
            msg = X_WINS;
        }

        if (isThreeOInARow && !isThreeXInARow) {
            msg = O_WINS;
        }

        if (!isThreeOInARow && !isThreeXInARow) {
            if (hasEmptyCell) {
                msg = GAME_NOT_FINISHED;
            } else {
                msg = DRAW;
            }
        }

        /*
        if (Math.abs(countO - countX) >= 2 || isThreeOInARow && isThreeXInARow) {
            msg = "Impossible";
        }
         */

        if (isThreeOInARow && isThreeXInARow) {
            msg = IMPOSSIBLE;
        }

        return msg;
    }

    public static void main(String[] args) {
        // write your code here
        // Getting input from console
        Scanner scanner = new Scanner(System.in);
        /*
        String input = scanner.next();
        // Adding input into array
        char[] inputAsArray = input.toCharArray();
        String[][] characters = new String[3][3];
        int countX = 0;
        int countO = 0;
        for (int i = 0; i < characters.length; i++) {
            for (int j = 0; j < 3; j++) {
                characters[i][j] = String.valueOf(inputAsArray[3 * i + j]);
                if (characters[i][j].equals("X")) {
                    countX++;
                }
                if (characters[i][j].equals("O")) {
                    countO++;
                }
            }
        }
         */
        /*---CREATE AN EMPTY FIELD---*/
        String[][] characters = generateEmptyField();
        // For display in the console
        displayField(characters);
        boolean isXPlaying = true;
        String playingCharacter;
        while (getGameStatus(characters).equals(GAME_NOT_FINISHED)) {
            if(isXPlaying) {
                playingCharacter = "X";
            } else {
                playingCharacter = "O";
            }
            /*---MOVE---*/
            /*
        (j0 c1, i0 c3) (j1 c2, i0 c3) (j2 c3, i0 c3)
        (j0 c1, i1 c2) (j1 c2, i1 c2) (j2 c3, i1 c2)
        (j0 c1, i2 c1) (j1 c2, i2 c1) (j2 c3, i2 c1)
        */
            int[] indices = getMovePosition(characters);
            characters[indices[0]][indices[1]] = playingCharacter;
            displayField(characters);

            isXPlaying = !isXPlaying;
        }

        System.out.println(getGameStatus(characters));
    }
}
