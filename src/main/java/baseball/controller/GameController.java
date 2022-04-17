package baseball.controller;

import baseball.domain.Game;
import baseball.domain.InputResult;
import baseball.ui.GameInput;
import baseball.view.ResultPrinter;
import camp.nextstep.edu.missionutils.Randoms;

public class GameController {
    private static final String CONTINUE = "1";
    private static final String STOP = "2";
    private Game game;
    private boolean playing;

    public GameController(Game game) {
        this.game = game;
    }

    public void play() {
        initGame();
        while (isPlaying()) {
            String userInput = GameInput.readBaseballInput();
            InputResult result = validateUserInputForBaseball(userInput);
            validateResult(result);
        }
    }

    private void initGame() {
        game.setAnswer(makeAnswer());
        setPlaying(true);
    }

    private InputResult validateUserInputForBaseball(String userInput) {
        InputResult result = game.calculate(userInput);
        ResultPrinter printer = result.getResultPrinter();
        printer.show();
        return result;
    }

    void validateResult(InputResult result) {
        String userInput = "";
        if (result.isSuccess()) {
            userInput = GameInput.readStopOrContinueInput();
            validateUserInputForStopOrContinue(userInput);
        }
        processStopOrContinue(userInput);
    }

    void validateUserInputForStopOrContinue(String userInput) {
        if (!"1".equals(userInput) && !"2".equals(userInput)) {
            throw new IllegalArgumentException("입력값(1 or 2)에 문제가 있습니다.");
        }
    }

    void processStopOrContinue(String userInput) {
        if (STOP.equals(userInput)) {
            setPlaying(false);
        }

        if (CONTINUE.equals(userInput)) {
            game.setAnswer(makeAnswer());
        }
    }

    public String makeAnswer() {
        String answer = "";
        while (answer.length() != 3) {
            answer = addDigit(answer);
        }
        return answer;
    }

    private String addDigit(String number) {
        String digit = String.valueOf(Randoms.pickNumberInRange(1, 9));
        if (number.contains(digit)) {
            return number;
        }
        return number.concat(digit);
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public boolean isPlaying() {
        return playing;
    }

}
