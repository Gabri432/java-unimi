package unimi_exercises.e03;

import java.util.ArrayList;
import java.util.Scanner;

public class IntSet {
    ArrayList<Integer> elements;
    public static void main(String[] args) {
        IntSet mySet = new IntSet();
        mySet.size();
    }

    /** It asks the user to insert a new integer.
     * 
     * @return the user inserted integer.
     */
    public static int getInput() {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter number");
        int number = myObj.nextInt();
        myObj.close();
        return number;
    }

    /** It adds an integer to the list of integers of the class.
     * 
     * @param el an integer to add.
     */
    public void addElement(int el) {
        elements.add(el);
    }
    
    /** It removes an integer from the list of integers of the class.
     * 
     * @param el an integer to remove.
     * @exception Exception when the element does not exist.
     */
    public void removeElement(int el) {
        try {
            for (int i = 0; i<elements.size(); i++) {
                if (elements.indexOf(i) == el) {
                    elements.remove(i);
                    return;
                } 
            }
            throw new Exception("Could not delete element - non existing element.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /** It asks the user to insert the number to return from the list.
     * @return the required number.
     */
    public int choose() {
        try {
            if (elements.size() == 0) {
                throw new EmptyException("Cannot get element - the set is empty.");
            }
            int userInput = getInput();
            if (contains(userInput)) {
                return userInput;
            } 
        } catch (EmptyException e) {
            System.out.println(e);
        }
        System.out.println("Could not find the value, returning 0");
        return 0;
    }

    /** It counts the amount of items in the set.
     * 
     * @return the number of elements of the set.
     */
    public int size() {
        return elements.size();
    }

    /** It verifies if x is in the integer set. 
     * 
     * @param x the integer to find.
     * @return true when x is found, false otherwise.
     */
    public boolean contains(int x) {
        for (int i = 0; i<elements.size(); i++) {
            if (elements.indexOf(i) == x) {
                return true;
            } 
        }
        return false;
    }

    public String toString() {
        return "";
    }
}

class EmptyException extends Exception { // Creating a custom exception for handling access to an empty set
    public EmptyException(String s)
    {
        // Call constructor of parent Exception
        super(s);
    }
}