package baseball.domain;

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
}
