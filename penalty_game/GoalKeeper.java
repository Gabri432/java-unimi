package penalty_game;

/** The 'GoalKeeper' class represents the player that will try to conceed less than 3 goals to win the game.
 * @author Gabriele Gatti
 */
public class GoalKeeper extends Player {
    private final String teamName;

    public static class Builder extends Player.Builder<Builder> {
        private String teamName = "JavaIsAmazing";
        public Builder teamName(String t) {
            teamName = t;
            return this;
        }

        @Override
        public Player build() {
            return new GoalKeeper(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private GoalKeeper(Builder builder) {
        super(builder);
        teamName = builder.teamName;
    }

    public String getTeamName() {
        //EFFECTS: returns player team name.
        return this.teamName;
    }
}

