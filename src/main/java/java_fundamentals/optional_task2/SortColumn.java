package java_fundamentals.optional_task2;

import java.util.Scanner;

public class SortColumn {
    public static void main(String[] args) {

        /**
         * Sort the columns of the matrix in ascending order of the values of the elements of the k-th row
         * @param matrixValue - maximum value in matrix (range)
         * @param n - matrix dimension
         * @param matrix - the initial matrix
         * @param randomM - random number
         * @param sortingColumn - column for sorting
         */

        System.out.println("Enter the value of the matrix size: ");
        int matrixValue = 20;
        int matrixValueMax = matrixValue;
        int matrixValueMin = matrixValue * -1;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int randomM = (int) (Math.random() * (matrixValueMax - matrixValueMin + 1) + matrixValueMin);
                matrix[i][j] = randomM;
            }
        }

        System.out.println("The matrix with random elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" | " + matrix[i][j] + " | ");
            }
            System.out.println(" ");
        }

        System.out.println(" ");
        System.out.println("Select the column for sorting by ascending: ");

        int sortingColumn = scanner.nextInt();
        sortingColumn = sortingColumn - 1;
        boolean flag = true;
        int templateValue;
        while (flag) {
            flag = false;
            for (int k = 0; k < matrix.length - 1; k++) {
                if (matrix[k][sortingColumn] > matrix[k + 1][sortingColumn]) {
                    templateValue = matrix[k][sortingColumn];
                    matrix[k][sortingColumn] = matrix[k + 1][sortingColumn];
                    matrix[k + 1][sortingColumn] = templateValue;
                    flag = true;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" | " + matrix[i][j] + " | ");
            }
            System.out.println(" ");
        }
    }
}
