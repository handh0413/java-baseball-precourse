package baseball.controller;

import baseball.domain.Game;
import baseball.domain.InputResult;
import camp.nextstep.edu.missionutils.Console;

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
        System.out.print("TEST: ");
        return Console.readLine();
    }

    public String makeAnswer() {
        return "TEST";
    }

}
