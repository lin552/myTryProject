package IteratorPattern;

import java.util.Arrays;
import java.util.Iterator;

/**
 * 早餐菜单
 */
public class DinerMenu implements Menu {
    static final int MAX_ITEM = 6;
    int numberOfItems = 0;
    MenuItem[] menuItems;

    public DinerMenu() {
        menuItems = new MenuItem[MAX_ITEM];

        addItem("Vegetarian BLT", "(Fakin)Bacon with lettuce & tomato on whole wheat", true, 2.99);
        addItem("BLT", "Bacon with lettuce & tomato on whole wheat", false, 2.99);
        addItem("Soup of the day", "Soup of the day,with a side of potato salad", false, 3.29);
        addItem("Hotdog", "A hot dog,with saurkraut, relish,onions,topped with cheese", false, 3.05);

    }

    //客户直接使用迭代器就可以
    @Override
    public Iterator createIterator() {
        return Arrays.stream(menuItems).iterator();
    }

    public void addItem(String name, String description, boolean vegetarian, double price) {
        MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
        if (numberOfItems >= MAX_ITEM) {
            System.err.println("Sorry,menu is full! Can't add item to menu");
        } else {
            menuItems[numberOfItems] = menuItem;
            numberOfItems = numberOfItems + 1;
        }
    }

//    public MenuItem[] getMenuItems() {
//        return menuItems;
//    }
}
