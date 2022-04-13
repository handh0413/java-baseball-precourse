package baseball.domain;

public class Game {

    void validateInput(String input) {
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

}
