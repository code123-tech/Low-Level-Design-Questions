package creational_Desing_pattern.factory.PizzaStore;

public class Main {
    public static void main(String[] args) {
        PizzaStore nyStore = new NYPizzaStore();
        PizzaStore chicagoStore = new ChicagoPizzaStore();

        nyStore.orderPizza("cheese");
        System.out.println();
        chicagoStore.orderPizza("cheese");
    }
}
