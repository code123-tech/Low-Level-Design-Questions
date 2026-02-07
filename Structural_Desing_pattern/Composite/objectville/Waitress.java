package Structural_Desing_pattern.Composite.objectville;

/**
 * Client of the Composite.
 * Notice: only one reference (allMenus) is needed.
 */
public class Waitress {
    private final MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}

