package penalty_game;

/** <p>The 'PenaltyGame' class will define the set of rules and conditions in which the game will be played.</p>
 * 
 * <p>A <code>Kicker</code> and a <code>GoalKeeper</code> will face each other in a penalty shootout.</p>
 * <ul>
 * <li>The kicker has to score 3 goals (on 5 attempts) to win the game.</li>
 * <li>The goalkeeper must conceed less than 3 goals (on 5 kicker attempts) to win the game.</li>
 * </ul>
 */
public class PenaltyGame {
    private int kickerScore; //The amount of goals scored by the kicker.
    private int remainingTurns; //The amount of turns remaining.

    public PenaltyGame() {
        this.kickerScore = 0;
        this.remainingTurns = 5;
    }

    public int getRemainingTurns() {
        //EFFECTS: Returns the amount of turns remaining.
        return this.remainingTurns;
    }

    public int getKickerScore() {
        //EFFECTS: Returns the amount of goals scored by the kicker.
        return this.kickerScore;
    }

    public boolean hasKickerWon() {
        //EFFECTS: Verifies if the kicker has won the game, that is, if the kicker has scored at least 3 goals.
        // within the 5 attempts.
        return getKickerScore() >= 3 && getRemainingTurns() > 0;
    }

    public boolean hasKickerScored() {
        //EFFECTS: Verifies if the kicker has scored a goal, that is, if the ball was kicked in a
        // different position than the one the goalkeeper guessed.
        return false;
    }
}
