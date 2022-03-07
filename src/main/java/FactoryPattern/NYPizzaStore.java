package FactoryPattern;

/**
 * 纽约披萨商店
 */
public class NYPizzaStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("chess")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("clam")) {
            return new NYStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new NYStyleCheesePizza();
        } else return null;
    }
}
