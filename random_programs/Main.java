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
        ArrayList<String> myVarArgs = new ArrayList<>();
        myVarArgs.add("Hello");
        ArrayList<String> myAddArgs = new ArrayList<>();
        myAddArgs.add("Hello");
        myAddArgs.add("");
        myCommands.add(new Command("VAR", myVarArgs));
        myCommands.add(new Command("ADD", myAddArgs));
        CommandLine myCMD = new CommandLine(myCommands);
        System.out.println(myCMD);
        myCMD.execute();
    }
}
