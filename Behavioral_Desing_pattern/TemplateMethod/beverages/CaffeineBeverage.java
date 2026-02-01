package Behavioral_Desing_pattern.TemplateMethod.beverages;

/**
 * Chapter 8 (HFDP): Template Method Pattern
 *
 * prepareRecipe() is the template method (algorithm skeleton).
 * Subclasses fill in the variable steps: brew() and addCondiments().
 */
public abstract class CaffeineBeverage {

    // Template Method - controls the algorithm
    public final void prepareRecipe() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    // Primitive operations (must be implemented by subclasses)
    protected abstract void brew();
    protected abstract void addCondiments();

    // Shared concrete operations
    protected void boilWater() {
        System.out.println("Boiling water");
    }

    protected void pourInCup() {
        System.out.println("Pouring into cup");
    }
}

