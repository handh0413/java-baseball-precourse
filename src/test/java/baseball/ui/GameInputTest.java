package baseball.ui;

import baseball.controller.GameController;
import baseball.domain.Game;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameInputTest {
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
        assertEquals(input, GameInput.readBaseballInput());
        assertEquals("숫자를 입력해주세요: ", outputStreamCaptor.toString());
    }

    @Test
    public void 새로시작_종료_테스트() {
        final String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        assertEquals(input, GameInput.readStopOrContinueInput());
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\r\n", outputStreamCaptor.toString());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}