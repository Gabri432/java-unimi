package unimi_exercises.prigioniero_exercises;


/*
 * DESCRIPTION: Implementing a class that will replicate the Tartaglia triangle.
 * NOTE: For more details check https://en.wikipedia.org/wiki/Pascal%27s_triangle.
 * 
 * LINK: https://github.com/lprigioniero/labprog/blob/master/esercizi/tartaglia/Testo.md
 * 
 */

public class Tartaglia {

    public static int[] sum(int[] numbers, int power) {
        if (power == 1) { //Base case.
            int[] res = {1};
            return res;
        }
        int[] outputNumbers = new int[numbers.length+1]; //Creating a new arry which will be one element longer.
        outputNumbers[0] = 1; //The first element of the array will always be 1.
        for (int i=0; i<numbers.length; i++) {
            if (i+1<numbers.length) {
                outputNumbers[i+1] = numbers[i] + numbers[i+1]; //Each number in the new array is the sum of the latest two from the previous.
            }
        }
        outputNumbers[outputNumbers.length-1] = 1; //The last element of the array will always be 1.
        power--; //Decrementing the amount of steps to take before ending the function.
        if (power > 1) {
            return sum(outputNumbers, power);
        }
        return outputNumbers;
    }

    public static void main(String[] args) {
        int power = Integer.parseInt(args[0]);
        int[] start = {1}; // the Tartaglia's triangle starts with only an array of one element.
        int[] result = sum(start, power);
        for (int i=0; i<result.length; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
        
    }
    
}

