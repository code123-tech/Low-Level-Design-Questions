package Structural_Desing_pattern.Bridge.PaymentPlatformsHierarchy;

import Structural_Desing_pattern.Bridge.BankHierarchy.Bank;

abstract public class PaymentPlatform {
    public Bank bank;

    public PaymentPlatform(Bank bank){
        this.bank = bank;
    }

    public abstract void makePayment(Long amount);
}
