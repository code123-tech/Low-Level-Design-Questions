package models;

import java.util.Map;

public class Warehouse {

    public Inventory inventory;
    public Address address;

    public void removeItems(Map<Integer, Integer> count){

        inventory.removeItems(count);
    }

    public void addItemToInventory(Map<Integer, Integer> productCategoryAndCountMap){
        
    }

}
