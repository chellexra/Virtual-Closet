package ui;

import model.*;
import org.json.JSONObject;
import persistence.JsonReader;
import persistence.JsonWriter;
import persistence.Writable;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;
//import java.sql.SQLOutput;
import java.util.Scanner;

//FitInApp class represents main application class for managing virtual closet outfits
//In this class, users can add, view, and remove outfits, as well as view outfits by season
public class FitInApp {
    private static final String JSON_STORE = "./data/virtualCloset.json";
    private Scanner input;
    private VirtualCloset virtualCloset;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    // EFFECTS: constructs virtualcloset runs the FitIn application
    public FitInApp() throws FileNotFoundException {
        input = new Scanner(System.in);
        virtualCloset = new VirtualCloset(new ArrayList<>());
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    //Method taken from TellerApp
    //https://github.students.cs.ubc.ca/CPSC210/TellerApp/blob/main/src/main/ca/ubc/cpsc210/bank/ui/TellerApp.java
    //MODIFIES: this
    //EFFECTS: processes user input
    private void runFitin() {
        boolean keepGoing = true;
        String command = null;
        input = new Scanner(System.in);

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("\nYou Look great, see you later!");
    }

    //Method taken from TellerApp
    //https://github.students.cs.ubc.ca/CPSC210/TellerApp/blob/main/src/main/ca/ubc/cpsc210/bank/ui/TellerApp.java
    //MODIFIES: this
    //EFFECTS: process user command
    private void processCommand(String command) {
        if (command.equals("a")) {
            addOutfit();
        } else if (command.equals("v")) {
            viewAllOutfits();
        } else if (command.equals("r")) {
            removeOutfit();
        } else if (command.equals("o")) {
            viewOutfitsBySeason();
        } else if (command.equals("s")) {
            saveVirtualCloset();
        } else if (command.equals("l")) {
            loadVirtualCloset();
        } else {
            System.out.println("Selection invalid... Select inputs a, v or r");
        }
    }

    //Method taken from TellerApp
    //https://github.students.cs.ubc.ca/CPSC210/TellerApp/blob/main/src/main/ca/ubc/cpsc210/bank/ui/TellerApp.java
    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\nSelect from:");
        System.out.println("\ta -> add Outfit to closet");
        System.out.println("\tr -> remove Outfit from closet");
        System.out.println("\tv -> view all my outfits");
        System.out.println("\to -> view all my outfits by season");
        System.out.println("\ts -> save virtual closet to file");
        System.out.println("\tl -> load virtual closet from file");
        System.out.println("\tq -> quit application");
    }

    //EFFECTS: Add clothing articles to a collection (outfit)
    public void addOutfit() {
        System.out.println("Enter top color:");
        String topColor = input.next();

        System.out.println("Enter top style:");
        String topStyle = input.next();

        Tops top = new Tops(topColor, topStyle);

        System.out.println("Enter bottom color:");
        String bottomColor = input.next();

        System.out.println("Enter bottom style:");
        String bottomStyle = input.next();

        Bottoms bottom = new Bottoms(bottomColor, bottomStyle);

        System.out.println("Enter shoe color:");
        String shoeColor = input.next();

        System.out.println("Enter shoe style:");
        String shoeStyle = input.next();

        Shoes shoe = new Shoes(shoeColor, shoeStyle);

        System.out.println("Enter season:");
        String season = input.next();

        Outfit outfit = new Outfit(top, bottom, shoe, season);
        this.virtualCloset.addOutfit(outfit);
        System.out.println("Outfit was successfully created");
    }

    //Effects: adds outfit to virtual closet
    public void addOutfit(Outfit outfit) {
        this.virtualCloset.addOutfit(outfit);
    }

    //EFFECTS: Allows users to view all created outfits in the virtual closet
    public void viewAllOutfits() {
        List<Outfit> outfits = this.virtualCloset.getAllOutfits();
        printOutfits(outfits);
    }

