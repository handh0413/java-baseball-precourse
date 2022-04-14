package baseball.controller;

import baseball.domain.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameControllerTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void 입력_테스트() {
        final String input = "123";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Game game = new Game();
        GameController controller = new GameController(game);
        assertEquals(input, controller.readInput());
        assertEquals("숫자를 입력해주세요: ", outputStreamCaptor.toString());
    }

    @Test
    public void 숫자_초기화_테스트() {
        Game game = new Game();
        GameController controller = new GameController(game);
        assertDoesNotThrow(() -> {
            game.validateInput(controller.makeAnswer());
        });

        assertDoesNotThrow(() -> {
            game.validateInput(controller.makeAnswer());
        });

        assertDoesNotThrow(() -> {
            game.validateInput(controller.makeAnswer());
        });

        assertDoesNotThrow(() -> {
            game.validateInput(controller.makeAnswer());
        });
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}
