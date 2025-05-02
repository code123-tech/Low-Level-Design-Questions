package models;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProductCategory {

    public int productCategoryId;
    public String categoryName;
    public Deque<Product> products = new ArrayDeque<>();
    public double price;

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProduct(int count){
        for(int i = 0; i < count; i++){
            if(products.size() > 0){
                products.pop();
            }
        }
    }

}  
