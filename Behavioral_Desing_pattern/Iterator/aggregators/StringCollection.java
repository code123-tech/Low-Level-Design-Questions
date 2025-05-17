package Behavioral_Desing_pattern.Iterator.aggregators;

import java.util.List;

import Behavioral_Desing_pattern.Iterator.iterators.Iterator;
import Behavioral_Desing_pattern.Iterator.iterators.StringIterator;

public class StringCollection implements IterableCollection<String> {

    private List<String> items;

    public StringCollection() {
        this.items = new java.util.ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public Iterator<String> createIterator(){
        return new StringIterator(items);
    }

}
