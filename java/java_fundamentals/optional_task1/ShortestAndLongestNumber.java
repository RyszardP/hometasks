package java_fundamentals.optional_task1;

import java.util.Scanner;

public class ShortestAndLongestNumber {
    public static void main(String[] args) {

        //Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.

        System.out.println("Enter the number of values: ");
        Scanner scanner = new Scanner(System.in);

        int numberOfValues = scanner.nextInt();
        int[] numbers = new int[numberOfValues];
        System.out.println("Enter numbers: ");

        for (int i = 0; i < numberOfValues; i++) {
            numbers[i] = scanner.nextInt();
        }

        int smallestNumber = numbers[0];
        int largestNumber = numbers[0];

        for (int i = 0; i < numberOfValues; i++) {
            if (numbers[i] > largestNumber)
                largestNumber = numbers[i];
            else if (numbers[i] < smallestNumber)
                smallestNumber = numbers[i];
        }
        System.out.println("Largest Number : " + largestNumber);
        System.out.println("Smallest Number : " + smallestNumber);
    }
}
