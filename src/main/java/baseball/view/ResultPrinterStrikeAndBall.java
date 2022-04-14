package baseball.view;

import baseball.domain.InputResult;

public class ResultPrinterStrikeAndBall extends ResultPrinter {

    public ResultPrinterStrikeAndBall(InputResult inputResult) {
        super(inputResult);
    }

    @Override
    public void show() {
        System.out.println(getBalls() + "볼 " + getStrikes() + "스트라이크");
    }
}
