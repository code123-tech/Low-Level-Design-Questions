package models;

import java.util.Map;

import enums.OrderStatus;
import models.Payment.Payment;
import models.Payment.PaymentMode;
import models.Payment.UPIPaymentMode;

public class Order {

    User user;
    Address delieveryAddress;
    Map<Integer, Integer> productCategoryAndCountMap;
    Warehouse warehouse;
    Invoice invoice;
    Payment payment;
    OrderStatus orderStatus;

    public Order(User user, Warehouse warehouse){
        this.user = user;
        this.productCategoryAndCountMap = user.getUserCart().getCartItems();
        this.warehouse = warehouse;
        this.delieveryAddress = user.address;
        invoice = new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkout(){

        warehouse.removeItems(productCategoryAndCountMap);

        boolean isPaymentSuccess = makePayment(new UPIPaymentMode());

        if(isPaymentSuccess){
            user.getUserCart().emptyCart();
        }else{
            warehouse.addItemToInventory(productCategoryAndCountMap);
        }
    }

    public boolean makePayment(PaymentMode paymentMode){
        payment = new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateOrderInvoice(){
        invoice.generateInvoice(this);
    }
}
