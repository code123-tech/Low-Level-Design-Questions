package Structural_Desing_pattern.Decorator.Decorators;

import Structural_Desing_pattern.Decorator.Base.BasePizza;

public class MushroomDecorator extends Decorator{

    BasePizza basePizza;
    private int mushroomDecoratorPrice = 30;

    public MushroomDecorator(BasePizza basePizza){
        this.basePizza = basePizza;
    }

    @Override
    public int cost(){
        return this.basePizza.cost() + mushroomDecoratorPrice;
    }
}
