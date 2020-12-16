package java_fundamentals.optional_task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class SortColumn {
    public static void main(String[] args) {

        // Упорядочить строки (столбцы) матрицы в порядке возрастания значений элементов k-го столбца (строки).
        System.out.println("Sort the rows (columns) of the matrix in ascending order of the values of the elements" +
                " of the k-th column (row).");
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

        System.out.println(" ");
        System.out.println("Select the column for sorting by ascending: ");

        int t = scanner.nextInt();
        t = t - 1;

        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for (int k = 0; k < matrix.length - 1; k++) {
                if (matrix[k][t] > matrix[k + 1][t]) {
                    temp = matrix[k][t];
                    matrix[k][t] = matrix[k + 1][t];
                    matrix[k + 1][t] = temp;
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
