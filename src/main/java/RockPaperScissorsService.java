import util.Action;
import util.GameResult;

import java.util.Random;

public class RockPaperScissorsService {

    private final Random random;

    public RockPaperScissorsService(Random random){
        this.random = random;
    }

    public Action getComputerHand(){
        int handKey = this.random.nextInt(3);

        switch (handKey){
            case(2) : return Action.ROCK;
            case(1) : return Action.PAPER;
            case(0) : return Action.SCISSORS;
            default:
                throw new IllegalStateException("Unexpected value: " + handKey);
        }
    }

    public GameResult getPlayerResult(Action player, Action computer){
        if(player.equals(computer)) return GameResult.DRAW;

        if(player.equals(Action.ROCK)) return computer.equals(Action.PAPER) ? GameResult.LOSS : GameResult.WIN; //player plays rock, computer plays paper or scissors
        if(player.equals(Action.PAPER)) return computer.equals(Action.ROCK) ? GameResult.WIN : GameResult.LOSS; //player plays paper, computer plays rock or scissors
        if(player.equals(Action.SCISSORS)) return computer.equals(Action.ROCK) ? GameResult.LOSS : GameResult.WIN; //player plays scissors, computer plays rock or paper

        throw new IllegalStateException("Unexpected values: " + player + ", " + computer);
    }
}
