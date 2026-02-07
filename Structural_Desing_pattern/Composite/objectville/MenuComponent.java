package Structural_Desing_pattern.Composite.objectville;

import java.util.Iterator;

/**
 * Base Component in Composite pattern.
 * 
 * We use an abstract class (like HFDP) to provide default implementations.
 * Methods that don't make sense for a leaf/composite can throw UnsupportedOperationException.
 */
public abstract class MenuComponent {

    // Composite management operations (default: unsupported)
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i) {
        throw new UnsupportedOperationException();
    }

    // "Business" operations (default: unsupported)
    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }

    /**
     * Optional: iterator support (useful if you later build CompositeIterator).
     * For now, we keep it minimal.
     */
    public Iterator<MenuComponent> iterator() {
        throw new UnsupportedOperationException();
    }
}

