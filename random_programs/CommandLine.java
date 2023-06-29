package random_programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import java.util.Objects;

/**
 * Concrete class representing a command line capable of executing the following actions:<br /><br/>
 * <ul>
 * <li> Performing mathematical operations (sum, substraction, multiplication and division between two integers).
 * <li> Printing strings. </li>
 * <li> List past commands. </li>
 * </ul>
 */
public class CommandLine {
    public final ArrayList<Command> commands;
    public Map<String, Integer> localVariables;

    /**
     * Concrete immutable class representing a command in the commandLine. The possible commands are: <br /><br/>
     * <ul>
     * <li>VAR (string)</li>
     * <li>ADD (int,int, string)</li>
     * <li>ADD (int, string)</li>
     * <li>SUB (int,int, string)</li>
     * <li>SUB (int, string)</li>
     * <li>MUL (int,int, string)</li>
     * <li>MUL (int, string)</li>
     * <li>DIV (int,int, string)</li>
     * <li>DIV (int, string)</li>
     * <li>PRINT (string)</li>
     * <li>LOG (int)</li>
     * <li>LOG</li>
     * </ul>
     */
    public class Command {
        public final String commandName;
        public final ArrayList<String> commandArguments;
        public ArrayList<Command> pastCommands;
        
        /**
         * Constructs a command based on the name and the needed arguments.
         * @param commandInstruction a String representing the name of the command.
         * @param commandArguments an ArrayList of strings representing the command arguments.
         * @throws NullPointerException if either commandName or commandArguments is null.
         * @throws IllegalArgumentException if either commandName or commandArguments is empty.
         */
        public Command(String commandName, ArrayList<String> commandArguments) {
            if (Objects.requireNonNull(commandName, "Cannot have null instructions.").isEmpty()) { 
                throw new IllegalArgumentException("Cannot have an empty string as instruction.");
            }
            if (Objects.requireNonNull(commandName, "Cannot have null instruction arguments.").isEmpty()) { 
                throw new IllegalArgumentException("Must have at least one instruction.");
            }
            checkCommands(commandName, commandArguments);
            this.commandName = commandName;
            this.commandArguments = new ArrayList<>(commandArguments);
        }

        /**
         * Checks if given a certain command name there is the proper amount of arguments to run it.
         * @param commandName a String representing the command name to run.
         * @param commandArguments an ArrayList of strings representing the needed arguments to run the command.
         * @throws IllegalArgumentException if the amount of command arguments isn't as expected for the command name.
         */
        private void checkCommands(String commandName, ArrayList<String> commandArguments) {
            switch (commandName) {
                case "VAR":
                if (commandArguments.size() != 1 || commandArguments.contains(null)) {
                    throw new IllegalArgumentException("Need exactly 1 non-null argument to run the command " + commandName + ".");
                }
                break;
                case "ADD", "SUB", "MUL", "DIV":
                if (commandArguments.size() < 2 || commandArguments.contains(null)) {
                    throw new IllegalArgumentException("At least 2 non-null arguments to run the command " + commandName + ".");
                }
                break;
                case "PRINT":
                if (commandArguments.size() != 1 || commandArguments.contains(null)) {
                    throw new IllegalArgumentException("Need exactly 1 non-null argument to run the command " + commandName + ".");
                }
                break;
            }
        }

        @Override
        public String toString() {
            return commandName + " "+ commandArguments;
        }
    }

    /**
     * Constructs a command line given the commands to execute.
     * @param commands an ArrayList of Command objects representing the commands to execute.
     * @throws NullPointerException if commands is null or contains a command with null name or null arguments.
     * @throws IllegalArgumentException if commands is empty or contains a command with empty name or empty arguments. 
     */
    public CommandLine(ArrayList<Command> commands) {
        if (Objects.requireNonNull(commands, "Cannot have a null array of commands.").isEmpty()) {
            throw new IllegalArgumentException("Cannot have an empty array of commands.");
        }
        ArrayList<Command> myCommands = new ArrayList<>();
        for (Command command : commands) {
            myCommands.add(new Command(command.commandName, command.commandArguments));   
        }
        this.commands = commands;
    }

