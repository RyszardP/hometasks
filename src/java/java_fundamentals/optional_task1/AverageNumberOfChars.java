package java_fundamentals.optional_task1;

import java.util.Scanner;

public class AverageNumberOfChars {
    public static void main(String[] args) {

        //Вывести на консоль те числа, длина которых (больше) средней длины по всем числам, а также длину.

        System.out.println("Print to the console those numbers whose length is less (more) than the average length" +
                ". for all numbers, as well as the length.");
        System.out.println("Enter the number of values: ");
        Scanner scanner = new Scanner(System.in);

        int numberOfValues = scanner.nextInt();
        int[] inputtedNumbers = new int[numberOfValues];
        int[] numOfChars = new int[numberOfValues];
        int sumOFNumChars = 0;
        double averageLength;

        System.out.println("Enter numbers: ");
        for (int i = 0; i < numberOfValues; i++) {
            inputtedNumbers[i] = scanner.nextInt();
        }
        System.out.println();
        // array with number of chars in every number
        for (int i = 0; i < numberOfValues; i++) {
            numOfChars[i] = String.valueOf(inputtedNumbers[i]).length();
            sumOFNumChars += numOfChars[i];
        }

        System.out.println("Sum of chars in array: " + sumOFNumChars);
        averageLength = (double) sumOFNumChars / (double) numberOfValues;
        System.out.println("Average length: " + averageLength);

        System.out.println("Number large then average");
        for (int i = 0; i < numOfChars.length; i++) {
            if (numOfChars[i] > averageLength) {
                System.out.println("Numbers :" + inputtedNumbers[i] + ", number of chars " + numOfChars[i]);
            }
        }
    }
}
