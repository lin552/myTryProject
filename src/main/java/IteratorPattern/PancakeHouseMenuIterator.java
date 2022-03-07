package IteratorPattern;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 煎饼屋迭代器
 */
public class PancakeHouseMenuIterator implements Iterator {
    ArrayList menuList;
    int position = 0;

    public PancakeHouseMenuIterator(ArrayList menuList) {
        this.menuList = menuList;
    }

    @Override
    public boolean hasNext() {
        if (menuList.size() <= position || menuList.get(position) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public Object next() {
        MenuItem menuItem = (MenuItem) menuList.get(position);
        position = position + 1;
        return menuItem;
    }
}
