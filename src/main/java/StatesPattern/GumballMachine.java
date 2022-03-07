package StatesPattern;

/**
 * 糖果贩卖机
 */
public class GumballMachine {
    final static int SOLD_OUT = 0; //糖果售罄
    final static int NO_QUARTER = 1; //无25分
    final static int HAS_QUARTER = 2; //有25分
    final static int SOLD = 3; //售出糖果


    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State winnerState;

    State state = soldOutState;
    int count = 0;


    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    /**
     * 投币
     */
    public void insertQuarter() {
        state.insertQuarter();
    }

    /**
     * 退钱
     */
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * 转动曲柄
     */
    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getState() {
        return state;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot ...");
        if (count != 0) {
            count = count - 1;
        }
    }

    /**
     * 发放糖果
     */
    public void dispense(){
        state.dispense();
    }

    void refill(int count) {
        this.count = count;
        state = noQuarterState;
    }
}
