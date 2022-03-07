package IteratorPattern;

import java.util.Iterator;

/**
 * 服务员
 */
public class Waitress {

    Menu pancakeHouseMenu;
    Menu dinerMenu;
    Menu cafeMenu;

    public Waitress(Menu pancakeHouseMenu, Menu dinerMenu, Menu cafeMenu) {
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu = dinerMenu;
        this.cafeMenu = cafeMenu;
    }

    public void printMenu() {
        System.out.println("MENU\n ----\nBREAKFAST");
        printMenu(pancakeHouseMenu.createIterator());
        System.out.println("MENU\n ----\nLUNCH");
        printMenu(dinerMenu.createIterator());
        System.out.println("\nDINNER");
        printMenu(cafeMenu.createIterator());

    }

    private void printMenu(Iterator iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getName() + " ,");
            System.out.println(menuItem.getPrice() + "--");
            System.out.println(menuItem.getDescription());
        }
    }

}
