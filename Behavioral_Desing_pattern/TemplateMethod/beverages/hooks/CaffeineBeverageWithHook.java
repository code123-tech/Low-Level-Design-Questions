package Behavioral_Desing_pattern.TemplateMethod.beverages.hooks;

/**
 * Template Method + Hook example (Chapter 8).
 *
 * Hook: customerWantsCondiments()
 * - default behavior: true
 * - subclasses may override to control whether condiments are added
 */
public abstract class CaffeineBeverageWithHook {

    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        if (customerWantsCondiments()) {
            addCondiments();
        }
    }

    protected abstract void brew();
    protected abstract void addCondiments();

    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Hook (optional override point)
    protected boolean customerWantsCondiments() {
        return true;
    }
}

