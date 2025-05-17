package Behavioral_Desing_pattern.Iterator;

import Behavioral_Desing_pattern.Iterator.aggregators.StringCollection;
import Behavioral_Desing_pattern.Iterator.iterators.Iterator;

public class IteratorPatternDemo {

    public static void main(String[] args) {
        
        StringCollection StringCollection = new StringCollection();
        StringCollection.addItem("Item 1");
        StringCollection.addItem("Item 2");
        StringCollection.addItem("Item 3");

        Iterator<String> iterator = StringCollection.createIterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println(item);
        }

    }

}
