package java_fundamentals.main_task;

import java.util.Scanner;

public class MainTask5 {
    public static void main(String[] args) {

        /**
         * Task 5. Enter a number from 1 to 12. Output to the console the name of the month corresponding to the given
         * date. Check the correctness of entering numbers.
         * @param months - array with months
         * @param inputNumber - the number of user input
         */
        String[] months = {"", "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};
        System.out.println("Enter the number between 1 and 12");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
        } else {
            throw new IllegalArgumentException("Number not integer!");
        }

        int inputNumber = scanner.nextInt();
        if (!hasMonth(inputNumber)) {
            throw new IllegalArgumentException("Incorrect month number!");
        }
        System.out.println("Month is: " + months[inputNumber]);
    }

    /**
     * method for checking if the number being checked is in the array
     * @param monthNumber -
     * @return
     */
    public static boolean hasMonth(int monthNumber) {
        if (monthNumber > 0 && monthNumber <= 12) {
            return true;
        } else {
            return false;
        }
    }


}
