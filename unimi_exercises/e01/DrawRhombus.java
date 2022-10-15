package unimi_exercises.e01;

import java.util.Scanner;

public class DrawRhombus {

    static void printSingleLine(int n, int i) { // Prints a specific amount of spaces and stars
        for (int j = 0; j<n; j++) {
            System.out.print(" ");
        }
        for (int k = 0; k<i; k++) {
            System.out.print("*");
        }
    }

    static void printRhombus(int n) {
        for (int i = 0; i<n; i++) {  // Printing the upper half of the rhombus
            printSingleLine(n-i, 2*i+1);
            System.out.println("");
        }
        for (int i = n; i>=0; i--) {  // Printing the lower half of the rhombus
            printSingleLine(n-i, 2*i+1);
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter number");
        int number = myObj.nextInt();
        myObj.close();
        printRhombus(number);
    }
    
}
