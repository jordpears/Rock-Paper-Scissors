package util;

public enum GameResult {
    WIN("win"),
    DRAW("draw"),
    LOSS("loss");

    public String formatted;

    GameResult(String formatted){
        this.formatted = formatted;
    }
}
