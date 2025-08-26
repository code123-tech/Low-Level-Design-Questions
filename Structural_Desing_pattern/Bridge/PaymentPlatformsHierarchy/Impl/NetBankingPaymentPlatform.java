package Bridge.PaymentPlatformsHierarchy.Impl;

import Bridge.BankHierarchy.Bank;
import Bridge.PaymentPlatformsHierarchy.PaymentPlatform;

public class NetBankingPaymentPlatform extends PaymentPlatform {
    private Long amount;

    public NetBankingPaymentPlatform(Bank bank){
        super(bank);
    }

    @Override
    public void makePayment(Long amount) {
        this.amount = amount;
        System.out.println("NetBanking Payment of amount: " + this.amount + " is processing.");
        bank.makePayment(amount);
    }
}
