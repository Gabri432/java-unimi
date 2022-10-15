package unimi_exercises.e01;

import java.util.Scanner;

public class Kaprekar {

    static int reorderNumber(int n) { 
        String oldNumber = Integer.toString(n);
        char[] numb = oldNumber.toCharArray();
        boolean cond1 = Integer.parseInt(numb[0] + "") > Integer.parseInt(numb[1] + ""); // checking if numb[0] > numb[1]
        if (!cond1) {
            char helper = numb[0]; numb[0] = numb[1]; numb[1] = helper; // switching position 0 with 1
        } 
        boolean cond2 = Integer.parseInt(numb[2] + "") > Integer.parseInt(numb[3] + ""); // checking if numb[2] > numb[3]
        if (!cond2) {
            char helper = numb[2]; numb[2] = numb[3]; numb[3] = helper; // switching position 2 with 3
        }
        boolean cond3 = Integer.parseInt(numb[0] + "") > Integer.parseInt(numb[2] + ""); // checking if numb[0] > numb[2]
        if (!cond3) {
            char helper = numb[0]; numb[0] = numb[2]; numb[2] = helper; // switching position 0 with 2
        }
        boolean cond4 = Integer.parseInt(numb[1] + "") > Integer.parseInt(numb[3] + ""); // checking if numb[1] > numb[3]
        if (!cond4) {
            char helper = numb[1]; numb[1] = numb[3]; numb[3] = helper; // switching position 1 with 3
        }
        boolean cond5 = Integer.parseInt(numb[1] + "") > Integer.parseInt(numb[2] + ""); // checking if numb[1] > numb[2]
        if (!cond5) {
            char helper = numb[1]; numb[1] = numb[2]; numb[2] = helper; // switching position 1 with 2
        }
        return Integer.parseInt(String.valueOf(numb));
    }

    static int reverseNumber(int n) {
        String nString = Integer.toString(n);
        char[] newString = {0, 0, 0, 0};
        int stringLength = nString.length();
        newString[0] = nString.charAt(stringLength-1);
        newString[1] = nString.charAt(stringLength-2);
        newString[2] = nString.charAt(stringLength-3);
        newString[3] = nString.charAt(stringLength-4);
        return Integer.parseInt(String.valueOf(newString));
    }


    static void printKaprekar(int n) {
        int ascendingNumber = reorderNumber(n);
        int descendingNumber = reverseNumber(ascendingNumber);
        if (ascendingNumber-descendingNumber == n) {
            return;
        }
        System.out.println(ascendingNumber-descendingNumber);
        printKaprekar(ascendingNumber-descendingNumber);
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter number");
        int number = myObj.nextInt();
        myObj.close();
        printKaprekar(number);
    }
    
}
