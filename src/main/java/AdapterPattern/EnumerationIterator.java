package AdapterPattern;

import java.util.Enumeration;
import java.util.Iterator;

/**
 *
 */
public class EnumerationIterator implements Iterator {

    //旧世界的枚举器
    Enumeration enumeration;

    public EnumerationIterator(Enumeration enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }
}
