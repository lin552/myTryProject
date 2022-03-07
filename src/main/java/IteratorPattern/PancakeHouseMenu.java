package IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 煎饼屋菜单
 */
public class PancakeHouseMenu implements Menu {
    ArrayList menuList;

    public PancakeHouseMenu() {
        menuList = new ArrayList();

        addItem("K&B's Pancake PancakeHouse",
                "Pancakes with scrambled eggs,and toast", true, 2.99
        );

        addItem("K&B's Pancake PancakeHouse",
                "Pancakes with scrambled eggs,and toast", true, 2.99
        );

        addItem("K&B's Pancake PancakeHouse",
                "Pancakes with scrambled eggs,and toast", true, 2.99
        );

        addItem("Waffles",
                "Waffles,with your choice of blueberries or strawberries", true, 3.59
        );

    }

    @Override
    public Iterator createIterator() {
        return new PancakeHouseMenuIterator(menuList);
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        menuList.add(menuItem);
    }

//    public ArrayList getMenuList() {
//        return menuList;
//    }
}
