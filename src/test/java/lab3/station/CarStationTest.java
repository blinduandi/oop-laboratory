package test.java.lab3.station;


import main.java.lab3.model.Car;
import main.java.lab3.queue.BasicQueue;
import main.java.lab3.queue.Queue;
import main.java.lab3.service.Dineable;
import main.java.lab3.service.ElectricStation;
import main.java.lab3.service.PeopleDinner;
import main.java.lab3.service.Refuelable;
import main.java.lab3.station.CarStation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarStationTest {

    @Test
    void testAddCar() {
        // Create a queue and services
        Queue<Car> queue = new BasicQueue<>();
        Dineable diningService = new PeopleDinner();
        Refuelable refuelingService = new ElectricStation();

        // Create the CarStation
        CarStation carStation = new CarStation(diningService, refuelingService, queue);

        // Add cars to the CarStation
        Car car1 = new Car("1", "ELECTRIC", "PEOPLE", true);
        Car car2 = new Car("2", "ELECTRIC", "PEOPLE", false);

        carStation.addCar(car1);
        carStation.addCar(car2);

        // Verify that the cars are added to the queue
        assertEquals(2, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    void testServeCars() {
        // Create a queue and services
        Queue<Car> queue = new BasicQueue<>();
        Dineable diningService = new TestDineable(); // Custom test implementation
        Refuelable refuelingService = new TestRefuelable(); // Custom test implementation

        // Create the CarStation
        CarStation carStation = new CarStation(diningService, refuelingService, queue);

        // Add cars to the CarStation
        Car car1 = new Car("1", "ELECTRIC", "PEOPLE", true);
        Car car2 = new Car("2", "GAS", "ROBOTS", false);

        carStation.addCar(car1);
        carStation.addCar(car2);

        // Serve the cars
        carStation.serveCars();

        // Verify that the queue is empty after serving all cars
        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());

        // Verify that the services were invoked correctly
        TestDineable testDineable = (TestDineable) diningService;
        TestRefuelable testRefuelable = (TestRefuelable) refuelingService;

        assertEquals(1, testDineable.getServedCars().size());
        assertTrue(testDineable.getServedCars().contains("1")); // Car 1 dined

        assertEquals(2, testRefuelable.getRefueledCars().size());
        assertTrue(testRefuelable.getRefueledCars().contains("1")); // Car 1 refueled
        assertTrue(testRefuelable.getRefueledCars().contains("2")); // Car 2 refueled
    }

    // Helper class for testing Dineable
    private static class TestDineable implements Dineable {
        private final List<String> servedCars = new ArrayList<>();

        @Override
        public void serveDinner(String carId) {
            servedCars.add(carId);
        }

        public List<String> getServedCars() {
            return servedCars;
        }
    }

    // Helper class for testing Refuelable
    private static class TestRefuelable implements Refuelable {
        private final List<String> refueledCars = new ArrayList<>();

        @Override
        public void refuel(String carId) {
            refueledCars.add(carId);
        }

        public List<String> getRefueledCars() {
            return refueledCars;
        }
    }
}