package Behavioral_Desing_pattern.Iterator.objectville;

import java.util.Iterator;

/**
 * Common interface for all menus.
 * Waitress programs to this interface, not concrete menu implementations.
 */
public interface Menu {
    Iterator<MenuItem> createIterator();
}

