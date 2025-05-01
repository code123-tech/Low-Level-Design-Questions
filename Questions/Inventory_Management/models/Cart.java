package models;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    Map<Integer, Integer> productCategoryIdVsCountMap;

    Cart() {
        this.productCategoryIdVsCountMap = new HashMap<>();
    }

    public void addItemInCart(int productCategoryId, int count){

        if(productCategoryIdVsCountMap.containsKey(productCategoryId)){
            int noOfItemsInCart = productCategoryIdVsCountMap.get(productCategoryId);
            productCategoryIdVsCountMap.put(productCategoryId, noOfItemsInCart + count); 
        }else{
            productCategoryIdVsCountMap.put(productCategoryId, count);
        }
    }

    public void removeItemFromCart(int productCategoryId, int count){

        if(productCategoryIdVsCountMap.containsKey(productCategoryId)){
            
            int noOfItemsInCart = productCategoryIdVsCountMap.get(productCategoryId);
            if(count - noOfItemsInCart == 0){
                productCategoryIdVsCountMap.remove(productCategoryId);
            }else{
                productCategoryIdVsCountMap.put(productCategoryId, noOfItemsInCart - count);
            }
        }
    }

    public void emptyCart(){
        productCategoryIdVsCountMap.clear();
    }

    public Map<Integer, Integer> getCartItems(){
        return productCategoryIdVsCountMap;
    }

}
