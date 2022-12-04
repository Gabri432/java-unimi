package unimi_exercises.prigioniero_exercises.battleship;

import java.util.HashMap;

/*
 * DESCRIPTION: This class will be part of a set of classes to create the game 'BattleShip'.
 * NOTE: You should first take a look at the 'Position' class to better understand the 'Ship' class. 
 * 
 * LINK: https://github.com/lprigioniero/labprog/blob/master/esercizi/battaglia_navale_nave/Testo.md
 * 
 */

public class Ship {
    public final Position start;
    public final int length;
    public final boolean isHorizontal; //if true then is horizontal, vertical otherwise.
    public HashMap<Position, Boolean> shipPositionsMap = new HashMap<Position, Boolean>(); //Record of each ship position and if it has been hit.

    public Ship(Position start, int length, boolean isHorizontal) {
        this.start = start;
        this.length = length;
        this.isHorizontal = isHorizontal;

        for (int i = 0; i<length; i++) { //Marking each ship position.
            Position p = new Position(0, 0);
            if (isHorizontal) {
                p = new Position(start.row, start.column+i);
            } else {
                p = new Position(start.row+i, start.column);
            }
            shipPositionsMap.put(p, false); //At the beginning of the game no ship position has been hit.
        }
    }

    /**
     * <p> Given colon separated ship starting position, length and orientation, returns the corresponding Ship class object.
     * @param ship a String with this pattern: "<strong>[A-J][1-10]:[1-10]:[O ? V]</strong>". </p>
     * <p> Example: "C1:6:V".</p>
     * @return the corresponding ship, where column and row are integers in range 0-9.
     */
    public static Ship parseShip(String ship) {
        String[] data = ship.split(":");
        Position p = Position.parsePosition(data[0]);
        int length = Integer.parseInt(data[1]);
        boolean isHorizontal = (data[2].equals("O")) ? true : false; //"O" returns true, "V" (otherwise) returns false.
        return new Ship(p, length, isHorizontal);
    }

    /**
     * <p>It tells if the given position is occupied by the ship.</p>
     * @param position a Position class object, which represents the position where to check for the ship.
     * @return true if the given position matches the location of the ship, false otherwise.
     */
    public boolean occupy(Position position) {
        for (Position shipPosition: shipPositionsMap.keySet()) {
            if (shipPosition.equals(position)) {
                return true;
            }
        }
        return false; //Checking if the given position matches a key (therefore if that position is occupied by the ship).
    }

    /**
     * If the given position is occupied by the ship then that ship position will be marked as hit.
     * @param position a Position class object that indicates which position will be hit.
     */
    public void hit(Position position) {
        if (occupy(position)) {
            shipPositionsMap.put(position, true);
        }
    }

    /**
     * It tells if at the given position the ship was hit or not.
     * @param position a Position class object that indicates which position to search.
     * @return true if that position was marked as hit, false otherwise.
     */
    public boolean isHit(Position position) {
        for (Position pos : shipPositionsMap.keySet()) {
            if (pos.equals(position) && shipPositionsMap.get(pos) == true) {
                return true;
            }
        }
        return false;
    }

    /**
     * It tells if the ship has sunk.
     * @return true if it is, false otherwise.
     */
    public boolean hasSunk() {
        for (boolean hit : shipPositionsMap.values()) {
            if (!hit) { //If at least one position is marked as false (so it has never been hit) then return false.
                return false;
            }
        }
        return true;
    }

    /**
     * It tells if this ship and the given one are occupying the same position or not.
     * @param ship a Ship class object.
     * @return true if they are overlapping, false otherwise.
     */
    public boolean intersecates(Ship ship) {
        for (Position position : ship.shipPositionsMap.keySet()) {
            if (occupy(position)) {  
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String myString = start + "\n";
        for (int i = 0; i<length; i++) {
            myString += "#";
            if (!isHorizontal && i<length-1) { //length-1 is just for graphical porpuse, so that there will be no space between ships when printing them.
                myString += "\n";
            } 
        }
        return myString;
    }
}
