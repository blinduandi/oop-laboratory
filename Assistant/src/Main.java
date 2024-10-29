public class Main {
    public static void main(String[] args) {

        Assistant asist = new Assistant("Vasile");

        Display display1 = new Display(12,13,(float)55.3,"Samsung");
        Display display2 = new Display(14,12,(float)65.3,"LG");
        Display display3 = new Display(12,13,(float)75.3,"Akai");

        asist.assignDisplay(display1);
        asist.assignDisplay(display2);
        asist.assignDisplay(display3);

        asist.asist();

        System.out.println("******** \n\n");

        Display buyDisp = asist.selectDisplay();
        System.out.println("********  \n\n");
        asist.buyDisplay(buyDisp);
        System.out.println("********");


        System.out.println("Print to check that display was bought;");
        asist.selectDisplay();



    }
}