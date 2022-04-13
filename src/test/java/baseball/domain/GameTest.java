package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    @Test
    public void 입력_검증_테스트_세자리() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputLength("");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputLength("1");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputLength("12");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputLength("1234");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputLength("123456789");
        });

        Assertions.assertDoesNotThrow(() -> {
            Game game = new Game();
            game.validateInputLength("123");
        });
    }

    @Test
    public void 입력_검증_테스트_타입() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputType("12A");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputType("23#");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputType("AB3");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputType("@#3");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputType("ABC");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputType("#$%");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputType("012");
        });

        Assertions.assertDoesNotThrow(() -> {
            Game game = new Game();
            game.validateInputType("234");
        });
    }

    @Test
    public void 입력_검증_테스트_중복() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputDuplicate("111");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputDuplicate("112");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputDuplicate("122");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInputDuplicate("313");
        });

        Assertions.assertDoesNotThrow(() -> {
            Game game = new Game();
            game.validateInputDuplicate("345");
        });
    }

    @Test
    public void 입력_검증_테스트() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInput("12");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInput("12A");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInput("340");
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Game game = new Game();
            game.validateInput("122");
        });

        Assertions.assertDoesNotThrow(() -> {
            Game game = new Game();
            game.validateInput("456");
        });
    }
}
