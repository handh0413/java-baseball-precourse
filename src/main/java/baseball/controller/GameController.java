package baseball.controller;

import baseball.domain.Game;
import baseball.domain.InputResult;
import baseball.view.ResultPrinter;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class GameController {
    private static final String CONTINUE = "1";
    private static final String STOP = "2";
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void play() {
        game.setAnswer(makeAnswer());
        while (true) {
            String userInput = readInput();
            InputResult result = game.calculate(userInput);
            ResultPrinter printer = result.getResultPrinter();
            printer.show();
            if (isGameEnd(result)) {
                break;
            }
        }
    }

    String readInput() {
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
            game.setAnswer(makeAnswer());
        }

        return false;
    }

    String getUserFinalInput() {
        String userInput;
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        userInput = Console.readLine();
        return userInput;
    }

}
