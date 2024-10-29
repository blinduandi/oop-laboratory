import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    private String data;
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

     FileReader(String path){
        try{
            File file = new File(path);
            Scanner scann = new Scanner(file);
            while (scann.hasNextLine()){
                data = scann.nextLine();
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred reading the file."+e);
            System.exit(0);
        }
    }
}
