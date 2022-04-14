package baseball.view;

import baseball.domain.InputResult;

public class ResultPrinterStrike extends ResultPrinter {

    public ResultPrinterStrike(InputResult inputResult) {
        super(inputResult);
    }

    @Override
    public void show() {
        System.out.println(getStrikes() + "스트라이크");
    }
}
