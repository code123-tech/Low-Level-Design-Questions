package models.Payment;

public class CardPaymentMode implements PaymentMode {

    @Override
    public boolean makePayment() {
        // Logic to process card payment
        System.out.println("Processing card payment...");
        return true; // Assuming payment is successful
    }

}
