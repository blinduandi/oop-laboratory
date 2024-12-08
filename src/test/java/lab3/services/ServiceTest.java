package test.java.lab3.services;


import main.java.lab3.service.*;
import org.junit.jupiter.api.Test;

class ServiceTest {

    @Test
    void testPeopleDinner() {
        Dineable peopleDinner = new PeopleDinner();
        String carId = "1";

        // Verify behavior via system output
        System.out.println("Test: PeopleDinner");
        peopleDinner.serveDinner(carId);
    }

    @Test
    void testRobotDinner() {
        Dineable robotDinner = new RobotDinner();
        String carId = "2";

        // Verify behavior via system output
        System.out.println("Test: RobotDinner");
        robotDinner.serveDinner(carId);
    }

    @Test
    void testElectricStation() {
        Refuelable electricStation = new ElectricStation();
        String carId = "3";

        // Verify behavior via system output
        System.out.println("Test: ElectricStation");
        electricStation.refuel(carId);
    }

    @Test
    void testGasStation() {
        Refuelable gasStation = new GasStation();
        String carId = "4";

        // Verify behavior via system output
        System.out.println("Test: GasStation");
        gasStation.refuel(carId);
    }
}