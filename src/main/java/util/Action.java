package util;

public enum Action {
    ROCK("r", "rock"),

    PAPER("p", "paper"),

    SCISSORS("s", "scissors"),

    QUIT("q", null);

    public final String name;
    private final String key;

    Action(String actionKey, String name) {
        this.key = actionKey;
        this.name = name;
    }

    public static Action fromKey(String inputKey){
        for(Action action : Action.values()){
            if(action.key.equals(inputKey)) return action;
        }
        throw new IllegalArgumentException(inputKey + " is not a valid inputKey.");
    }
}
