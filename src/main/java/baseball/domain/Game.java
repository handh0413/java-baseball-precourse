package baseball.domain;

public class Game {
    private String answer;

    public Game() { }

    public Game(String input) {
        validateInput(input);
        this.answer = input;
    }

    public void setAnswer(String input) {
        validateInput(input);
        this.answer = input;
    }

    public void validateInput(String input) {
        validateInputLength(input);
        validateInputType(input);
        validateInputDuplicate(input);
    }

    void validateInputLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값(길이)에 문제가 있습니다.");
        }
    }

    void validateInputType(String input) {
        if (!input.matches("[1-9]{3}")) {
            throw new IllegalArgumentException("입력값(타입)에 문제가 있습니다.");
        }
    }

    void validateInputDuplicate(String input) {
        if (input.charAt(0) == input.charAt(1)
            || input.charAt(1) == input.charAt(2)
            || input.charAt(0) == input.charAt(2)) {
            throw new IllegalArgumentException("입력값(중복)에 문제가 있습니다.");
        }
    }

    public InputResult calculate(String input) {
        validateInput(input);
        int strikes = calculateStrikes(input);
        int balls = calculateBalls(input);
        return new InputResult(strikes, balls);
    }

    int calculateStrikes(String input) {
        int strikes = 0;
        for (int i = 0; i < answer.length(); i++) {
            strikes += compareForStrike(input, i);
        }
        return strikes;
    }

    int compareForStrike(String input, int index) {
        return answer.charAt(index) == input.charAt(index) ? 1 : 0;
    }

    int calculateBalls(String input) {
        int balls = 0;
        for (int i = 0; i < answer.length(); i++) {
            balls += compareForBall(input, i);
        }
        return balls;
    }

    int compareForBall(String input, int index) {
        boolean condition1 = answer.charAt(index) != input.charAt(index);
        boolean condition2 = answer.indexOf(input.charAt(index)) != -1;
        return condition1 && condition2 ? 1 : 0;
    }

}
