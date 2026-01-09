package creational_Desing_pattern.factory.PizzaStore;

import creational_Desing_pattern.factory.PizzaStore.Factory.ChicagoStyleCheesePizza;
import creational_Desing_pattern.factory.PizzaStore.Factory.Pizza;

public class ChicagoPizzaStore extends PizzaStore{

    @Override
    public Pizza createPizza(String type) {

        if(type.equals("cheese")){
            return new ChicagoStyleCheesePizza();
        }

        throw new IllegalArgumentException("Unknown pizza type: " + type);

    }

}
