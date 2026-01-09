package creational_Desing_pattern.factory.PizzaStore;

import creational_Desing_pattern.factory.PizzaStore.Factory.Pizza;

abstract public class PizzaStore {

    public void orderPizza(String type) {

        Pizza pizza = createPizza(type);
        System.out.println("Ordered a " + pizza.getName());

        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
    }

    public abstract Pizza createPizza(String type);

}
