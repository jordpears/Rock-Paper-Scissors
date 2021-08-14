package util;

public class PrettyHandUtil {
    private static final String leftRock =
            "    _______       \n"+
            "---'   ____)      \n"+
            "      (_____)     \n"+
            "      (_____)     \n"+
            "      (____)      \n"+
            "---.__(___)       \n";

    private static final String leftPaper =
            "    ________      \n"+
            "---'    ____)____ \n"+
            "           ______)\n"+
            "           ______)\n"+
            "         _______) \n"+
            "---.__________)   \n";

    private static final String leftScissors =
            "    ________      \n"+
            "---'    ____)____ \n"+
            "           ______)\n"+
            "       __________)\n"+
            "      (____)      \n"+
            "---.__(___)       \n";

    private static final String rightRock =
            "       _______    \n"+
            "      (____   '---\n"+
            "     (_____)      \n"+
            "     (_____)      \n"+
            "      (____)      \n"+
            "       (___)__.---\n";

    private static final String rightPaper =
            "      ________    \n"+
            " ____(____    '---\n"+
            "(______           \n"+
            "(_______          \n"+
            " (_______         \n"+
            "   (__________.---\n";

    private static final String rightScissors =
            "       _______    \n"+
            " _____(____   '---\n"+
            "(_______          \n"+
            "(__________       \n"+
            "      (____)      \n"+
            "       (___)__.---\n";

    public static String getPrettyString(Action action, Direction direction){
        if(Direction.LEFT.equals(direction)){
            switch(action){
                case ROCK: return leftRock;
                case PAPER: return leftPaper;
                case SCISSORS: return leftScissors;
            }
        }
        if(Direction.RIGHT.equals(direction)){
            switch (action){
                case ROCK: return rightRock;
                case PAPER: return rightPaper;
                case SCISSORS: return rightScissors;
            }
        }

        throw new IllegalArgumentException("Invalid input: Hand: " + action + ", Direction: " + direction);
    }

    public enum Direction{
        RIGHT,
        LEFT
    }
}


