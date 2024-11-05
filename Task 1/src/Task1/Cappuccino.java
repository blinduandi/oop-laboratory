package Task1;

public class Cappuccino extends Coffee{
    private static final String name = "Cappuccino";
    private int mlOfMilk;
    public Cappuccino(Intensity intensity, int mlOfMilk){
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }
    public Cappuccino makeCappuccino() {
        System.out.println(">> Preparing a Classic Cappuccino <<");
        System.out.printf(" - Coffee Bean Intensity Level: %s%n", getInetnisity());
        System.out.println(" - Espresso Shot: Brewed to perfection");
        System.out.printf(" - Milk Steamed: %d ml, achieving creamy texture%n", mlOfMilk);
        System.out.println(" - Combining espresso with steamed milk and adding a layer of foam");
        System.out.println("=> Your Cappuccino is now ready to enjoy!");
        return this;
    }


    @Override
    public void printCoffeeDetails() {
        super.printCoffeeDetails();;
        System.out.println("Milk: " + mlOfMilk + "ml");
    }
    public static String getName() {
        return name;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }
}
