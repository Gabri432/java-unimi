package random_programs;

import java.util.ArrayList;

import random_programs.CommandLine.Command;

public class Main {
    public static void main(String[] args) {
        //System.out.println(transitiveRel());
        //System.out.println(reflexiveRel());
        //System.out.println(antisymmetricRel());

        //System.out.println(new TypoChecker());
        cmd();
    }

    static public RelationSet transitiveRel() {
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
        myCommands.add(generateCommand("SUB (myVar)"));
        myCommands.add(generateCommand("VAR (myVar)"));
        CommandLine myCMD = new CommandLine(myCommands);
        System.out.println(myCMD);
        myCMD.execute();
    }

    static public Command generateCommand(String command) {
        String[] commandDetails = command.split(" ", 2);
        String commandName = commandDetails[0];
        String[] commandArgs = commandDetails[1].replace("(", "s").replace(")", "").split(",");
        ArrayList<String> myArgs = new ArrayList<>();
        myArgs.add(commandArgs[0]);
        myArgs.add(commandArgs[1]);
        myArgs.add(commandArgs[2]);
        return new Command(commandName, myArgs);
    }
}
