package java_fundamentals.optional_task1;

import java.util.Scanner;

public class ShortestAndLongestNumber {
    public static void main(String[] args) {

        //Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

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
