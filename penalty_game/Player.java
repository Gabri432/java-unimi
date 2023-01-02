package penalty_game;

/**<p>'Player' is the base class for all players of the game. </p>
 * 
 * <p>Every player object is <strong>immutable</strong> and defined by a name, an age, 
 * an height and the strong/favorite foot.</p>
 * 
 * <p>Every player is also <strong>unique in the name-age-height triplet</strong>.</p>
 * <p>Therefore two players cannot share the same name if both share the same age and height, 
 * or they cannot share the same age if they already share the same name and height, and so on.</p>
 * 
 * @author Gabriele Gatti
 * 
 */
public class Player {
    private final String name;
    private final int height, age;
    private final boolean rightHanded;

    public static class Builder { //Builder Pattern to avoid using too many constructors, from 'Effective Java, 3rd Edition'.
        private String name = "Javai sCool";
        private int height = 180;
        private int age = 20;
        private boolean rightHanded = true;

        public Builder name(String n) {name = n; return this;}
        public Builder height(int h) {height = h; return this;}
        public Builder age(int a) {age = a; return this;}
        public Builder rightHanded(boolean b) {rightHanded = b; return this;}

        public Player build() {
            return new Player(this);
        }
    }

    private Player(Builder builder) {
        name = builder.name;
        height = builder.height;
        age = builder.age;
        rightHanded = builder.rightHanded;
    }

    public String getName() {
        //EFFECTS: returns the player name.
        return this.name;
    }

    public int getHeight() {
        //EFFECTS: returns the player height.
        return this.height;
    }

    public int getAge() {
        //EFFECTS: returns the player age.
        return this.age;
    }

    public boolean isRightHanded() {
        //EFFECTS: returns true if the player is right-handed, false otherwise. 
        return this.rightHanded;
    }

    @Override
    public String toString() {
        return "Player Details:\nName: " + this.name + "\nHeight (cm): " + this.height + "\nAge: " + this.age 
        + "\nStrong foot:" + ((isRightHanded()) ? "Right" : "Left");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Player)) {
            return false;
        }

        Player player = (Player) obj;
        if (!(player.name.equals(getName()))) return false; //Returning false if players have different names.
        if (Integer.compare(player.age, getAge()) != 0) return false; //Returning false if players have different ages.
        if (Integer.compare(player.height, getHeight()) != 0) return false; //Returning false if players have different statures.
        return true; //Returning true if the player share all the three attributes.
    }

    @Override
    public int hashCode() {
        int result = getName().hashCode();
        result = 31 * result + Integer.hashCode(getAge());
        result = 31 * result + Integer.hashCode(getHeight());
        return result;
    }
}