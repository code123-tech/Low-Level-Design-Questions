package Behavioral_Desing_pattern.Iterator.aggregators;

import Behavioral_Desing_pattern.Iterator.iterators.Iterator;

public interface IterableCollection<T> {

    Iterator<T> createIterator();
}
