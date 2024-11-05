package Task1;

public class Coffee{
    private Intensity intensity;
    private static final String name = "Coffee";

    public Coffee(Intensity intensity) {
        this.intensity = intensity;
    }
    public Coffee makeCoffee() {
        System.out.println("~ Coffee Preparation: " + name + " ~");
        System.out.printf(" - Bean Intensity: %s%n", intensity);
        System.out.println(" - Grinding beans and brewing coffee");
        System.out.println(" - Pouring freshly brewed coffee into your cup");
        System.out.println("=> Your " + name + " is ready to enjoy!");
        return this;
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
