package baseball.view;

import baseball.domain.InputResult;

public abstract class ResultPrinter {
    InputResult inputResult;

    public ResultPrinter(InputResult inputResult) {
        this.inputResult = inputResult;
    }

    public abstract void show();

    int getBalls() {
        return inputResult.getBalls();
    }

    int getStrikes() {
        return inputResult.getStrikes();
    }
}
