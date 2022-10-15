package unimi_exercises.e01;

public class DrawChess {

    static void printSquare(String symbol, int n) {
        for (int j = 0; j<n; j++) {
            System.out.print(symbol);
        }
    }

    static void printRow(int n, boolean isFirstWhite) {
        for (int i = 0; i<4; i++) {
            if (isFirstWhite) {
                printSquare("-", n);
                printSquare("#", n);
            } else {
                printSquare("#", n);
                printSquare("-", n);
            }
        }
        System.out.println("");
    }

    static void printChess(int n) {
        for (int i = 0; i<4; i++) {
            for (int j = 0; j<n; j++) {
                printRow(n, true);
                
            }
            for (int j = 0; j<n; j++) {
                printRow(n, false);
            }
        }
    }
    public static void main(String[] args) {
        printChess(3);
    }
}
