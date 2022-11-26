package unimi_exercises.prigioniero_exercises;

/*
 * DESCRIPTION: The class will calculate how many days are needed to save enough money to overcome a specific cost.
 * 
 * EXPECTED INPUT: A set of integers where:
 *                 - the first one is the object cost;
 *                 - followed by a sequence of integers representing daily savings;
 *                 - ended by zero. 
 * 
 * REPOSITORY LINK: https://github.com/lprigioniero/labprog/blob/master/esercizi/abbastanza_risparmi/Testo.md
 */
public class EnoughSavings {
    
    public static void main(String[] args) { //example: 10 1 1 3 4 6 9 0. 
        int objCost = Integer.parseInt(args[0]);
        int days = 0;
        if (args.length < 3) { //example: 1 0, which means the input contains only the cost of the object, that is, 1.
            System.out.println(days);
            return;
        }
        for (int i = 1; i<args.length; i++) {
            objCost -= Integer.parseInt(args[i]);
            days++;
            if (objCost <= 0) { //the loop stops the moment the sum of the daily savings overcomes the object cost.
                break;
            } 
        }
        if (objCost > 0) { //if after substracting all the daily savings the object cost is still positive.
            System.out.println(0);
        } else {
            System.out.println(days);
        }
        
    }
}
