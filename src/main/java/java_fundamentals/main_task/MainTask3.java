package java_fundamentals.main_task;

import java.util.Random;
import java.util.Scanner;

public class MainTask3 {
    public static void main(String[] args) {


        /**
         * Task 3 Print a given number of random numbers with and without a jump to a new line
         * @param arrayWithNumbers - numbers entered by the user amount of numbers
         */
        System.out.println("Please enter ");
        Scanner scanner = new Scanner(System.in);
        int numbers = scanner.nextInt();
        int[] arrayWithNumbers = new int[numbers];
        Random random = new Random();

        for (int i = 0; i < arrayWithNumbers.length; i++) {
            arrayWithNumbers[i] = random.nextInt();
        }


        for (int i = 0; i < arrayWithNumbers.length; i++) {
            System.out.println(arrayWithNumbers[i]);
        }
        for (int i = 0; i < arrayWithNumbers.length; i++) {
            System.out.print(arrayWithNumbers[i] + " ");
        }

    }
}
