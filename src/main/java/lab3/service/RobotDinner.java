package main.java.lab3.service;

public class RobotDinner implements Dineable {
    @Override
    public void serveDinner(String carId) {
        System.out.println("Serving dinner to robots in car " + carId + ".");
    }
}