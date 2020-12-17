package java_fundamentals.main_task;

import java.util.Scanner;

public class MainTask5 {
    public static void main(String[] args) {

        // Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить
        // проверку корректности ввода чисел.

        String[] month = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        System.out.println("Enter the number between 1 and 12");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
        } else {
            throw new IllegalArgumentException("Number not integer!");
        }

        int number = scanner.nextInt();
        if (!hasMonth(number)) {
            throw new IllegalArgumentException("Incorrect month number!");
        }
        System.out.println("Month is: " + month[number]);
    }

    public static boolean hasMonth(int monthNumber) {
        if (monthNumber > 0 && monthNumber <= 12) {
            return true;
        } else {
            return false;
        }
    }


}
