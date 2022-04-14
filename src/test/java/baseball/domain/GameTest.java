package baseball.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    public void beforeEach() {
        game = new Game();
    }

    @Test
    public void 입력_검증_테스트_세자리() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputLength("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputLength("1");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputLength("12");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputLength("1234");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputLength("123456789");
        });

        assertDoesNotThrow(() -> {
            game.validateInputLength("123");
        });
    }

    @Test
    public void 입력_검증_테스트_타입() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputType("12A");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputType("23#");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputType("AB3");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputType("@#3");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputType("ABC");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputType("#$%");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputType("012");
        });

        assertDoesNotThrow(() -> {
            Game game = new Game();
            game.validateInputType("234");
        });
    }

    @Test
    public void 입력_검증_테스트_중복() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputDuplicate("111");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputDuplicate("112");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputDuplicate("122");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInputDuplicate("313");
        });

        assertDoesNotThrow(() -> {
            game.validateInputDuplicate("345");
        });
    }

    @Test
    public void 입력_검증_테스트() {
        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInput("12");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInput("12A");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInput("340");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            game.validateInput("122");
        });

        assertDoesNotThrow(() -> {
            game.validateInput("456");
        });
    }

    @Test
    public void 스트라이크_존재확인() {
        game.setAnswer("123");
        assertEquals(1, game.compareForStrike("145", 0));
        assertEquals(0, game.compareForStrike("145", 1));
        assertEquals(0, game.compareForStrike("145", 2));
    }

    @Test
    public void 볼_존재확인() {
        game.setAnswer("123");
        assertEquals(0, game.compareForBall("532", 0));
        assertEquals(1, game.compareForBall("532", 1));
        assertEquals(1, game.compareForBall("532", 2));

        game.setAnswer("123");
        assertEquals(1, game.compareForBall("321", 0));
        assertEquals(0, game.compareForBall("321", 1));
        assertEquals(1, game.compareForBall("321", 2));
    }

    @Test
    public void 스트라이크_개수확인() {
        game.setAnswer("123");
        assertEquals(3, game.calculateStrikes("123"));
        assertEquals(2, game.calculateStrikes("129"));
        assertEquals(1, game.calculateStrikes("189"));
        assertEquals(0, game.calculateStrikes("456"));
    }

    @Test
    public void 볼_개수확인() {
        game.setAnswer("123");
        assertEquals(3, game.calculateBalls("231"));
        assertEquals(2, game.calculateBalls("219"));
        assertEquals(1, game.calculateBalls("139"));
        assertEquals(0, game.calculateBalls("456"));
    }

    @Test
    public void 스트라이크_볼_개수확인() {
        game.setAnswer("123");
        InputResult result = game.calculate("123");
        assertEquals(3, result.getStrikes());
        assertEquals(0, result.getBalls());
        assertEquals(true, result.isSuccess());

        game.setAnswer("713");
        result = game.calculate("145");
        assertEquals(0, result.getStrikes());
        assertEquals(1, result.getBalls());
        assertEquals(false, result.isSuccess());

        result = game.calculate("671");
        assertEquals(0, result.getStrikes());
        assertEquals(2, result.getBalls());
        assertEquals(false, result.isSuccess());

        result = game.calculate("216");
        assertEquals(1, result.getStrikes());
        assertEquals(0, result.getBalls());
        assertEquals(false, result.isSuccess());
    }
}
