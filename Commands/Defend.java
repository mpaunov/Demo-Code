package Commands;

public class Defend implements Command {
    @Override
    public String execute() {
        return "Commands.Defend activated no point taken";
    }

    @Override
    public void setCommandValue(Integer value) {
        throw new UnsupportedOperationException();
    }
}
