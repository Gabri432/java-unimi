package penalty_game;

public class Kicker extends Player {
    private final String teamName;

    public static class Builder extends Player.Builder<Builder> {
        private String teamName = "JavaIsFunny";
        public Builder teamName(String t) {
            teamName = t;
            return this;
        }

        @Override
        public Player build() {
            return new Kicker(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private Kicker(Builder builder) {
        super(builder);
        teamName = builder.teamName;
    }

    public String getTeamName() {
        //EFFECTS: returns player team name.
        return this.teamName;
    }
}
