package main.java.lab3.service;

public class GasStation implements Refuelable {
    @Override
    public void refuel(String carId) {
        System.out.println("Refueling gas car " + carId + ".");
    }
}