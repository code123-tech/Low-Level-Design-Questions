package Structural_Desing_pattern.Facade.PaymentModeProcessors.Impl;

import Structural_Desing_pattern.Facade.PaymentModeProcessors.PaymentModeProcessor;
import Structural_Desing_pattern.Facade.model.PaymentRequest;

public class UPIPaymentModeProcessor  implements PaymentModeProcessor {
    @Override
    public void validate(PaymentRequest paymentRequest) {
        System.out.println("UPIPayment: Validating Details...");
    }

    @Override
    public void preProcess(PaymentRequest paymentRequest) {
        System.out.println("UPIPayment: Loading txn details in DB...");
    }

    @Override
    public void process(PaymentRequest paymentRequest) {
        System.out.println("UPIPayment: Respective Bank Call for UPI Txn...");
    }

    @Override
    public void postProcess(PaymentRequest paymentRequest) {
        System.out.println("UPIPayment: Updating Response received Bank...");
    }
}
