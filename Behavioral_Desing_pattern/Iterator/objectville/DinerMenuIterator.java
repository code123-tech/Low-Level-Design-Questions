package Behavioral_Desing_pattern.Iterator.objectville;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Concrete iterator over a fixed-size array.
 * remove() is not supported for this example.
 */
public class DinerMenuIterator implements Iterator<MenuItem> {
    private final MenuItem[] items;
    private int position = 0;

    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return items[position++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("You shouldn't be trying to remove menu items.");
    }
}

