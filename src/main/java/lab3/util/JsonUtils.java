package main.java.lab3.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.lab3.model.Car;

import java.io.IOException;

public class JsonUtils {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static Car parseCar(String json) throws IOException {
        return objectMapper.readValue(json, Car.class);
    }
}