package ProxyPattern;

public class NoQuarterState implements State {
    //告诉JVM不要序列号这个字段
    transient GumballMachine gumballMachine;

    @Override
    public void insertQuarter() {

    }

    @Override
    public void ejectQuarter() {

    }

    @Override
    public void turnCrank() {

    }

    @Override
    public void dispense() {

    }
}
