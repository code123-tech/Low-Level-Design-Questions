package Behavioral_Desing_pattern.Iterator.iterators;

import java.util.List;
import java.util.NoSuchElementException;

public class StringIterator implements Iterator<String> {

    private List<String> items;
    private int position;

    public StringIterator(List<String> items) {
        this.items = items;
        this.position = 0;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return items.get(position++);
        }
        throw new NoSuchElementException();
    }

}
