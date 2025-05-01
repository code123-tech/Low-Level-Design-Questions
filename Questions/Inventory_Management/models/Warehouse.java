package models;

import java.util.Map;

public class Warehouse {

    Inventory inventory;
    Address address;

    public void removeItems(Map<Integer, Integer> count){

        inventory.removeItems(count);
    }

    public void addItemToInventory(Map<Integer, Integer> productCategoryAndCountMap){
        
    }

}
