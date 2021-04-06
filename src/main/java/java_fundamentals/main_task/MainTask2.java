package java_fundamentals.main_task;

public class MainTask2 {
    public static void main(String[] args) {

        /**
         * Task 2. Display command line arguments in reverse order in a console window.
         */

        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println("Reverse : " + args[i]);
        }
    }
}
