package Bridge.BankHierarchy.Impl;

import Bridge.BankHierarchy.Bank;

public class ICICIBank implements Bank {
    @Override
    public void makePayment(Long amount) {
        System.out.println("Payment of amount: " + amount + " is done from ICICI Bank");
    }
}
