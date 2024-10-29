import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Assistant {
    private String assistantName;
    private List<Display> assignedDisplays = new ArrayList<>();

    void assignDisplay(Display d){
        assignedDisplays.add(d);
    }


    Display selectDisplay() {
        System.out.println("Select a display to buy:");

        for (int i = 0; i < assignedDisplays.size(); i++) {
            Display display = assignedDisplays.get(i);
            System.out.println((i + 1) + ": Model: " + display.getModel()
                    + ", Width: " + display.getWidth()
                    + ", Height: " + display.getHeight()
                    + ", PPI: " + display.getPpi());
        }

        Scanner scanner = new Scanner(System.in);
        int selection = -1;

        while (selection < 1 || selection > assignedDisplays.size()) {
            System.out.print("Enter the number of the display you want to select: ");
            if (scanner.hasNextInt()) {
                selection = scanner.nextInt();
                if (selection < 1 || selection > assignedDisplays.size()) {
                    System.out.println("Invalid selection. Please choose a number between 1 and " + assignedDisplays.size());
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Clear invalid input
            }
        }

        Display selectedDisplay = assignedDisplays.get(selection - 1); // Adjust for 0-based index
        System.out.println("Selected display: Model: " + selectedDisplay.getModel()
                + ", Width: " + selectedDisplay.getWidth()
                + ", Height: " + selectedDisplay.getHeight()
                + ", PPI: " + selectedDisplay.getPpi());

        return selectedDisplay;
    }


    Display buyDisplay(Display d){
        if (assignedDisplays.remove(d)) {
            System.out.println("Bought and removed display!");
        } else {
            System.out.println("Display not found in the list.");
        }
        return d;
    }

    void asist(){
        for (int i = 0; i < assignedDisplays.size(); i++) {
            for (int j = i + 1; j < assignedDisplays.size(); j++) {
                Display display1 = assignedDisplays.get(i);
                Display display2 = assignedDisplays.get(j);
                display1.compareWithMonitor(display2);
            }
        }

    }


    public Assistant(String assistantName) {
        this.assistantName = assistantName;
    }
    public String getAssistantName() {
        return assistantName;
    }

    public void setAssistantName(String assistantName) {
        this.assistantName = assistantName;
    }

    public List<Display> getAssignedDisplays() {
        return assignedDisplays;
    }

    public void setAssignedDisplays(List<Display> assignedDisplays) {
        this.assignedDisplays = assignedDisplays;
    }
}
