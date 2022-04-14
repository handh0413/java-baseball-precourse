package baseball;

import baseball.controller.GameController;
import baseball.domain.Game;
import baseball.domain.InputResult;
import baseball.view.ResultPrinter;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        GameController controller = new GameController(game);
        controller.initAnswer();
        while (true) {
            String userInput = controller.readInput();
            InputResult result = controller.calculate(userInput);
            ResultPrinter printer = result.getResultPrinter();
            printer.show();
            if (controller.isGameEnd(result)) {
                break;
            }
        }
    }
}
