package Structural_Desing_pattern.Decorator;

import Structural_Desing_pattern.Decorator.Base.BasePizza;
import Structural_Desing_pattern.Decorator.Base.FarmHousePizza;
import Structural_Desing_pattern.Decorator.Base.VegDelightPizza;
import Structural_Desing_pattern.Decorator.Decorators.ExtraCheeseDecorator;
import Structural_Desing_pattern.Decorator.Decorators.MushroomDecorator;

public class Main {
    public static void main(String[] args) {
        System.out.println("----------Decorator Design Pattern for Pizza------------");
        BasePizza vegDelightPizza = new VegDelightPizza();
        BasePizza farmHousePizza = new FarmHousePizza();
        System.out.println("----------Farm House Pizza price without decorators.------------");
        System.out.println(farmHousePizza.cost());

        System.out.println("----------Veg Delight Pizza price without decorators.------------");
        System.out.println(vegDelightPizza.cost());

        System.out.println("-----------Farm House Pizza with Mushroom---------");
        BasePizza farmHouseWithMushroom = new MushroomDecorator(farmHousePizza);
        System.out.println(farmHouseWithMushroom.cost());

        System.out.println("-----------Farm House Pizza with Mushroom and Extra cheese---------");
        BasePizza farmHouseWithMushroomAndCheese = new ExtraCheeseDecorator(farmHouseWithMushroom);
        System.out.println(farmHouseWithMushroomAndCheese.cost());
    }
}
