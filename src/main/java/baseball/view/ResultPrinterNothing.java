package baseball.view;

import baseball.domain.InputResult;

public class ResultPrinterNothing extends ResultPrinter {

    public ResultPrinterNothing(InputResult inputResult) {
        super(inputResult);
    }

    @Override
    public void show() {
        System.out.println("낫싱");
    }
}
