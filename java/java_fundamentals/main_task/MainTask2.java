package java_fundamentals.main_task;

public class MainTask2 {
    public static void main(String[] args) {
        // 2. Отобразить в окне консоли аргументы командной строки в обратном порядке.
        for (int i = args.length - 1; i >= 0; i--) {
            System.out.println("Reverse : " + args[i]);
        }
    }
}
