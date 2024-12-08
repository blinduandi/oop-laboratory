package main.java.lab3.model;

public class Car {
    private String id;
    private String type; // ELECTRIC, GAS
    private String passengers; // PEOPLE, ROBOTS
    private boolean isDining;

    public Car(String id, String type, String passengers, boolean isDining) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getPassengers() {
        return passengers;
    }

    public boolean isDining() {
        return isDining;
    }
}