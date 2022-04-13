package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputResultTest {

    @Test
    public void 결과_1스트라이크_1볼() {
        InputResult result = new InputResult(1, 1);
        assertEquals(1, result.getStrikes());
        assertEquals(1, result.getBalls());
    }

    @Test
    public void 결과_1볼() {
        InputResult result = new InputResult(0, 1);
        assertEquals(1, result.getBalls());
    }

    @Test
    public void 결과_2볼() {
        InputResult result = new InputResult(0, 2);
        assertEquals(2, result.getBalls());
    }

    @Test
    public void 결과_1스트라이크() {
        InputResult result = new InputResult(1, 0);
        assertEquals(1, result.getStrikes());
    }

    @Test
    public void 결과_3스트라이크() {
        InputResult result = new InputResult(3, 0);
        assertEquals(3, result.getStrikes());
        assertEquals(true, result.isSuccess());
    }

}