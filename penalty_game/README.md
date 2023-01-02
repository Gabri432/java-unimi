# Penalty Game
A penalty shootout game created with Java.

## Description
- Two players, a `Kicker` and a `GoalKeeper`, will face each other in a penalty shootout.
- The user will get to choose between one of them, the other will move automatically.

### Kicker objective
The kicker has to score at least 3 goals on five attempts to win the game.

### GoalKeeper objective
The goalkeeper has to conceed at most 2 goals on five kicker attempts to win the game.

### Rules
- The ball can be kicked in `6 different positions`, top left-center-right, bottom left-center-right.
- Therefore the goalkeeper has to guess which of those positions the ball will be kicked in.
- If the goalkeeper guesses the right position the kicker will have failed to score.
- Otherwise the kicker will succeed in scoring a goal.  