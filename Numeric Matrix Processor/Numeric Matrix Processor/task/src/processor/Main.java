package processor;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static int getChoice() {
        System.out.print("1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "0. Exit\n" +
                "Your choice: ");
        return scanner.nextInt();
    }

    static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                System.out.print("Enter size of first matrix: ");
                int[] dimension = getDimension();
                System.out.println("Enter first matrix:");
                double[][] matrix1 = getMatrix(dimension[0], dimension[1]);
                System.out.print("Enter size of second matrix: ");
                dimension = getDimension();
                System.out.println("Enter second matrix:");
                double[][] matrix2 = getMatrix(dimension[0], dimension[1]);
                if (hasSameDimension(matrix1, matrix2)) {
                    System.out.println("The addition result is:");
                    display(sum(matrix1, matrix2));
                    break;
                }
                System.out.println("Dimensions of the two matrices have to be the same.");
                handleChoice(choice);
                break;
            case 2:
                System.out.print("Enter size of the matrix: ");
                dimension = getDimension();
                System.out.println("Enter the matrix:");
                double[][] matrix = getMatrix(dimension[0], dimension[1]);
                System.out.println("Enter a value:");
                double value = getValue();
                System.out.println("The multiplication result is:");
                display(multiplyByNumber(matrix, value));
                break;
            case 3:
                System.out.print("Enter size of first matrix: ");
                dimension = getDimension();
                System.out.println("Enter first matrix:");
                double[][] matrix3 = getMatrix(dimension[0], dimension[1]);
                System.out.print("Enter size of second matrix: ");
                dimension = getDimension();
                System.out.println("Enter second matrix:");
                double[][] matrix4 = getMatrix(dimension[0], dimension[1]);
                if (canMultiply(matrix3, matrix4)) {
                    System.out.println("The multiplication result is:");
                    display(multiplyMatrices(matrix3, matrix4));
                    break;
                }
                System.out.println("Number of columns of matrix 1 has to be equal to number of rows of matrix 2.");
                handleChoice(choice);
                break;
            case 0:
            default:
                break;
        }
    }

    static int[] getDimension() {
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[] {row, col};
    }

    static double[][] getMatrix(int row, int column) {
        double[][] matrix = new double[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }
        return matrix;
    }

    static boolean hasSameDimension(double[][] matrix1, double[][] matrix2) {
        return matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length;
    }

    static double[][] sum(double[][] matrix1, double[][] matrix2) {
        double[][] result = new double[matrix1.length][matrix1[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return result;
    }

    static double getValue() {
        return scanner.nextDouble();
    }

    static boolean canMultiply(double[][] matrix1, double[][] matrix2) {
        return matrix1[0].length == matrix2.length;
    }

    static double[][] multiplyByNumber(double[][] matrix, double value) {
        double[][] result = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j] * value;
            }
        }
        return result;
    }

    static double[][] multiplyMatrices(double[][] matrix1, double[][] matrix2) {
        int row1 = matrix1.length;
        int col1 = matrix1[0].length;
        int col2 = matrix2[0].length;
        double[][] result = new double[row1][col2];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col2; j++) {
                double value = 0;
                for (int k = 0; k < col1; k++) {
                    value += matrix1[i][k] * matrix2[k][j];
                }
                result[i][j] = value;
            }
        }
        return result;
    }

    static void display(double[][] matrix) {
        for (double[] row : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(row[j] + " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        int choice = getChoice();
        while (choice != 0) {
            handleChoice(choice);
            choice = getChoice();
        }
    }
}
