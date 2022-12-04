package unimi_exercises.prigioniero_exercises.battleship;
import java.util.HashMap;

/*
 * DESCRIPTION: This class will be part of a set of classes to create the game 'BattleShip'. 
 * 
 * LINK: https://github.com/lprigioniero/labprog/blob/master/esercizi/battaglia_navale_posizione/Testo.md
 * 
 */

public class Position {
    public final int row;
    public final int column;

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * It associates each letter in range A-J to an integer in range 0-9.
     * @return a map with string-integer associations.
     */
    public static HashMap<String, Integer> generateColumnHashMap() {
        HashMap<String, Integer> columnsHashMap = new HashMap<String, Integer>();
        columnsHashMap.put("A", 0);
        columnsHashMap.put("B", 1);
        columnsHashMap.put("C", 2);
        columnsHashMap.put("D", 3);
        columnsHashMap.put("E", 4);
        columnsHashMap.put("F", 5);
        columnsHashMap.put("G", 6);
        columnsHashMap.put("H", 7);
        columnsHashMap.put("I", 8);
        columnsHashMap.put("J", 9);
        return columnsHashMap;
        
    }

    /**
     * Given a position with this pattern [A-J][1-10], returns the corresponding Position class object.
     * @param position a String where the first character is a capital letter in range A-J (column) and an integer in range 1-10 (row).
     * @return the corresponding position, where column and row are integers in range 0-9.
     */
    public static Position parsePosition(String position) {
        int row = Integer.parseInt(position.substring(1)) - 1; //Example: input = B10 --> row = 10.
        HashMap<String, Integer> columnsHashMap = generateColumnHashMap();
        int column = columnsHashMap.get(position.substring(0, 1)); //Example: input = B10 --> column = 1.
        Position p = new Position(row, column);
        return p;
    }

    @Override
    public String toString() {
        return "("+ this.row + ", " + this.column + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (!(o instanceof Position)) {
            return false;
        }

        Position position = (Position) o;
        return Integer.compare(row, position.row) == 0 && Integer.compare(column, position.column) == 0;
    }
}