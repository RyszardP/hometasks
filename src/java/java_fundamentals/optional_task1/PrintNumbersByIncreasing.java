package java_fundamentals.optional_task1;

import java.util.Scanner;

public class PrintNumbersByIncreasing {
    public static void main(String[] args) {

        /**
         * Print numbers in ascending (descending) order of their lengths.
         * @param numberOfValues - the number of values entered by the user
         * @param inputtedNumbers - array with input numbers
         */

        System.out.println("Print the numbers in increasing order of their lengths.");
        System.out.println("Enter the number of values: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfValues = scanner.nextInt();
        int[] inputtedNumbers = new int[numberOfValues];

        System.out.println("Enter numbers: ");
        for (int i = 0; i < numberOfValues; i++) {
            inputtedNumbers[i] = scanner.nextInt();
        }

        for (int i = inputtedNumbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (inputtedNumbers[j] > inputtedNumbers[j + 1]) {
                    int tmp = inputtedNumbers[j];
                    inputtedNumbers[j] = inputtedNumbers[j + 1];
                    inputtedNumbers[j + 1] = tmp;
                }
            }
        }
        for (int number : inputtedNumbers) {
            System.out.println(number);
        }
    }
}
