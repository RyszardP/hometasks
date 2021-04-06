package java_fundamentals.main_task;

public class MainTask4 {
    public static void main(String[] args) {

        /** Task 4 Enter integers as command line arguments, calculate their sum (product) and print the result
         * to the console.
         * @param arrayOfNumbers - numbers entered by the user
         */
        int[] arrayOfNumbers = new int[args.length];
        for (int i = 0; i < arrayOfNumbers.length; ++i) {
            arrayOfNumbers[i] = Integer.parseInt(args[i]);
        }
    }
}
