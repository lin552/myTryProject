package AdapterPattern;

public class WildTurkey implements Turkey {

    @Override
    public void gobble() {
        System.out.println("Goblle gobble");

    }

    @Override
    public void fly() {
        System.out.println("I flying a short distance");
    }
}
