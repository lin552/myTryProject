package CompositePattern;

import java.util.Iterator;

/**
 * 空迭代器
 */
public class NullIterator implements Iterator {

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    public void remove(){
        throw new UnsupportedOperationException();
    }
}
