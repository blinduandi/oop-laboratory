package main.java.lab3.station;


import main.java.lab3.model.Car;
import main.java.lab3.queue.Queue;
import main.java.lab3.service.Dineable;
import main.java.lab3.service.Refuelable;

public class CarStation {
    private Dineable diningService;
    private Refuelable refuelingService;
    private Queue<Car> queue;

    public CarStation(Dineable diningService, Refuelable refuelingService, Queue<Car> queue) {
        this.diningService = diningService;
        this.refuelingService = refuelingService;
        this.queue = queue;
    }

    public void addCar(Car car) {
        queue.enqueue(car);
    }

    public void serveCars() {
        while (!queue.isEmpty()) {
            Car car = queue.dequeue();
            System.out.println("Serving car: " + car.getId());
            if (car.isDining()) {
                diningService.serveDinner(car.getId());
            }refuelingService.refuel(car.getId());
        }
    }
}