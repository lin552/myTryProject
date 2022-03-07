package FactoryPattern;

public class ChicagoStore extends PizzaStore {

    @Override
    protected Pizza createPizza(String type) {
        if (type.equals("chess")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("veggie")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("clam")) {
            return new ChicagoStyleCheesePizza();
        } else if (type.equals("pepperoni")) {
            return new ChicagoStyleCheesePizza();
        } else return null;
    }
}
