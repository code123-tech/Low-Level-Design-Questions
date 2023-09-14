package Structural_Desing_pattern.Decorator.Decorators;

import Structural_Desing_pattern.Decorator.Base.BasePizza;

public class ExtraCheeseDecorator extends Decorator{
    BasePizza basePizza;
    private int extraCheesePrice = 15;

    public ExtraCheeseDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return this.basePizza.cost() + extraCheesePrice;
    }
}
