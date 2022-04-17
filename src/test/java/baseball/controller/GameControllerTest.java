package baseball.controller;

import baseball.domain.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GameControllerTest {

    private Game game;
    private GameController controller;

    @BeforeEach
    public void setUp() {
        game = new Game();
        controller = new GameController(game);
    }

    @Test
    public void 새로시작_종료_입력_테스트() {
        final String input1 = "1";
        System.setIn(new ByteArrayInputStream(input1.getBytes()));
        controller.validateUserInputForStopOrContinue(input1);

        final String input2 = "2";
        System.setIn(new ByteArrayInputStream(input2.getBytes()));
        controller.validateUserInputForStopOrContinue(input2);

        final String input3 = "3";
        System.setIn(new ByteArrayInputStream(input3.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> {
            controller.validateUserInputForStopOrContinue(input3);
        });

        final String input4 = "A";
        System.setIn(new ByteArrayInputStream(input3.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> {
            controller.validateUserInputForStopOrContinue(input4);
        });

        final String input5 = "ABC";
        System.setIn(new ByteArrayInputStream(input3.getBytes()));
        assertThrows(IllegalArgumentException.class, () -> {
            controller.validateUserInputForStopOrContinue(input5);
        });
    }

    @Test
    public void 숫자_초기화_테스트() {
        assertDoesNotThrow(() -> {
            String newAnswer = controller.makeAnswer();
            game.setAnswer(newAnswer);
        });

        assertDoesNotThrow(() -> {
            String newAnswer = controller.makeAnswer();
            game.setAnswer(newAnswer);
        });

        assertDoesNotThrow(() -> {
            String newAnswer = controller.makeAnswer();
            game.setAnswer(newAnswer);
        });

        assertDoesNotThrow(() -> {
            String newAnswer = controller.makeAnswer();
            game.setAnswer(newAnswer);
        });
    }

}
