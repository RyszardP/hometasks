package java_fundamentals.optional_task2;

import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        // Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале
        // значений от -M до M с помощью генератора случайных чисел (класс Random).

        //Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие

        /**
         * Enter n from the console - the dimension of the matrix a [n] [n]. Set the values of matrix
         * elements in the range of values from -M to M using a random number generator (Random class).
         * @param matrixValue - maximum value in matrix (range)
         * @param n - matrix dimension
         * @param matrix - the initial matrix
         * @param randomM - random number
         * @param maxElement - max element in the matrix
         * @param resultMatrix - matrix without row and column containing maximum value
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

        int maxElement = matrix[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > maxElement)
                    maxElement = matrix[i][j];
            }
        }
        System.out.println(" ");
        System.out.println("The maximum element of the matrix: " + maxElement);

        boolean[] deleteRow = new boolean[matrix.length];
        boolean[] deleteColumn = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int k = 0; k < matrix.length; k++) {
                if (matrix[i][k] == maxElement) {
                    deleteRow[i] = true;
                    deleteColumn[k] = true;
                }
            }
        }

        int deletingRow = 0;
        int deletingColumn = 0;
        for (boolean b : deleteRow) {
            if (!b) {
                deletingRow++;
            }
        }
        for (boolean b : deleteColumn) {
            if (!b) {
                deletingColumn++;
            }
        }

        int[][] resultMatrix = new int[deletingRow][deletingColumn];
        int rowTmp = 0;
        int columnTmp = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (!deleteRow[i]) {
                for (int k = 0; k < matrix[i].length; k++) {
                    if (!deleteColumn[k]) {
                        resultMatrix[rowTmp][columnTmp] = matrix[i][k];
                        columnTmp++;
                    }
                }
                rowTmp++;
            }
        }

        System.out.println("The matrix after deleting row and column with maximum value");
        for (int i = 0; i < resultMatrix.length; i++) {
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(" | " + resultMatrix[i][j] + " | ");
            }
            System.out.println();
        }
    }
}






