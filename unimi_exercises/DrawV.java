public class DrawV {

    static void printV(int n) {
        for (int i=0; i<n; i++) {
            for (int j=0; j<2*n-3-i; j++) { //2*n-3-i is the amout of spaces between the first and the second '*'
                if (i==j) { //the position of the starting '*'
                    System.out.print("*");
                }
                System.out.print(" ");
            }
            if (i==n-1) { //adding a new space when the program is at the last line
                System.out.print(" ");
            }
            System.out.println("*"); //printing the last '*' at the "end of the line" (which is the end of the cycle)
        }
    }

    public static void main(String[] args) {
        printV(5);
    }
}