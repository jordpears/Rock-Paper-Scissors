import util.Action;
import util.GameResult;
import util.InputHandler;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        RockPaperScissorsService rockPaperScissorsService = new RockPaperScissorsService(new Random());
        RockPaperScissorsController rockPaperScissorsController = new RockPaperScissorsController(new InputHandler());

        rockPaperScissorsController.printWelcome();

        int numberOfGames = rockPaperScissorsController.getNumberOfGames();

        for(int i = 0; i < numberOfGames; i++){
            Action playerAction = rockPaperScissorsController.getPlayerAction();
            Action computerAction = rockPaperScissorsService.getComputerHand();

            if(playerAction == Action.QUIT){
                break;
            }

            GameResult result = rockPaperScissorsService.getPlayerResult(playerAction, computerAction);
            rockPaperScissorsController.printGameResult(playerAction, computerAction, result);
        }

        rockPaperScissorsController.printThankYou();
    }
}
