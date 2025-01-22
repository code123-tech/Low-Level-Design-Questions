package Questions.ParkingLots.ParkingLot2.model.Payment;

import java.time.LocalDateTime;

import Questions.ParkingLots.ParkingLot2.model.Common.EntityDefinition;
import Questions.ParkingLots.ParkingLot2.model.enums.PaymentStatus;

public class Payment extends EntityDefinition{

    private double amount;
    private String ticketId;
    private PaymentStatus paymentStatus;
    private LocalDateTime initiatedDate;
    private LocalDateTime completedDate;

    public Payment(String id, String ticketId, double amount){
        super(id);
        this.ticketId = ticketId;
        this.amount = amount;
    }

    public void completePayment(){
        this.initiatedDate = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PAID;
        this.completedDate = LocalDateTime.now();
    }
    
    public double getAmount() {
        return amount;
    }

    public String getTicketId() {
        return ticketId;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public LocalDateTime getInitiatedDate() {
        return initiatedDate;
    }

    public void setInitiatedDate(LocalDateTime initiatedDate) {
        this.initiatedDate = initiatedDate;
    }

    public LocalDateTime getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDateTime completedDate) {
        this.completedDate = completedDate;
    }
}
