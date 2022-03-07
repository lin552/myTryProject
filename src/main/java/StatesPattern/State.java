package StatesPattern;

/**
 * 状态
 */

public interface State {

    /**
     * 投币
     */
    void insertQuarter();

    /**
     * 退钱
     */
    void ejectQuarter();

    /**
     * 扭动
     */
    void turnCrank();

    /**
     * 分配
     */
    void dispense();

}
