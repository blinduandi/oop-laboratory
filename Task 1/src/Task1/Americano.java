package Task1;

public class Americano extends Coffee{
    private static final String name = "Americano";
    private int mlOfWater;


    public Americano(Intensity intensity, int mlOfWater){
        super(intensity);
        this.mlOfWater = mlOfWater;
    }

    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Water: " + mlOfWater + " ml");
    }
    public Americano makeAmericano() {
        System.out.println("=== Americano Preparation ===");
        System.out.printf("1. Coffee Intensity: [%s]%n", getInetnisity());
        System.out.println("2. Coffee Grounds - Ready");
        System.out.println("3. Espresso Shot - Extracted");
        System.out.printf("4. Hot Water Added: %d ml%n", mlOfWater);
        System.out.println("=> Your Americano is now served. Enjoy!");
        return this;
    }


    public static String getName(){
        return name;
    }

    public int getMlOfWater(){
        return mlOfWater;
    }


}