    /**
     * Execute the command.
     * @param command the command to execute.
     * @throws IllegalArgumentException if command arguments aren't of the correct type.
     */
    public void execute(Command command) {
        switch (command.commandName) {
            case "VAR":
            createVariable(command);
            break;
            case "ADD", "MUL", "SUB":
            integersOperations(command);
            break;
            case "DIV":
            division(command);
            break;
            case "PRINT":
            print(command);
            break;
            case "LOG":
            break;
        }
    }

    /**
     * Creates a new variable given its name.
     * @param command the command containing the needed arguments.
     * @throws IllegalArgumentException if command argument isn't a string.
     */
    public void createVariable(Command command) {
        if (command.commandArguments.get(0).isEmpty()) throw new IllegalArgumentException("Variable name cannot be empty");
        ArrayList<String> args = command.commandArguments;
        localVariables.putIfAbsent(args.get(0), 0);
    }

    /**
     * Performs the sum, substraction, and multiplication and store the result in the command specified variable. 
     * @param command the command containing the needed arguments.
     * @throws IllegalArgumentException if there aren't integers for performing the operation, or the variable name was not defined.
     * @throws MissingArgumentException if the variable was not specified.
     */
    public void integersOperations(Command command) {
        ArrayList<String> args = command.commandArguments;
        try {
            int a = Integer.parseInt(args.get(0));
            int b = Integer.parseInt(args.get(1));
            String variable = command.commandArguments.get(2);
            if (!localVariables.containsKey(variable)) throw new IllegalArgumentException("Variable "+ variable +" not found.");
            localVariables.put(variable, a*b);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Arguments must be integers to execute "+ command.commandName + ".");
        } catch (IndexOutOfBoundsException e) {
            throw new MissingFormatArgumentException("Missing variable name to save the value.");
        }
    }

    /**
     * Performs the division and stores the result in the command specified variable.
     * @param command the command containing the needed arguments.
     * @throws IllegalArgumentException if there aren't integers for performing the operation, or the variable name was not defined.
     * @throws MissingArgumentException if the variable was not specified.
     */
    public void division(Command command) {
        ArrayList<String> args = command.commandArguments;
        try {
            int a = Integer.parseInt(args.get(0));
            int b = Integer.parseInt(args.get(1));
            if (b == 0) {
            throw new ArithmeticException("Cannot divide per zero.");
            }
            String variable = command.commandArguments.get(2);
            if (!localVariables.containsKey(variable)) throw new IllegalArgumentException("Variable "+ variable +" not found.");
            localVariables.put(variable, a*b);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Arguments must be integers to execute "+ command.commandName + ".");
        } catch (IndexOutOfBoundsException e) {
            throw new MissingFormatArgumentException("Missing variable name to save the value.");
        }
    }

    /**
     * Prints the value of the variable specified by the command.
     * @param command the command that contains the variable to print.
     * @throws NullPointerException if the variable is null.
     */
    public void print(Command command) {
        Objects.requireNonNull(command.commandArguments.get(0), "Cannot print null strings.");
        System.out.println(command.commandArguments.get(0));
    }

    /**
     * Prints the previous n commands starting from the most recent. 
     * @param n an Integer representing how many commands need to be printed.
     * @throws IllegalArgumentException if n is non-positive.
     */
    public void log(Integer n) {
        if (n < 1) throw new IllegalArgumentException("Must have positive integer to log commands.");
        int counter = 0;
        ArrayList<Command> copyCommands = this.commands;
        Collections.reverse(copyCommands);
        for (Command command : copyCommands) {
            if (counter > n) break;
            System.out.println(command);
        }
    }

    /**
     * Prints all the previous commands starting from the most recent. 
     */
    public void log() {
        ArrayList<Command> copyCommands = this.commands;
        Collections.reverse(copyCommands);
        for (Command command : copyCommands) {
            System.out.println(command);
        }
    }
    
}
