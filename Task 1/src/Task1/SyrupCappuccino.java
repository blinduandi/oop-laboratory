package Task1;

public class SyrupCappuccino extends Cappuccino{
    private static final String name = "SyrupCappuccino";
    private SyrupType syrup;

    public SyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup){
        super(intensity, mlOfMilk);
        this.syrup = syrup;
    }

    public static String getName(){
        return name;
    }

    public SyrupType getSyrup(){
        return syrup;
    }



}
