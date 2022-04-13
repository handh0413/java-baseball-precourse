package baseball.domain;

public class InputResult {
    public Integer strikes;
    public Integer balls;

    public InputResult(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public Boolean isSuccess() {
        return false;
    }

    public Integer getStrikes() {
        return -1;
    }

    public Integer getBalls() {
        return -1;
    }
}
