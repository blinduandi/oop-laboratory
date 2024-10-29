public class Display {
    private int width;
    private int height;
    private float ppi;
    private String model;

    public Display(int width, int height, float ppi, String model) {
        this.width = width;
        this.height = height;
        this.ppi = ppi;
        this.model = model;
    }

    private void compareSize(Display m){
        int size = getHeight() * getWidth();
        int sizeCompare = m.getWidth()*m.getHeight();
        if(size == sizeCompare){
            System.out.println(getModel()+" screen sizes is equal with: "+m.getModel());
        }
        else if(size < sizeCompare){
            System.out.println(m.getModel()+" screen is bigger than: "+getModel());
        }
        else {
            System.out.println(m.getModel()+" screen is smaller than: "+getModel());
        }
    }
    private void compareSharpness(Display m){
        float curentPPI = getPpi();
        float comparePPI = m.getPpi();

        if (curentPPI == comparePPI) System.out.println(m.getModel()+" PPI is equal with"+getModel());
        else if(curentPPI < comparePPI) System.out.println( m.getModel()+" is sharper than: "+getModel());
        else System.out.println( getModel()+" is sharper than: "+m.getModel());
    }
    void compareWithMonitor(Display m){
        compareSharpness(m);
        compareSize(m);
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setPpi(float ppi) {
        this.ppi = ppi;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public float getPpi() {
        return ppi;
    }

    public String getModel() {
        return model;
    }

}
