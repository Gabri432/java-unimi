package random_programs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
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
     * <li>ADD (int, int, string)</li>
     * <li>SUB (int, int, string)</li>
     * <li>MUL (int, int, string)</li>
     * <li>DIV (int, int, string)</li>
     * <li>ADD (int, string, string)</li>
     * <li>SUB (int, string, string)</li>
     * <li>MUL (int, string, string)</li>
     * <li>DIV (int, string, string)</li>
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
                if (commandArguments.size() != 1 || commandArguments.contains(null) || commandArguments.get(0).isEmpty()) {
                    throw new IllegalArgumentException("Need exactly 1 non-null and non-empty argument to run the command " + commandName + ".");
                }
                break;
                case "ADD", "SUB", "MUL", "DIV":
                if (commandArguments.size() != 3 || commandArguments.contains(null)) {
                    throw new IllegalArgumentException("At least 2 non-null arguments to run the command " + commandName + ".");
                }
                try {
                    Integer.parseInt(commandArguments.get(0));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("First argument must be integer for command " + commandName + ".");
                }
                break;
                case "PRINT":
                if (commandArguments.size() != 1 || commandArguments.contains(null) || commandArguments.get(0).isEmpty()) {
                    throw new IllegalArgumentException("Need exactly 1 non-null and non-empty argument to run the command " + commandName + ".");
                }
                break;
                case "LOG":
                if (commandArguments.size() > 1) {
                    throw new IllegalArgumentException("Expected at most 1 argument.");
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
        ArrayList<String> args = command.commandArguments;
        switch (command.commandName) {
            case "VAR":
            createVariable(command);
            break;
            case "ADD", "MUL", "SUB":
            try {
                integersOperations(Integer.parseInt(args.get(0)), Integer.parseInt(args.get(1)), args.get(2));
            } catch (NumberFormatException e) {
                integersOperations(Integer.parseInt(args.get(0)), args.get(1), args.get(2));
            }
            break;
            case "DIV":
            try {
                division(Integer.parseInt(args.get(0)), Integer.parseInt(args.get(1)), args.get(2));
            } catch (NumberFormatException e) {
                division(Integer.parseInt(args.get(0)), args.get(1), args.get(2));
            }
            break;
            case "PRINT":
            print(command.commandArguments.get(0));
            break;
            case "LOG":
            if (command.commandArguments.size() == 1) {
                log(Integer.parseInt(command.commandArguments.get(0)));
            } else {
                log();
            }
            break;
        }
    }

    /**
     * Creates a new variable given its name.
     * @param command the command containing the needed arguments.
     * @throws IllegalArgumentException if command argument isn't a string.
     */
    private void createVariable(Command command) {
        if (command.commandArguments.get(0).isEmpty()) throw new IllegalArgumentException("Variable name cannot be empty");
        ArrayList<String> args = command.commandArguments;
        localVariables.putIfAbsent(args.get(0), 0);
    }

    /**
     * Performs the operations of sum, substraction and multiplication and stores the result in a variable.
     * @param a an Integer.
     * @param b an Integer.
     * @param variableForStoring the variable where storing the result of the operation between a and b.
     */
    private void integersOperations(Integer a, Integer b, String variableForStoring) {
        if (!localVariables.containsKey(variableForStoring)) {
            throw new IllegalArgumentException("Variable "+ variableForStoring + " not defined.");
        }
        int result = a*b;
        localVariables.put(variableForStoring, result);
    }

    /**
     * Performs the operations of sum, substraction and multiplication and stores the result in a variable.
     * @param a an Integer.
     * @param variableValue a String representing a variable holding an integer.
     * @param variableForStoring the variable where storing the result of the operation between a and b.
     */
    private void integersOperations(Integer a, String variableValue, String variableForStoring) {
        if (!localVariables.containsKey(variableForStoring)) {
            throw new IllegalArgumentException("Variable "+ variableForStoring + " not defined.");
        }
        if (!localVariables.containsKey(variableValue)) {
            throw new IllegalArgumentException("Variable "+ variableValue + " not defined.");
        }
        int result = a*localVariables.get(variableValue);
        localVariables.put(variableForStoring, result);
    }

    /**
     * Performs the division between a and b, and stores the results in a variable.
     * @param a an Integer.
     * @param b an Integer.
     * @param variableForStoring the variable where storing the result of the division between a and b.
     */
    private void division(Integer a, Integer b, String variableForStoring) {
        if (!localVariables.containsKey(variableForStoring)) {
            throw new IllegalArgumentException("Variable "+ variableForStoring + " not defined.");
        }
        try {
            int result = a/b;
            localVariables.put(variableForStoring, result);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
    }

    /**
     * Performs the division between a and a variable containing an integer, and stores the results in a variable.
     * @param a an Integer.
     * @param variableValue a String representing a variable holding an integer. 
     * @param variableForStoring the variable where storing the result of the division between a and the variable value.
     */
    private void division(Integer a, String variableValue, String variableForStoring) {
        if (!localVariables.containsKey(variableForStoring)) {
            throw new IllegalArgumentException("Variable "+ variableForStoring + " not defined.");
        }
        if (!localVariables.containsKey(variableValue)) {
            throw new IllegalArgumentException("Variable "+ variableValue + " not defined.");
        }
        try {
            int result = a/localVariables.get(variableValue);
            localVariables.put(variableForStoring, result);
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException("Variable "+ variableValue + " is zero valued!");
        }
    }

    /**
     * Prints the value of the specified variable name.
     * @param variableName a String representing the variable to print.
     * @throws NullPointerException if the variable is null.
     */
    public void print(String variableName) {
        Objects.requireNonNull(variableName, "Cannot have a null variable.");
        if (!localVariables.containsKey(variableName)) throw new IllegalArgumentException("Variable "+ variableName +" not found.");
        System.out.println(localVariables.get(variableName));
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
