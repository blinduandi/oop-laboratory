public class Main {
    public static void main(String[] args) {
        Display display1 = new Display(12,13,(float)55.3,"Samsung");
        Display display2 = new Display(14,12,(float)65.3,"LG");
        Display display3 = new Display(12,13,(float)75.3,"Akai");

        display1.compareWithMonitor(display2);
        display1.compareWithMonitor(display3);
        display2.compareWithMonitor(display3);
    }
}