package java_fundamentals.optional_task1;

import java.util.Scanner;

public class ShortestAndLongestNumber {
    public static void main(String[] args) {

        /**
         * Find the shortest and longest number. Print the found numbers and their length.
         * @param numberOfValues - the number of values entered by the user
         * @param inputtedNumbers - array with input numbers
         * @param smallestNumber - smallest number in array
         * @param largestNumber - largest number in array
         */

        System.out.println("Enter the number of values: ");
        Scanner scanner = new Scanner(System.in);

        int numberOfValues = scanner.nextInt();
        int[] inputtedNumbers = new int[numberOfValues];
        System.out.println("Enter numbers: ");

        for (int i = 0; i < numberOfValues; i++) {
            inputtedNumbers[i] = scanner.nextInt();
        }

        int smallestNumber = inputtedNumbers[0];
        int largestNumber = inputtedNumbers[0];

        for (int i = 0; i < numberOfValues; i++) {
            if (inputtedNumbers[i] > largestNumber)
                largestNumber = inputtedNumbers[i];
            else if (inputtedNumbers[i] < smallestNumber)
                smallestNumber = inputtedNumbers[i];
        }
        System.out.println("Largest Number : " + largestNumber);
        System.out.println("Smallest Number : " + smallestNumber);
    }
}
