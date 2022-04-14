package baseball.controller;

import baseball.domain.Game;
import baseball.domain.InputResult;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameController {
    private static final String CONTINUE = "1";
    private static final String STOP = "2";
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void initAnswer() {
        game.setAnswer(makeAnswer());
    }

    public InputResult calculate(String input) {
        return game.calculate(input);
    }

    public String readInput() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
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

    public boolean isGameEnd(InputResult result) {
        String userInput = "";
        if (result.isSuccess()) {
            userInput = getUserFinalInput();
        }

        if (STOP.equals(userInput)) {
            return true;
        }

        if (CONTINUE.equals(userInput)) {
            initAnswer();
        }

        return false;
    }

    private String getUserFinalInput() {
        String userInput;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        userInput = Console.readLine();
        return userInput;
    }

}
