package CommandPattern;

/**
 * 灯具打开命令
 */
public class LightOnCommand implements Command {
    Light light;

    public LightOnCommand(Light light) {
        System.out.println("为Light设置好命令");
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("执行命令");
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
