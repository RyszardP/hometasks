package java_fundamentals.main_task;

import java.util.Scanner;

public class MainTask1 {
    public static void main(String[] args) {

        /**
         * Task 1 Greet any user when entering their name through the command line.
         * @param name - the name the user input
         */

        System.out.println("Please enter your name");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.next();
        System.out.println("Hello " + name + "!");

    }
}



