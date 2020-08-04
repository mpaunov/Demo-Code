package Commands;

import utils.Main;

public class Loose implements Command {
    @Override
    public String execute() {
        Main.gameOver = true;
        return "You lost Game Over";
    }

    @Override
    public void setCommandValue(Integer value) {

    }
}
