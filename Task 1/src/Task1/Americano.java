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

    public static String getName(){
        return name;
    }

    public int getMlOfWater(){
        return mlOfWater;
    }


}
