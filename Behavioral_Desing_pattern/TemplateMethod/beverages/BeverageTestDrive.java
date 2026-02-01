package Behavioral_Desing_pattern.TemplateMethod.beverages;


import Behavioral_Desing_pattern.TemplateMethod.beverages.hooks.CaffeineBeverageWithHook;
import Behavioral_Desing_pattern.TemplateMethod.beverages.hooks.CoffeeWithHook;
import Behavioral_Desing_pattern.TemplateMethod.beverages.hooks.TeaWithHook;

public class BeverageTestDrive {
    public static void main(String[] args) {

        System.out.println("=== Template Method (no hook) ===");
        CaffeineBeverage tea = new Tea();
        CaffeineBeverage coffee = new Coffee();

        System.out.println("\nMaking tea...");
        tea.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffee.prepareRecipe();

        System.out.println("\n=== Template Method (with hook) ===");
        CaffeineBeverageWithHook teaHook = new TeaWithHook();
        CaffeineBeverageWithHook coffeeHook = new CoffeeWithHook();

        System.out.println("\nMaking tea...");
        teaHook.prepareRecipe();

        System.out.println("\nMaking coffee...");
        coffeeHook.prepareRecipe();
    }
}

