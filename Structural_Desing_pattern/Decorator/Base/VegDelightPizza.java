package Structural_Desing_pattern.Decorator.Base;

public class VegDelightPizza extends BasePizza{
    private int price = 120;

    @Override
    public int cost() {
        return price;
    }
}
