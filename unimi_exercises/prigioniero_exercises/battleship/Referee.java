package unimi_exercises.prigioniero_exercises.battleship;

/*
 * DESCRIPTION: This class will be part of a set of classes to create the game 'BattleShip'.
 * NOTE: You should first take a look at the 'Position', 'Ship', 'Grid', 'Player' classes to better understand the 'Referee' class. 
 * 
 * LINK: https://github.com/lprigioniero/labprog/blob/master/esercizi/battaglia_navale_arbitro/Testo.md
 * 
 */

public class Referee {

    final Player first;
    final Player second;
    Player currentPlayer; //One player per turn will be the attacker, starting from the first, then the second, then it repeats.
    Player nextPlayer; //The other player will be the opponent, starting from the second, then the first, then it repeats.

    public Referee(final Player first, final Player second) {
        this.first = first;
        this.second = second;
        this.currentPlayer = first;
        this.nextPlayer = second;
    }

    /**
     * <p>It tells if the current player still has a move to make.</p>
     * @return <code>true</code> if the player still has a move available, <code> false </code> otherwise.
     */
    public boolean hasNextStep() {
        if (allSunk()) { //Checking if all the current player ships have sunk.
            return false;
        }
        if (currentPlayer.lastMovesTaken.contains(null)) { //If the current player (attacker) has not yet finished all their moves.
            return false;
        }
        return true;
    }

    /**
     * It makes the next available move, if there is still one.
     */
    public void nextStep() {
        if (!hasNextStep()) { //If there are no more steps to take.
            return;
        }
        currentPlayer.result(currentPlayer.move()); //Perform the player move and return its result;
        Player helper = this.currentPlayer; //Switching attacker and opponent.
        this.currentPlayer = this.nextPlayer;
        this.nextPlayer = helper;
    }

    /**
     * It checks if all the players ships have sunk.
     * @return <code>true</code> if so, <code>false</code> otherwise.
     */
    public boolean allSunk() {
        for (Ship ship : currentPlayer.configuration) {
            if (!ship.hasSunk()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {  //WARNING: this method is not completed.
        System.out.println(first.fleet());
        System.out.println(second.fleet());
        return "";
    }
}
