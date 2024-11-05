package Task1;

public class Cappuccino extends Coffee{
    private static final String name = "Cappuccino";
    private int mlOfMilk;
    public Cappuccino(Intensity intensity, int mlOfMilk){
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }

    public static String getName() {
        return name;
    }

    public int getMlOfMilk() {
        return mlOfMilk;
    }
}
