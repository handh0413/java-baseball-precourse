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

    public Boolean isOnlyBalls() {
        return balls > 0 && strikes == 0;
    }

    public Boolean isOnlyStrikes() {
        return strikes > 0 && balls == 0;
    }

    public Boolean isBothStrikesAndBalls() {
        return strikes > 0 && balls > 0;
    }

    public Integer getStrikes() {
        return strikes;
    }

    public Integer getBalls() {
        return balls;
    }

    public ResultPrinter getResultPrinter() {
        if (isBothStrikesAndBalls()) {
            return new ResultPrinterStrikeAndBall(this);
        }
        if (isOnlyStrikes()) {
            return new ResultPrinterStrike(this);
        }
        if (isOnlyBalls()) {
            return new ResultPrinterBall(this);
        }
        return new ResultPrinterNothing(this);
    }
}
