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
    public void printCoffeeDetails() {
        super.printCoffeeDetails();
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
