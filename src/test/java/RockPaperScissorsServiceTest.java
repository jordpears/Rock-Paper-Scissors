import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.Action;
import util.GameResult;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RockPaperScissorsServiceTest {

    Random random = mock(Random.class);

    RockPaperScissorsService rockPaperScissorsService = new RockPaperScissorsService(random);

    @ParameterizedTest
    @CsvSource({
            "2, ROCK",
            "1, PAPER",
            "0, SCISSORS"
    })
    void TestGetComputerHandReturnsHandBasedOnRandomInput(int randomInt, Action actionReturned){
        when(random.nextInt(3)).thenReturn(randomInt);
        Action actual = rockPaperScissorsService.getComputerHand();
        assertEquals(actionReturned, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "ROCK,ROCK,DRAW",
            "ROCK,PAPER,LOSS",
            "ROCK,SCISSORS,WIN",
            "PAPER,ROCK,WIN",
            "PAPER,PAPER,DRAW",
            "PAPER,SCISSORS,LOSS",
            "SCISSORS,ROCK,LOSS",
            "SCISSORS,PAPER,WIN",
            "SCISSORS,SCISSORS,DRAW",})
    void TestGetPlayerResultReturnsCorrectResultGivenActionInputs(Action player, Action computer, GameResult expected){

        GameResult actual = rockPaperScissorsService.getPlayerResult(player, computer);

        assertEquals(expected, actual);
    }

}