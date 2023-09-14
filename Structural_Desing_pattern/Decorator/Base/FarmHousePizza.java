package Structural_Desing_pattern.Decorator.Base;

public class FarmHousePizza extends BasePizza{
    private int price = 100;

    @Override
    public int cost() {
        return price;
    }
}
