package main.java.lab3.schedule;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.lab3.model.Car;
import main.java.lab3.queue.BasicQueue;
import main.java.lab3.service.ElectricStation;
import main.java.lab3.service.GasStation;
import main.java.lab3.service.PeopleDinner;
import main.java.lab3.service.RobotDinner;
import main.java.lab3.station.CarStation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    private static final int PROCESSING_INTERVAL_SEC = 2; // Interval for adding cars
    private static final int SERVING_INTERVAL_SEC = 5;    // Interval for serving cars
    private static final String QUEUE_DIR = "src/main/java/lab3/InputData";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static CarStation electricStation;
    private static CarStation gasStation;
    private static ScheduledExecutorService scheduler;
    private static boolean keepRunning = true;

    public static void main(String[] args) {
        // Initialize car stations with queues
        electricStation = new CarStation(new PeopleDinner(), new ElectricStation(), new BasicQueue<>());
        gasStation = new CarStation(new RobotDinner(), new GasStation(), new BasicQueue<>());

        scheduler = Executors.newScheduledThreadPool(2);

        // Task to read files from the queue
        scheduler.scheduleAtFixedRate(Scheduler::processCarsFromQueue, 0, PROCESSING_INTERVAL_SEC, TimeUnit.SECONDS);

        // Task to serve cars
        scheduler.scheduleAtFixedRate(() -> {
            System.out.println("=== Serving electric cars ===");
            electricStation.serveCars(); // Now works as expected
            System.out.println("=== Serving gas cars ===");
            gasStation.serveCars(); // Now works as expected

            // Check if everything is done and stop the scheduler
            if (electricStation.isEmpty() && gasStation.isEmpty() && queueIsEmpty()) {
                keepRunning = false;
                scheduler.shutdown();
                printFinalSummary();
            }
        }, 0, SERVING_INTERVAL_SEC, TimeUnit.SECONDS);


        // Add a shutdown hook for clean termination
        Runtime.getRuntime().addShutdownHook(new Thread(Scheduler::shutdownScheduler));
    }

    private static void processCarsFromQueue() {
        if (!keepRunning) return;

        File queueDir = new File(QUEUE_DIR);
        if (!queueDir.exists() || !queueDir.isDirectory()) {
            System.out.println("Queue directory does not exist: " + QUEUE_DIR);
            keepRunning = false;
            return;
        }

        File[] files = queueDir.listFiles((dir, name) -> name.endsWith(".json"));

        if (files == null || files.length == 0) {
            System.out.println("No files to process in the queue.");
            return;
        }

        for (File file : files) {
            try {
                // Read and parse JSON file
                String content = Files.readString(Paths.get(file.getPath()));
                Car car = objectMapper.readValue(content, Car.class);

                // Assign car to the appropriate station
                if (car.getType().equalsIgnoreCase("ELECTRIC")) {
                    electricStation.addCar(car);
                } else if (car.getType().equalsIgnoreCase("GAS")) {
                    gasStation.addCar(car);
                }

                // Delete file after successful processing
                Files.delete(file.toPath());
                System.out.println("Processed file: " + file.getName());
            } catch (IOException e) {
                System.err.println("Failed to process file: " + file.getName());
                e.printStackTrace();
            }
        }
    }

    private static boolean queueIsEmpty() {
        File queueDir = new File(QUEUE_DIR);
        File[] files = queueDir.listFiles((dir, name) -> name.endsWith(".json"));
        return files == null || files.length == 0;
    }

    private static void shutdownScheduler() {
        System.out.println("Shutting down scheduler...");
        keepRunning = false;
        scheduler.shutdown();
        try {
            if (!scheduler.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Forcing shutdown...");
                scheduler.shutdownNow();
            }
        } catch (InterruptedException e) {
            scheduler.shutdownNow();
        }
       // printFinalSummary();
    }

    public static void printFinalSummary() {
        System.out.println("\nFinal Summary:");
        System.out.println("{");
        System.out.println("  \"ELECTRIC\": " + electricStation.getCarsServed() + ",");
        System.out.println("  \"GAS\": " + gasStation.getCarsServed() + ",");
        System.out.println("  \"PEOPLE\": " + (electricStation.getPeopleFed() + gasStation.getPeopleFed()) + ",");
        System.out.println("  \"ROBOTS\": " + (gasStation.getRobotsFed() + electricStation.getRobotsFed()) + ",");
        System.out.println("  \"DINING\": " + (electricStation.getDiningCars() + gasStation.getDiningCars()) + ",");
        System.out.println("  \"NOT_DINING\": " + (electricStation.getNonDiningCars() + gasStation.getNonDiningCars()) + ",");
        System.out.println("  \"CONSUMPTION\": {");
        System.out.println("    \"ELECTRIC\": " + electricStation.getTotalConsumption() + ",");
        System.out.println("    \"GAS\": " + gasStation.getTotalConsumption());
        System.out.println("  }");
        System.out.println("}");
    }
}
