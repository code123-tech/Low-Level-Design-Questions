package Questions.Inventory_Management.controller;

import java.util.List;

import Questions.Inventory_Management.models.Cart;
import Questions.Inventory_Management.models.Inventory;
import Questions.Inventory_Management.models.Order;
import Questions.Inventory_Management.models.ProductCategory;
import Questions.Inventory_Management.models.User;
import Questions.Inventory_Management.models.Warehouse;
import Questions.Inventory_Management.strategy.WarehouseSelectionStrategy;

public class ApplicationController {

    UserController1 userController;
    OrderController orderController;
    WarehouseController warehouseController;

    public ApplicationController(List<User> userList, List<Warehouse> warehouseList){

        this.userController = new UserController1(userList);
        this.orderController = new OrderController();
        this.warehouseController = new WarehouseController(warehouseList, null);
    }

    public User getUser(int userId){
        return userController.getUser(userId);
    }

    public Warehouse getWarehouse(WarehouseSelectionStrategy warehouseSelectionStrategy){
        return warehouseController.selectWarehouse(warehouseSelectionStrategy);
    }

    public Inventory getInventory(Warehouse warehouse){
        return warehouse.inventory;
    }

    public void addProductToCart(User user, ProductCategory product, int count){
        Cart cart = user.getUserCart();
        cart.addItemInCart(product.productCategoryId, count);
    }

    public Order placeOrder(User user, Warehouse warehouse){
        return orderController.createOrder(user, warehouse);
    }

    public void checkout(Order order){
        order.checkout();
    }

}
