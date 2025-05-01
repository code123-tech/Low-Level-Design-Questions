package models.Payment;

public class UPIPaymentMode implements PaymentMode {

    @Override
    public boolean makePayment() {
        // Logic to process UPI payment
        System.out.println("Processing UPI payment...");
        return true; // Assuming payment is successful
    }
}
