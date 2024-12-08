package main.java.lab3.station;

import main.java.lab3.model.Car;
import main.java.lab3.queue.Queue;
import main.java.lab3.service.Dineable;
import main.java.lab3.service.Refuelable;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> queue;

    // Summary data
    private int carsServed = 0;
    private int addedCars = 0;
    private int peopleFed = 0;
    private int robotsFed = 0;
    private int diningCars = 0;
    private int nonDiningCars = 0;
    private int totalConsumption = 0;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void addCar(Car car) {
        this.addedCars++;
        queue.enqueue(car);
    }

    public int getAddedCars() {
        return this.addedCars;
    }

    public Queue<Car> getQueue() {
        return queue;
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Serves cars in the queue and returns the number of cars served.
     */
    public int serveCars() {
        int carsServedInThisSession = 0;

        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            carsServedInThisSession++;

            // Update dining stats
            if (car.isDining()) {
                diningService.serveDinner(car.getId());
                diningCars++;
            } else {
                nonDiningCars++;
            }
            if (car.getPassengers().equalsIgnoreCase("PEOPLE")) {
                peopleFed++;
            } else if (car.getPassengers().equalsIgnoreCase("ROBOTS")) {
                robotsFed++;
            }

            // Update refueling stats
            int consumption = car.getConsumption();//refuelingService.refuel(car.getId());
            totalConsumption += consumption;

            carsServed++;
            System.out.println("Served car: " + car.getId());
        }

        return carsServedInThisSession;
    }

    public int getCarsServed() {
        return carsServed;
    }

    public int getPeopleFed() {
        return peopleFed;
    }

    public int getRobotsFed() {
        return robotsFed;
    }

    public int getDiningCars() {
        return diningCars;
    }

    public int getNonDiningCars() {
        return nonDiningCars;
    }

    public int getTotalConsumption() {
        return totalConsumption;
    }

    public void printSummary(String stationType) {
        System.out.println("Summary for " + stationType + " Station:");
        System.out.println("Cars Served: " + carsServed);
        System.out.println("People Fed: " + peopleFed);
        System.out.println("Robots Fed: " + robotsFed);
        System.out.println("Dining Cars: " + diningCars);
        System.out.println("Non-Dining Cars: " + nonDiningCars);
        System.out.println("Total Consumption: " + totalConsumption);
    }
}
