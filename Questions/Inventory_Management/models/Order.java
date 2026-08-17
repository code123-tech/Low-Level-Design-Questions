package Questions.Inventory_Management.models;

import java.util.Map;

import Questions.Inventory_Management.enums.OrderStatus;
import Questions.Inventory_Management.models.Payment.Payment;
import Questions.Inventory_Management.models.Payment.PaymentMode;
import Questions.Inventory_Management.models.Payment.UPIPaymentMode;

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
