package CompositePattern;

import java.util.Iterator;

public class MenuItem extends MenuComponent {
    String name;
    String description;
    boolean vegetarian;
    double price;

    public MenuItem(String name, String description, boolean vegetarian, double price) {
        this.name = name;
        this.description = description;
        this.vegetarian = vegetarian;
        this.price = price;
    }

    public Iterator createIterator() {
        return new NullIterator();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public boolean isVegetarian() {
        return vegetarian;
    }

    public void print() {
        System.out.println(" " + getName());
        if (isVegetarian()) {
            System.out.println("(V)");
        }
        System.out.println(", " + getPrice());
        System.out.println("  --" + getDescription());
    }
}
