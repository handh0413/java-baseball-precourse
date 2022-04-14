package baseball.view;

import baseball.domain.InputResult;

public class ResultPrinterBall extends ResultPrinter {

    public ResultPrinterBall(InputResult inputResult) {
        super(inputResult);
    }

    @Override
    public void show() {
        System.out.println(getBalls() + "볼");
    }
}
