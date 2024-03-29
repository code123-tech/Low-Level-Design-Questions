package Structural_Desing_pattern.Facade.PaymentModeProcessors.Impl;

import Structural_Desing_pattern.Facade.PaymentModeProcessors.PaymentModeProcessor;
import Structural_Desing_pattern.Facade.model.PaymentRequest;

public class WalletPaymentModeProcessor implements PaymentModeProcessor {
    @Override
    public void validate(PaymentRequest paymentRequest) {
        System.out.println("WalletPayment: Validating Details...");
    }

    @Override
    public void preProcess(PaymentRequest paymentRequest) {
        System.out.println("WalletPayment: Loading txn details in DB...");
    }

    @Override
    public void process(PaymentRequest paymentRequest) {
        System.out.println("WalletPayment: Respective Bank Call for WALLET Txn...");
    }

    @Override
    public void postProcess(PaymentRequest paymentRequest) {
        System.out.println("WalletPayment: Updating Response received Bank...");
    }
}
