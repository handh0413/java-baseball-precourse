package baseball.controller;

import baseball.domain.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameControllerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private Game game;
    private GameController controller;

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        game = new Game();
        controller = new GameController(game);
    }

    @Test
    public void 입력_테스트() {
        final String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(input, controller.readInput());
        assertEquals("숫자를 입력해주세요: ", outputStreamCaptor.toString());
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
    public void 새로시작_종료_테스트() {
        final String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(input, controller.getUserFinalInput());
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\r\n", outputStreamCaptor.toString());
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

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
