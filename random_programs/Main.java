package random_programs;

//import java.util.ArrayList;

//import random_programs.CommandLine.Command;
//import random_programs.Fridge;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println(transitiveRel());
        //System.out.println(reflexiveRel());
        //System.out.println(antisymmetricRel());

        //System.out.println(new TypoChecker());
        //cmd();
        tryFridgeProgram();
    }

    /**static public RelationSet transitiveRel() {
        RelationSet myRelationSet = new RelationSet();
        myRelationSet.addRelation(1, 2);
        myRelationSet.addRelation(2, 3);
        myRelationSet.addRelation(1, 3);
        return myRelationSet;
    }

    static public RelationSet reflexiveRel() {
        RelationSet myRelationSet = new RelationSet();
        myRelationSet.addRelation(1, 1);
        myRelationSet.addRelation(2, 2);
        myRelationSet.addRelation(3, 3);
        myRelationSet.addRelation(4, 4);
        return myRelationSet;
    }

    static public RelationSet antisymmetricRel() {
        RelationSet myRelationSet = new RelationSet();
        myRelationSet.addRelation(1, 2);
        myRelationSet.addRelation(2, 2);
        myRelationSet.addRelation(3, 1);
        myRelationSet.addRelation(4, 4);
        return myRelationSet;
    }

    static public void cmd() {
        ArrayList<Command> myCommands = new ArrayList<>();
        myCommands.add(generateCommand("VAR (myVar)"));
        myCommands.add(generateCommand("PRINT (myVar)"));
        myCommands.add(generateCommand("ADD (3,6,myVar)"));
        myCommands.add(generateCommand("PRINT (myVar)"));
        myCommands.add(generateCommand("SUB (2,myVar,myVar)"));
        myCommands.add(generateCommand("LOG (0)"));
        CommandLine myCMD = new CommandLine(myCommands);
        myCMD.execute();
        System.out.println(myCMD.localVariables);
    }

    static public Command generateCommand(String command) {
        String[] commandDetails = command.split(" ", 2);
        String commandName = commandDetails[0];
        String[] commandArgs = commandDetails[1].replace("(", "").replace(")", "").split(",");
        ArrayList<String> myArgs = new ArrayList<>();
        myArgs.add(commandArgs[0]);
        if (commandArgs.length > 1) myArgs.add(commandArgs[1]);
        if (commandArgs.length > 2) myArgs.add(commandArgs[2]);
        return new Command(commandName, myArgs);
    }**/

    static public void tryFridgeProgram() {
        try {
            File file = new File("random_programs\\text_files\\Fridge.text");
            Scanner sc = new Scanner(file);
            Fridge myFridge = new Fridge();
            while (sc.hasNextLine()) {
                //String s = Arrays.toString(sc.nextLine().split(","));
                String[] line = sc.nextLine().split(",");
                myFridge.addItem(line[0], line[1], Integer.parseInt(line[2]));
                //System.out.println(s.length());
            }
            System.out.println(myFridge);
            myFridge.listExpiredItems();
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not find your file");
        }
    }
}
