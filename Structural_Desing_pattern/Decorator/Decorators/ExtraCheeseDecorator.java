package Decorator.Decorators;

import Decorator.Base.BasePizza;

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
