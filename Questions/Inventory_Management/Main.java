import java.util.ArrayList;
import java.util.List;

import controller.ApplicationController;
import models.Address;
import models.Inventory;
import models.Order;
import models.Product;
import models.ProductCategory;
import models.User;
import models.Warehouse;
import strategy.NearestWarehouseSelectionStrategy;

public class Main { 

    public static void main(String[] args) {
        
        Main mainObj = new Main();

        // create warehouse
        List<Warehouse> warehouseList = new ArrayList<>();
        warehouseList.add(mainObj.addWarehouseAndItsInventory());

        // user
        List<User> userList = new ArrayList<>();
        userList.add(mainObj.createUser());

        // initial data
        ApplicationController applicationController = new ApplicationController(userList, warehouseList);

        mainObj.runFlow(applicationController, 1);

    }


    private Warehouse addWarehouseAndItsInventory(){

        Warehouse warehouse = new Warehouse();
        Inventory inventory = new Inventory();

        inventory.addCategory(001, "Product Category 1", 100);
        inventory.addCategory(002, "Product Category 2", 200);

        Product product1 = new Product();
        product1.productId = 1;
        product1.productName = "Product 1";

        Product product2 = new Product();
        product2.productId = 2;
        product2.productName = "Product 2";

        Product product3 = new Product();
        product3.productId = 3;
        product3.productName = "Product 3";

        inventory.addProduct(product1, 001);
        inventory.addProduct(product2, 001);
        inventory.addProduct(product3, 002);

        warehouse.inventory = inventory;
        
        return warehouse;
    }

    private User createUser(){

        User user = new User();
        user.userId = 1;
        user.userName = "User 1";
        user.address = new Address(230011, "city", "State");

        return user;
    }


    private void runFlow(ApplicationController applicationController, int userId){

        User user = applicationController.getUser(userId);

        Warehouse warehouse = applicationController.getWarehouse(new NearestWarehouseSelectionStrategy());

        Inventory inventory = applicationController.getInventory(warehouse);
        
        ProductCategory productCategoryIWantToOrder = null;
        for(ProductCategory productCategory : inventory.productCategoryList){

            if(productCategory.categoryName.equals("Product Category 1")){
                productCategoryIWantToOrder = productCategory;
            }
        }

        applicationController.addProductToCart(user, productCategoryIWantToOrder, 2);

        Order order = applicationController.placeOrder(user, warehouse);

        applicationController.checkout(order);

    }

}
