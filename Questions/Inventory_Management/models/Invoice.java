package models;

public class Invoice {

    int totalItemPrice;
    int totalTax;
    int totalFinalPrice;

    public void generateInvoice(Order order){

        totalItemPrice = 200;
        totalTax = 20;
        totalFinalPrice = totalItemPrice + totalTax;
    }

}
