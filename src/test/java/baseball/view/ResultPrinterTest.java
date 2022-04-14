package baseball.view;

import baseball.domain.InputResult;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ResultPrinterTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void 스트라이크_볼_테스트() {
        InputResult result = new InputResult(1, 1);
        ResultPrinter printer = result.getResultPrinter();
        printer.show();
        assertEquals("1볼 1스트라이크", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 볼_테스트() {
        InputResult result = new InputResult(0, 1);
        ResultPrinter printer = result.getResultPrinter();
        printer.show();
        assertEquals("1볼", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 스트라이크_테스트() {
        InputResult result = new InputResult(3, 0);
        ResultPrinter printer = result.getResultPrinter();
        printer.show();
        assertEquals("3스트라이크", outputStreamCaptor.toString().trim());
    }

    @Test
    public void 낫싱_테스트() {
        InputResult result = new InputResult(0, 0);
        ResultPrinter printer = result.getResultPrinter();
        printer.show();
        assertEquals("낫싱", outputStreamCaptor.toString().trim());
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

}