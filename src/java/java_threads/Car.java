package java_threads;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread{

    public String name;
    public Semaphore parkingPlace;
    public Random random = new Random();
    public int parkingTime = random.nextInt(15) + 1;
    public int waitingTime = random.nextInt(3) + 1;

    public Car(String name) {
        this.name = name;
        this.parkingPlace = Parking.parkingPlace;
    }

    @Override
    public void run() {
        if (parkingPlace.availablePermits() == 0) {
            System.out.println(name + "is waiting free parking place.");
            checkAndWaitParkingPlace(1);
        } else {
            this.locatedOnParking();
        }
    }

    private void locatedOnParking() {
        try {
            parkingPlace.acquire();
            System.out.println(name + " located on parking place and will be stay " + parkingTime + " sec. " +
                    "Left " + Parking.parkingPlace.availablePermits() + " parking place.");
            TimeUnit.SECONDS.sleep(parkingTime);
            System.out.println(name + " drives out from parking and freed up a parking place.");
            parkingPlace.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void checkAndWaitParkingPlace(int timeForCheck) {
        try {
            TimeUnit.SECONDS.sleep(timeForCheck);
            if (waitingTime == 0) {
                System.out.println(name + " don't find the free place and drives out.");
            } else if (parkingPlace.availablePermits() == 0) {
                waitingTime--;
                checkAndWaitParkingPlace(timeForCheck);
            } else locatedOnParking();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



}
