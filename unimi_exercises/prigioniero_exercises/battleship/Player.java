package unimi_exercises.prigioniero_exercises.battleship;

import java.util.ArrayList;

/*
 * DESCRIPTION: This class will be part of a set of classes to create the game 'BattleShip'.
 * NOTE: You should first take a look at the 'Position', 'Ship' and 'Grid' classes to better understand the 'Player' class. 
 * 
 * LINK: https://github.com/lprigioniero/labprog/blob/master/esercizi/battaglia_navale_giocatore/Testo.md
 * 
 */

public class Player {

    final Ship[] configuration;
    final Position[] moves;
    ArrayList<Position> lastMovesTaken;

    public Player(final Ship[] configuration, final Position[] moves) {
        this.configuration = configuration;
        this.moves = moves;
    }

    /**
     * It shows the Player ships.
     * @return the player ships configuration.
     */
    public Ship[] fleet() {
        return this.configuration;
    }

    /**
     * It tells the next Player move.
     * @return the next player move, or null if the player runs out of moves, or abandonds the game.
     */
    public Position move() {
        for (Position move : moves) {
            if (!lastMovesTaken.contains(move)) {
                lastMovesTaken.add(move);
                return move;
            }
        }
        return null;
    }

    /**
     * <p> It tells the player the result following the latest move made.</p>
     * <p> The result could be: M (miss), H (hit), S (hit and sunk). 
     * @param move a <code>Position</code> class object, that is the position chosen by the player to hit next.
     * @return a <code> Char </code>the result.
     */

    public char result(Position move) {
        for (Ship ship : configuration) {
            ship.hit(move); //Hit a ship (if there is one in that position).
            if (ship.hasSunk()) { //Checking if the ship has sunk (assuming it didn't sink before, therefore the player isn't repeating the same move).
                return 'S';
            }
            if (ship.isHit(move)) { //If the player move has hit a ship.
                return 'H';
            }
        }
        return 'M'; //If the player move didn't hit or sink a ship.
    }

    /*
    public void result(char e) {} 

    This is the actual signature for 'result' method specified in the request,
    but I didn't understand how to use it.
    */

    @Override
    public String toString() {
        String myGrid = "";
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                Position position = new Position(i, j);
                char res = result(position);
                switch (res) {
                    case 'S', 'H', 'M':
                    myGrid += res; //Recording in the grid where the player has sunk, hit or missed a ship.
                    break;
                    default:
                    myGrid += "."; //Recording in the grid where no action was taken.
                    break;
                }
            }
            myGrid += "\n";
        }
        return myGrid;
    }
}
