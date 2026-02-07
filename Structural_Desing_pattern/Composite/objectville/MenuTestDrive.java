package Structural_Desing_pattern.Composite.objectville;

public class MenuTestDrive {

    public static void main(String[] args) {

        // Menus (nodes)
        MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
        MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
        MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");

        MenuComponent dessertMenu = new Menu("DESSERT MENU", "Dessert of course!");

        // Root (über menu)
        MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");
        allMenus.add(pancakeHouseMenu);
        allMenus.add(dinerMenu);
        allMenus.add(cafeMenu);

        // Add a submenu
        dinerMenu.add(dessertMenu);

        // Add items (leaves)
        pancakeHouseMenu.add(new MenuItem(
                "K&B's Pancake Breakfast",
                "Pancakes with scrambled eggs and toast",
                true, 2.99));

        pancakeHouseMenu.add(new MenuItem(
                "Regular Pancake Breakfast",
                "Pancakes with fried eggs, sausage",
                false, 2.99));

        dinerMenu.add(new MenuItem(
                "Vegetarian BLT",
                "(Fakin') Bacon with lettuce & tomato on whole wheat",
                true, 2.99));

        dinerMenu.add(new MenuItem(
                "Hot Dog",
                "A hot dog, with sauerkraut, relish, onions, topped with cheese",
                false, 3.05));

        dessertMenu.add(new MenuItem(
                "Apple Pie",
                "Apple pie with a flakey crust, topped with vanilla ice cream",
                true, 1.59));

        cafeMenu.add(new MenuItem(
                "Veggie Burger and Air Fries",
                "Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
                true, 3.99));

        // Client
        Waitress waitress = new Waitress(allMenus);
        waitress.printMenu();
    }
}

