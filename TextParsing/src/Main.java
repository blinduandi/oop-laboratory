public class Main {

    public static void main(String[] args) {
        String path = "";
        if(args.length>0) {
            path = args[0];
        }
        else{
            System.out.println("There is no provided path!");
            return;
        }
        path = "./"+path;
        System.out.println(path);

        FileReader file = new FileReader(path);

        TextData text = new TextData(file.getData());
       String fileName = path.substring(path.lastIndexOf("/") + 1);
       text.setFileName(fileName);
       text.display();
    }
}