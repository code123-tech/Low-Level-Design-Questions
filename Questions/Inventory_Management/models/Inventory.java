package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Inventory {

    public List<ProductCategory> productCategoryList;

    public Inventory(){
        productCategoryList = new ArrayList<>();
    }

    public void addCategory(int categoryId, String name, double price){
        
        ProductCategory productCategory = new ProductCategory();
        productCategory.price = price;
        productCategory.categoryName = name;
        productCategory.productCategoryId = categoryId;

        productCategoryList.add(productCategory);
    }

    public void addProduct(Product product, int productCategoryId){

        ProductCategory category = null;

        for(ProductCategory productCategory: productCategoryList){
            if(productCategory.productCategoryId == productCategoryId){
                category = productCategory;
                break;
            }
        }

        if(category != null){
            category.addProduct(product);
        }
    }

    public void removeItems(Map<Integer, Integer> productCategoryAndCountMap){

        for(Map.Entry<Integer, Integer> entry : productCategoryAndCountMap.entrySet())
        {
            ProductCategory category = getProductCategoryById(entry.getKey());
            category.removeProduct(entry.getValue());
        }
    }


    private ProductCategory getProductCategoryById(int categoryId){

        for(ProductCategory productCategory : productCategoryList){

            if(productCategory.productCategoryId == categoryId){
                return productCategory;
            }
        }

        return null;
    }


}
