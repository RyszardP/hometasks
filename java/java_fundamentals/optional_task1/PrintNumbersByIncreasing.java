package java_fundamentals.optional_task1;

import java.util.Scanner;

public class PrintNumbersByIncreasing {
    public static void main(String[] args) {

        // Вывести числа в порядке возрастания (убывания) значений их длины.

        System.out.println("Print the numbers in increasing order of their lengths.");
        System.out.println("Enter the number of values: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfValues = scanner.nextInt();
        int[] numbers = new int[numberOfValues];

        System.out.println("Enter numbers: ");
        for (int i = 0; i < numberOfValues; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int i = numbers.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = tmp;
                }
            }

        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
