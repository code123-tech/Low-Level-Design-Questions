package Bridge.PaymentPlatformsHierarchy.Impl;

import Bridge.BankHierarchy.Bank;
import Bridge.PaymentPlatformsHierarchy.PaymentPlatform;

public class UPIPaymentPlatform extends PaymentPlatform {
    private Long amount;

    public UPIPaymentPlatform(Bank bank){
        super(bank);
    }

    @Override
    public void makePayment(Long amount) {
        this.amount = amount;
        System.out.println("UPI Payment of amount: " + this.amount + " is processing.");
        bank.makePayment(amount);
    }
}
