package processor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = getChoice();
        while (choice != 0) {
            handleChoice(choice);
            choice = getChoice();
        }
    }

    static int getChoice() {
        System.out.print("1. Add matrices\n" +
                "2. Multiply matrix by a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "5. Calculate a determinant\n" +
                "6. Inverse matrix\n" +
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
            case 4:
                int transposeOption = getTransposeOption();
                System.out.print("Enter matrix size: ");
                dimension = getDimension();
                System.out.println("Enter matrix:");
                double[][] matrix5 = getMatrix(dimension[0], dimension[1]);
                display(transpose(transposeOption, matrix5));
                break;
            case 5:
                System.out.print("Enter matrix size: ");
                dimension = getDimension();
                System.out.println("Enter matrix:");
                double[][] matrix6 = getMatrix(dimension[0], dimension[1]);
                System.out.println(calculateDeterminant(matrix6));
                break;
            case 6:
                System.out.print("Enter matrix size: ");
                dimension = getDimension();
                System.out.println("Enter matrix:");
                double[][] matrix7 = getMatrix(dimension[0], dimension[1]);
                System.out.println("The result is:");
                display(inverse(matrix7));
                break;
            default:
                break;
        }
    }

    static int[] getDimension() {
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new int[]{row, col};
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

    static int getTransposeOption() {
        System.out.print("1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n" +
                "Your choice: ");
        return scanner.nextInt();
    }

    static double[][] transpose(int transposeOption, double[][] matrix) {
        double[][] result = new double[matrix.length][matrix[0].length];
        switch (transposeOption) {
            case 1:
                result = transposeMainDiagonal(matrix);
                break;
            case 2:
                result = transposeSideDiagonal(matrix);
                break;
            case 3:
                result = transposeVerticalLine(matrix);
                break;
            case 4:
                result = transposeHorizontalLine(matrix);
                break;
            default:
                break;
        }
        return result;
    }

    static double[][] transposeMainDiagonal(double[][] matrix) {
        int size = matrix.length;
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

    static double[][] transposeSideDiagonal(double[][] matrix) {
        int size = matrix.length;
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix[size - 1 - j][size - 1 - i];
            }
        }
        return result;
    }

    static double[][] transposeVerticalLine(double[][] matrix) {
        int size = matrix.length;
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix[i][size - 1 - j];
            }
        }
        return result;
    }

    static double[][] transposeHorizontalLine(double[][] matrix) {
        int size = matrix.length;
        double[][] result = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result[i][j] = matrix[size - 1 - i][j];
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

    static double calculateDeterminant(double[][] matrix) {
        int size = matrix.length;

        if (size == 1) {
            return matrix[0][0];
        }

        if (size == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }

        double result = 0;
        for (int j1 = 0; j1 < size; j1++) {
            double[][] subMatrix = generateSubMatrix(matrix, size, 0, j1);
            result += Math.pow(-1.0, 1.0 + j1 + 1.0) * matrix[0][j1] * calculateDeterminant(subMatrix);
        }
        return result;
    }

    static double[][] generateSubMatrix(double[][] matrix, int size, int i1, int j1) {
        double[][] subMatrix = new double[size - 1][size - 1];
        int i2 = 0;
        for (int i = 0; i < size; i++) {
            if (i == i1) {
                continue;
            }
            int j2 = 0;
            for (int j = 0; j < size; j++) {
                if (j == j1) {
                    continue;
                }
                subMatrix[i2][j2] = matrix[i][j];
                j2++;
            }
            i2++;
        }
        return subMatrix;
    }

    static double[][] inverse(double[][] matrix) {
        double determinant = calculateDeterminant(matrix);
        int size = matrix.length;
        double[][] cofactors = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                double[][] cofactor = generateSubMatrix(matrix, size, i, j);
                cofactors[i][j] = Math.pow(-1, i + j) * calculateDeterminant(cofactor);
            }
        }
        double[][] transpose = transposeMainDiagonal(cofactors);
        try {
            return multiplyByNumber(transpose, 1 / determinant);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return cofactors;
        }
    }
}
