package penalty_game;
import java.util.concurrent.ThreadLocalRandom;

/** The 'Position' enum represents the set of the positions in which the ball can be kicked in.
 */
public enum Position {
    TOP_LEFT(0),
    TOP_CENTER(1),
    TOP_RIGHT(2),
    BOTTOM_LEFT(3),
    BOTTOM_CENTER(4),
    BOTTOM_RIGHT(5);

    private final int value;
    Position(int value) { this.value = value; }

    public int positionValue() { return value; }

    public static Position randomPosition() {
        //EFFECTS: It will return a random position between the available six.
        Position[] positions = values();
        int index = ThreadLocalRandom.current().nextInt(positions.length);
        return positions[index];
    }
}