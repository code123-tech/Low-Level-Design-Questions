package creational_Desing_pattern.factory.PizzaStore;

import creational_Desing_pattern.factory.PizzaStore.Factory.NYStyleCheesePizza;
import creational_Desing_pattern.factory.PizzaStore.Factory.Pizza;

public class NYPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {

        if(type.equals("cheese")){
            return new NYStyleCheesePizza();
        }

        throw new IllegalArgumentException("Unknown pizza type: " + type);
    }

}
