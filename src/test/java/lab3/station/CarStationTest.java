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
        Queue<Car> queue = new BasicQueue<>();
        Dineable diningService = new PeopleDinner();
        Refuelable refuelingService = new ElectricStation();

        CarStation carStation = new CarStation(diningService, refuelingService, queue);

        Car car1 = new Car("1", "ELECTRIC", "PEOPLE", true, 45);
        Car car2 = new Car("2", "ELECTRIC", "ROBOTS", false, 34);

        carStation.addCar(car1);
        carStation.addCar(car2);

        assertEquals(2, carStation.getAddedCars());
        assertFalse(carStation.isEmpty());
    }

    @Test
    void testServeCars() {
        Queue<Car> queue = new BasicQueue<>();
        TestDineable diningService = new TestDineable();
        TestRefuelable refuelingService = new TestRefuelable();

        CarStation carStation = new CarStation(diningService, refuelingService, queue);

        Car car1 = new Car("1", "ELECTRIC", "PEOPLE", true, 45);
        Car car2 = new Car("2", "GAS", "ROBOTS", false, 23);

        carStation.addCar(car1);
        carStation.addCar(car2);

        // Serve the cars
        carStation.serveCars();

        assertEquals(0, carStation.getQueue().size());
        assertTrue(carStation.isEmpty());

        assertEquals(1, diningService.getServedCars().size());
        assertTrue(diningService.getServedCars().contains("1")); // Car 1 dined

        assertEquals(2, carStation.getCarsServed());
        assertEquals(1, carStation.getPeopleFed());
        assertEquals(1, carStation.getRobotsFed());
        assertEquals(1, carStation.getDiningCars());
        assertEquals(1, carStation.getNonDiningCars());
        assertEquals(45 + 23, carStation.getTotalConsumption()); // Total consumption
    }

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
