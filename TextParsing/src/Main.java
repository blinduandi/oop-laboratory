import java.io.File;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No paths provided!");
            return;
        }

        for (String arg : args) {
            String path = "./TextParsing/"+arg;
            System.out.println("Processing file: " + path);

            File filee = new File(path);
            if (!filee.exists()) {
                System.out.println("File does not exist: " + path);
                continue;
            }

            try {
                FileReader file = new FileReader(path);
                TextData text = new TextData(file.getData());

                String fileName = path.substring(path.lastIndexOf("/") + 1);
                text.setFileName(fileName);
                text.display();
            } catch (Exception e) {
                System.out.println("Error reading file at " + path + ": " + e.getMessage());
            }
        }
    }

}