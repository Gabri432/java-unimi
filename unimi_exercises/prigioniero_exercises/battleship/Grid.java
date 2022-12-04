package unimi_exercises.prigioniero_exercises.battleship;

import java.util.ArrayList;

/*
 * DESCRIPTION: This class will be part of a set of classes to create the game 'BattleShip'.
 * NOTE: You should first take a look at the 'Position' and 'Ship' classes to better undestand the 'Grid' class. 
 * 
 * LINK: https://github.com/lprigioniero/labprog/blob/master/esercizi/battaglia_navale_griglia/Testo.md
 * 
 */

public class Grid {

    public ArrayList<Ship> fleet; //Record of all the ships in the grid.

    /**
     * It adds a new ship to the game grid, as long as its position does not overlap with the one of another ship.
     * @param newShip a Ship class object.
     * @return true if it added the ship successfully, false otherwise.
     */
    public boolean add(Ship newShip) {
        for (Ship ship : fleet) {
            if (ship.intersecates(newShip)) {
                return false;
            }
        }
        fleet.add(newShip);
        return true;
    }

    /**
     * It tells if the given position is already occupied by another ship on the grid.
     * @param position a Position class object, where to look for a ship.
     * @return true if that position was ship-free, false otherwise.
     */
    public boolean occupied(Position position) {
        for (Ship ship : fleet) {
            if (ship.occupy(position)) {
                return true;
            }
        }
        return false;
    }

    /**
     * It hits a ship if it is occupying the given position.
     * @param position a Position class object, that will be the position to hit.
     */
    public void hit(Position position) {
        for (Ship ship : fleet) {
            ship.hit(position);
        }
    }

    /**
     * It tells if at the given position a ship has been already hit.
     * @param position a Position class object, that is the position of the grid to look for.
     * @return true if a ship has been hit at the given position, false otherwise.
     */
    public boolean isHit(Position position) {
        for (Ship ship : fleet) {
            if (ship.isHit(position)) {
                return true;
            }
        }
        return false;
    }

    /**
     * It tells if at the given position a ship has sunk.
     * @param position a Position class object, that is the position of the grid to look for.
     * @return true if a ship has sunk at the given position, false otherwise.
     */
    public boolean hasSunk(Position position) {
        for (Ship ship : fleet) {
            if (ship.occupy(position) && ship.hasSunk()) {
                return true;
            }
        }
        return false;
    }

    /**
     * It tells if all the ships sunk.
     * @param position a Position class object, that is the position of the grid to look for.
     * @return true if a ship has sunk at the given position, false otherwise.
     */
    public boolean allSunk() {
        for (Ship ship : fleet) {
            if (!ship.hasSunk()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String myGrid = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Position position = new Position(i, j);
                if (occupied(position)) { //Checking if the position is occupied by a ship.
                    if (isHit(position)) { //If it is, then check if the ship was hit in the same position.
                        myGrid += "*";
                    } else { //If there is a ship, but it has not been hit in that position.
                        myGrid += "#";
                    }
                } else { //If no ship occupies that position.
                    myGrid += ".";
                }
            }
            myGrid += "\n";
        }
        return myGrid;
    }
}
