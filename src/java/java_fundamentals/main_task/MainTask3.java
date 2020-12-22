package java_fundamentals.main_task;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MainTask3 {
    public static void main(String[] args) {
        // 3.  Вывести заданное количество случайных чисел с переходом и без перехода на новую строку
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
