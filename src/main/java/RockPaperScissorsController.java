import util.Action;
import util.GameResult;
import util.InputHandler;
import util.PrettyHandUtil;

import java.util.List;

import java.util.Locale;

public class RockPaperScissorsController {

    private final InputHandler inputHandler;

    public RockPaperScissorsController(InputHandler inputHandler){
        this.inputHandler = inputHandler;
    }

    public void printWelcome(){
        System.out.println(
                "Welcome to rock-paper-scissors!\n" +
                "Press enter to continue"
        );
        inputHandler.awaitEnter();
    }

    public int getNumberOfGames(){
        System.out.println("How many rounds would you like to play? (0 - 1000)");

        int numberOfGames = inputHandler.getIntegerInput();

        while(numberOfGames < 0 || numberOfGames > 1000){
            numberOfGames = inputHandler.getIntegerInput();
        }

        System.out.println("You have selected to play " + numberOfGames + " game(s).\n");

        return numberOfGames;
    }

    public Action getPlayerAction(){
        System.out.println("Select your hand by typing 'r', 'p', or 's' for rock, paper, or scissors, end the game by inputting 'q'");

        String playerSelection = "";

        while(!List.of("r", "p", "s", "q").contains(playerSelection.toLowerCase(Locale.ROOT))){
            playerSelection = inputHandler.getStringInput();
        }

        return Action.fromKey(playerSelection);
    }

    public void printGameResult(Action playerAction, Action computerAction, GameResult gameResult){
        System.out.println("You have played " + playerAction.name);
        System.out.println(PrettyHandUtil.getPrettyString(playerAction, PrettyHandUtil.Direction.LEFT) + "\n");

        System.out.println("The computer has played " + computerAction.name);
        System.out.println(PrettyHandUtil.getPrettyString(computerAction, PrettyHandUtil.Direction.RIGHT) + "\n");

        System.out.println("Resulting in a " + gameResult.formatted + " for you!\n");

    }

    public void printThankYou(){
        System.out.println("Thanks for playing :-)");
    }
}
