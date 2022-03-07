package FactoryPattern;

/**
 * 披萨商店
 */
public abstract class PizzaStore {

    public Pizza orderPizza(String type) {
        Pizza pizza;
        pizza = createPizza(type);

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();

        return pizza;
    }

    /**
     * 抽象的披萨制作
     * 由子类实现制作披萨的方法
     * @param type
     * @return
     */
    protected abstract Pizza createPizza(String type);

}
