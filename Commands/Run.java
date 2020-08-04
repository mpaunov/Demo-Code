package Commands;

public class Run implements Command {
    @Override
    public String execute() {
        return "Running Free";
    }

    @Override
    public void setCommandValue(Integer value) {
        throw new UnsupportedOperationException();
    }
}
