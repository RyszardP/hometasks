package java_threads;


import java_threads.util.CarUtil;

public class Runner {
    public static void main(String[] args) {
        CarUtil carUtil = new CarUtil(15);
        carUtil.start();
    }
}
