package Bridge.PaymentPlatformsHierarchy;

import Bridge.BankHierarchy.Bank;

abstract public class PaymentPlatform {
    public Bank bank;

    public PaymentPlatform(Bank bank){
        this.bank = bank;
    }

    public abstract void makePayment(Long amount);
}
