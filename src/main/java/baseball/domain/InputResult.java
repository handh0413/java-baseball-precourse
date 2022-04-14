package baseball.domain;

import baseball.view.*;

public class InputResult {
    public Integer strikes;
    public Integer balls;

    public InputResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public Boolean isSuccess() {
        return strikes == 3;
    }

    public Integer getStrikes() {
        return strikes;
    }

    public Integer getBalls() {
        return balls;
    }

    public ResultPrinter getResultPrinter() {
        return new ResultPrinter(this) {
            @Override
            public void show() {
                System.out.println("TEST");
            }
        };
    }
}
