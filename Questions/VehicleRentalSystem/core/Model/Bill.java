package Questions.VehicleRentalSystem.core.Model;

import Questions.VehicleRentalSystem.core.Reservation;
import Questions.VehicleRentalSystem.enums.BillStatus;

import java.util.UUID;

public class Bill {
    private String billId;
    private Reservation reservation;
    private Double totalAmount = 0.0;
    private BillStatus billStatus;

    public Bill(Reservation reservation){
        this.billId = UUID.randomUUID().toString();
        this.reservation = reservation;
        /**
         * Calculate bill amount based on reservation pickupTime, dropTime.
         */
        this.totalAmount = 100.0;
        this.billStatus = BillStatus.PENDING;
    }

    public String getBillId() {
        return billId;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public BillStatus getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(BillStatus billStatus) {
        this.billStatus = billStatus;
    }
}
