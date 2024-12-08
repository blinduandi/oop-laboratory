package main.java.lab3.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Car {
    private String id;
    private String type; // ELECTRIC, GAS
    private String passengers; // PEOPLE, ROBOTS
    @JsonProperty("isDining")
    private boolean isDining;
    private int consumption;
    public Car() {
    }
    public Car(String id, String type, String passengers, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
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
    public int getConsumption() {
        return consumption;
    }

    public void setConsumption(int consumption) {
        this.consumption = consumption;
    }
}