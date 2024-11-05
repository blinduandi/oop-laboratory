package Task1;

public class PumpkinSpiceLatte extends Coffee{
    private static final String name ="PumpkinSpiceLatte";
    private int mlOfMilk;
    private int mgOfPumpkinSpice;
    public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice){
        super(intensity);
        this.mlOfMilk = mlOfMilk;
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }

    @Override
    public PumpkinSpiceLatte makeCoffee() {
        System.out.println("~~~ Crafting Your Pumpkin Spice Latte ~~~");
        System.out.printf("1. Intensity Level: %s%n", getInetnisity());
        System.out.println("2. Espresso Shot: Brewed rich and strong");
        System.out.printf("3. Steaming Milk: %d ml with %d mg of pumpkin spice for a seasonal touch%n", mlOfMilk, mgOfPumpkinSpice);
        System.out.println("4. Blending spiced milk with espresso and adding a delicate foam layer");
        System.out.println(">>> Your Pumpkin Spice Latte is ready to enjoy! <<<");
        return this;
    }

    @Override
    public void printCoffeeDetails(String name) {
        super.printCoffeeDetails(this.name);
        System.out.println("Adding " + mlOfMilk + " ml of milk");
        System.out.println("Adding " + mgOfPumpkinSpice + " mg of pumpkin spice");
    }

    public static String getName(){
        return name;
    }

    public int getMlOfMilk(){
        return mlOfMilk;
    }

    public int getMgOfPumpkinSpice(){
        return mgOfPumpkinSpice;
    }

}
