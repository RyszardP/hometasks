package java_fundamentals.main_task;

import java.util.Scanner;

public class MainTask4 {
    public static void main(String[] args) {
     /*   4.     Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение) и
        вывести результат на консоль.*/
        int[] arrayOfNumbers = new int[args.length];
        for (int i = 0; i < arrayOfNumbers.length; ++i) {
            arrayOfNumbers[i] = Integer.parseInt(args[i]);
        }
    }
}
