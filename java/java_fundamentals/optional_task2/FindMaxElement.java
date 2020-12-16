package java_fundamentals.optional_task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FindMaxElement {
    public static void main(String[] args) {
        // Задание. Ввести с консоли n - размерность матрицы a [n] [n]. Задать значения элементов матрицы в интервале
        // значений от -M до M с помощью генератора случайных чисел (класс Random).

        //Найти максимальный элемент в матрице и удалить из матрицы все строки и столбцы, его содержащие

        System.out.println("Enter n from the console - the dimension of the matrix a [n] [n]. Set the values of matrix" +
                " elements in the range of values from -M to M using a random number generator (Random class).");
        System.out.println("Enter the value of the matrix size: ");
        int m = 20;
        int mMax = m;
        int mMin = m * -1;

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] matrix = new int[n][n];
        // Fill the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int randomM = (int) (Math.random() * (mMax - mMin + 1) + mMin);
                //  System.out.println(randomM);
                matrix[i][j] = randomM;
            }
        }
        //Print the matrix
        System.out.println("The matrix with random elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(" | " + matrix[i][j] + " | ");
            }
            System.out.println(" ");
        }

        // Find the maximum element of the matrix and row with column

        int maxElement = mMin;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > maxElement)
                    maxElement = matrix[i][j];
            }
        }
        System.out.println(" ");
        System.out.println("The maximum element of the matrix: " + maxElement);

        List<Integer> rowsWithMaxElement = new ArrayList<>();
        List<Integer> colsWithMaxElement = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                if (value == maxElement) {
                    rowsWithMaxElement.add(i);
                    colsWithMaxElement.add(j);
                }
            }
        }

        System.out.println();
        System.out.println("The matrix after deleting roW and column:");

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rowsWithMaxElement.contains(i) || colsWithMaxElement.contains(j)) {
                    matrix[i][j] = 0;
                }
                System.out.print(" | " + matrix[i][j] + " | ");
            }
            System.out.println();
        }

    }
}






