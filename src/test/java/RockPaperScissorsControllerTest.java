import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.Action;
import util.InputHandler;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RockPaperScissorsControllerTest {

    InputHandler inputHandler = mock(InputHandler.class);

    RockPaperScissorsController rockPaperScissorsController = new RockPaperScissorsController(inputHandler);


    @Test
    void TestWhenUserSelects5GamesThenGetNumberOfGamesReturns5getNumberOfGamesReturns5When5InputGiven(){
        when(inputHandler.getIntegerInput()).thenReturn(5);
        int actual = rockPaperScissorsController.getNumberOfGames();
        assertEquals(5, actual);
    }

    @ParameterizedTest
    @CsvSource({"r, ROCK", "p, PAPER", "s, SCISSORS"})
    void TestGetPlayerActionReturnsSelectedHand(String input, Action expected){
        when(inputHandler.getStringInput()).thenReturn(input);
        Action actual = rockPaperScissorsController.getPlayerAction();

        assertEquals(expected, actual);
    }

    @Test
    void TestGetPlayerActionReturnsQuitWhenQGiven(){
        when(inputHandler.getStringInput()).thenReturn("q");
        Action actual = rockPaperScissorsController.getPlayerAction();

        assertEquals(Action.QUIT, actual);
    }

}