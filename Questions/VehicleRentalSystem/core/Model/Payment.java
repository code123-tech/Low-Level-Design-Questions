package Questions.VehicleRentalSystem.core.Model;

import Questions.VehicleRentalSystem.enums.BillStatus;
import Questions.VehicleRentalSystem.enums.PaymentMode;

import java.util.UUID;

public class Payment {
    private String paymentId;
    private Bill bill;
    private PaymentMode paymentMode;

    public Payment(){
        this.paymentId = UUID.randomUUID().toString();
    }

    public String getPaymentId() {
        return paymentId;
    }

    public Bill getBill() {
        return bill;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void makePayment(Bill bill, PaymentMode paymentMode){
        this.bill = bill;
        this.paymentMode = paymentMode;
        this.bill.setBillStatus(BillStatus.PAID);

        System.out.println("Paid Rs: " + this.bill.getTotalAmount() + " via payment mode: "  + paymentMode.toString() + " is success.");
        System.out.println("Your reservation is success.");
    }
}
