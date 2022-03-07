package CommandPattern;

/**
 * 控制器代码
 */
public class SimpleRemoteControl {
    Command slot;

    public SimpleRemoteControl() {
    }

    public void setCommand(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed() {
        System.out.println("按下按钮");
        slot.execute();
    }
}
