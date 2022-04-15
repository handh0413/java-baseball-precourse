package baseball;

import baseball.controller.GameController;
import baseball.domain.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        GameController controller = new GameController(game);
        controller.play();
    }
}
