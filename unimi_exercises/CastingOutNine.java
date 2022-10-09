package unimi_exercises;

public class CastingOutNine {
    static String numberToString(int numb) {
        return Integer.toString(numb);
    }

    /** It sums each digit of a number. 
     * @param numb an integer
     * @return the sum in form of string.
    */
    static String sumStringNumbers(String numb) {
        int sum = 0;
        for (int i = 0; i<numb.length(); i++) {
            sum += (Integer.parseInt(String.valueOf(numb.charAt(i))));
        }
        if (sum > 9) {
            return sumStringNumbers(numberToString(sum));
        }
        return numberToString(sum);
    }

    /** It sums two integers. 
     * @param numb1 an integer
     * @param numb2 another integer
     * @return the sum in form of string.
    */
    static String productIntegers(int numb1, int numb2) {
        return sumStringNumbers(numberToString(numb1*numb2));
    }

    /** It sums two strings of integers. 
     * @param numb1 an integer
     * @param numb2 another integer
     * @return the sum in form of string.
    */
    static String productStrings(String numb1, String numb2) {
        return sumStringNumbers(numberToString(Integer.parseInt(numb1)*Integer.parseInt(numb2)));
    }

    /** It checks if a set of factors passes the 'Casting out Nine' test but gives a wrong product. 
     * @param numb an integer, which will be the upper limit for the factors and the product.
     * 
    */
    public static void main(int numb) {
        for (int i = 2; i<numb; i++) {
            String a = sumStringNumbers(Integer.toString(i));
            for (int j = 2; j<numb; j++) {
                String b = sumStringNumbers(Integer.toString(j));
                String AxB = productStrings(a, b); 
                String c = productIntegers(i, j); 
                if (AxB.equals(c) && !c.equals(Integer.toString(i*j)) && Integer.parseInt(c) < numb) {
                    System.out.println(a + " " + b + " " + c);
                }
            }
        }
    }
}
