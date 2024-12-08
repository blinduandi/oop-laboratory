package main.java.lab3.util;


import main.java.lab3.model.Car;
import main.java.lab3.queue.*;
import main.java.lab3.service.ElectricStation;
import main.java.lab3.service.GasStation;
import main.java.lab3.service.PeopleDinner;
import main.java.lab3.service.RobotDinner;
import main.java.lab3.station.CarStation;

public class Semaphore {
    private CarStation electricCarStation;
    private CarStation gasCarStation;

    public Semaphore() {
        // Create custom queues for each car station
        Queue<Car> electricQueue = new BasicQueue<>();
        Queue<Car> gasQueue = new BasicQueue<>();

        // Create car stations with appropriate services
        this.electricCarStation = new CarStation(new PeopleDinner(), new ElectricStation(), electricQueue);
        this.gasCarStation = new CarStation(new RobotDinner(), new GasStation(), gasQueue);
    }

    public void guideCar(Car car) {
        if (car.getType().equalsIgnoreCase("ELECTRIC")) {
            electricCarStation.addCar(car);
        } else if (car.getType().equalsIgnoreCase("GAS")) {
            gasCarStation.addCar(car);
        } else {
            throw new IllegalArgumentException("Unknown car type: " + car.getType());
        }
    }

    public void serveAllCars() {
        electricCarStation.serveCars();
        gasCarStation.serveCars();
    }

    public CarStation getElectricCarStation() {
        return electricCarStation;
    }

    public CarStation getGasCarStation() {
        return gasCarStation;
    }
}