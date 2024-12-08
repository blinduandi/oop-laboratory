package test.java.lab3.util;

import main.java.lab3.model.Car;
import main.java.lab3.station.CarStation;
import main.java.lab3.util.JsonUtils;
import main.java.lab3.util.Semaphore;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SemaphoreTest {

    @Test
    void testSemaphore() throws Exception {
        // Create a semaphore
        Semaphore semaphore = new Semaphore();

        // Read car data from JSON files
        String car1Json = Files.readString(Paths.get("queue/Car1.json"));
        String car2Json = Files.readString(Paths.get("queue/Car2.json"));
        String car3Json = Files.readString(Paths.get("queue/Car3.json"));

        // Parse cars
        Car car1 = JsonUtils.parseCar(car1Json);
        Car car2 = JsonUtils.parseCar(car2Json);
        Car car3 = JsonUtils.parseCar(car3Json);

        // Guide cars to appropriate stations
        semaphore.guideCar(car1);
        semaphore.guideCar(car2);
        semaphore.guideCar(car3);

        // Serve all cars
        semaphore.serveAllCars();

        // Get stations
        CarStation electricStation = semaphore.getElectricCarStation();
        CarStation gasStation = semaphore.getGasCarStation();

        // Verify that all queues are empty after serving
        assertEquals(0, electricStation.getQueue().size());
        assertEquals(0, gasStation.getQueue().size());

        // Verify that cars were served correctly
        // Additional logic can be added to track the served stats
        assertTrue(electricStation.getQueue().isEmpty());
        assertTrue(gasStation.getQueue().isEmpty());
    }
}