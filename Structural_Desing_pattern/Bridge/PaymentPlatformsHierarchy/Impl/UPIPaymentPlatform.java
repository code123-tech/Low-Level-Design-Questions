package Structural_Desing_pattern.Bridge.PaymentPlatformsHierarchy.Impl;

import Structural_Desing_pattern.Bridge.BankHierarchy.Bank;
import Structural_Desing_pattern.Bridge.PaymentPlatformsHierarchy.PaymentPlatform;

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
