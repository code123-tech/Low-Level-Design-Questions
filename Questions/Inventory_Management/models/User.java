package models;

import java.util.ArrayList;
import java.util.List;

public class User {

    public int userId;
    String userName;
    public Address address;
    Cart userCartDetails;
    List<Integer> orderIds;

    public User(){
        userCartDetails = new Cart();
        orderIds = new ArrayList<>();
    }

    public Cart getUserCart(){
        return userCartDetails;
    }

}