    //EFFECTS: allows users to get a virtualCloset
    public VirtualCloset getVirtualCloset() {
        return this.virtualCloset;
    }

    //REQUIRES: closet outfits that are added in the closet must be >0
    //EFFECTS: removes selected outfit from the virtual closet
    public void removeOutfit() {
        System.out.println("Select the outfit you would like to remove");
        List<Outfit> outfits = this.virtualCloset.getAllOutfits();
        for (int i = 0; i < outfits.size(); i++) {
            Outfit outfit = outfits.get(i);
            String topColor = outfit.getTop().getColor();
            String bottomColor = outfit.getBottom().getColor();
            String shoesColor = outfit.getShoes().getColor();
            String topType = outfit.getTop().getType();
            String bottomType = outfit.getTop().getType();
            String shoesType = outfit.getShoes().getType();
            System.out.println("#" + i + " " + topColor + " " + topType + " " + bottomColor + " " + bottomType + " "
                    + topType + " " + shoesColor + " " + shoesType);
        }
        String index = input.next();
        this.virtualCloset.removeOutfit(Integer.parseInt(index));
        System.out.println("The outfit was removed successfully.");

    }

    //REQUIRES: inputted season must be options [1-4]
    //EFFECTS: Allows users to view printed outfits based on inputted season.
    //          if inputted number is 1, produce all outfits with the outfit season "Winter"
    //          else if inputted number is 2,produce all outfits with the outfit season "Spring"
    //          else if inputted number is 3,produce all outfits with the outfit season "Summer"
    //          otherwise produce all outfits with the outfit season "Fall"
    public void viewOutfitsBySeason() {
        System.out.println("Select the season of outfits you would like to view");
        System.out.println("[1] Winter");
        System.out.println("[2] Spring");
        System.out.println("[3] Summer");
        System.out.println("[4] Fall");

        String seasonNum = input.next();
        List<Outfit> seasonalOutfits;

        if (seasonNum.equals("1")) {
            seasonalOutfits = this.virtualCloset.getOutfitsBySeason("Winter");
        } else if (seasonNum.equals("2")) {
            seasonalOutfits = this.virtualCloset.getOutfitsBySeason("Spring");
        } else if (seasonNum.equals("3")) {
            seasonalOutfits = this.virtualCloset.getOutfitsBySeason("Summer");
        } else {
            seasonalOutfits = this.virtualCloset.getOutfitsBySeason("Fall");
        }
        printOutfits(seasonalOutfits);
    }

    //EFFECTS:prints the outfits created
    public void printOutfits(List<Outfit> outfits) {
        for (Outfit outfit : outfits) {
            String topColor = outfit.getTop().getColor();
            String topType = outfit.getTop().getType();
            String bottomColor = outfit.getBottom().getColor();
            String bottomType = outfit.getBottom().getType();
            String shoesColor = outfit.getShoes().getColor();
            String shoesType = outfit.getShoes().getType();
            String season = outfit.getSeason();
            System.out.println(topColor + " " + topType + " " + bottomColor + " " + bottomType + " "
                    + shoesColor + " " + shoesType + " " + season);
        }
    }

    // Referenced from JsonSerializationDemo
    // EFFECTS: saves the virtualCloset to file
    public void saveVirtualCloset() {
        try {
            jsonWriter.open();
            jsonWriter.write(virtualCloset);
            jsonWriter.close();
//            System.out.println("Saved " + virtualCloset.getAllOutfits() + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
        EventLog.getInstance().logEvent(new Event("Saved " + virtualCloset.getAllOutfits()
                + "from" + JSON_STORE));
    }

    // Referenced from JsonSerializationDemo
    // MODIFIES: this
    // EFFECTS: loads virtualCloset from file
    public void loadVirtualCloset() {
        try {
            virtualCloset = jsonReader.read();
//            System.out.println("Loaded " + virtualCloset.getAllOutfits() + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
        EventLog.getInstance().logEvent(new Event("Loaded " + virtualCloset.getAllOutfits()
                + "from" + JSON_STORE));
    }

}
