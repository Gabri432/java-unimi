package unimi_exercises.t04;

import java.util.ArrayList;
import java.util.Scanner;

public class PrimeFactorization {

    public static ArrayList<Integer> factorize(int n) {
        ArrayList<Integer> factors = new ArrayList<Integer>(); //List of factors.
        int y = 2;    //The program starts dividing all numbers by 2, because every number can be divided by 1.
        while (n > 1) { //Keep dividing until the number is not 1.
            if (n % y == 0) {   //Checking if n can be divided by y.
                factors.add(y); //Append divisor to the list of factors.
                n = n/y;
                continue;  //Keep dividing with the same y.
            }
            y++;  //Incrementing the divisor only when the number can't be divided by the current one .
        }
        if (factors.size() == 0) { //If no divisor was found then the number is prime.
            factors.add(n);
        }
        return factors;
    }

    public static void iterateFactorization(int n) {
        for (int i = 2; i<=n; i++) { //Printing all factors from 2 to n.
            System.out.print(i);
            System.out.print(" => ");
            System.out.println(factorize(i));
        }
    }

    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter number");
        int number = myObj.nextInt();
        myObj.close();
        iterateFactorization(number);
    }
}