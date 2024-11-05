package Task1;

public class Coffee{
    private Intensity intensity;
    private static final String name = "Coffee";

    public Coffee(Intensity intensity) {
        this.intensity = intensity;
    }

    public static String getName() {
        return name;
    }

    public Intensity getInetnisity() {
        return intensity;
    }

    public void printCoffeeDetails() {
        System.out.println("Coffe type:  " + name);
        System.out.println("Intensity: " + intensity);
    }

}