package Structural_Desing_pattern.Bridge.BankHierarchy.Impl;

import Structural_Desing_pattern.Bridge.BankHierarchy.Bank;

public class AXISBank implements Bank {
    @Override
    public void makePayment(Long amount) {
        System.out.println("Payment of amount: " + amount + " is done from AXIS Bank");
    }
}
