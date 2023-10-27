package Structural_Desing_pattern.Facade.PaymentModeProcessors.Impl;

import Structural_Desing_pattern.Facade.PaymentModeProcessors.PaymentModeProcessor;
import Structural_Desing_pattern.Facade.model.PaymentRequest;

public class CardPaymentModeProcessor  implements PaymentModeProcessor {

    @Override
    public void validate(PaymentRequest paymentRequest) {
        System.out.println("CardPayment: Validating Card Details...");
    }

    @Override
    public void preProcess(PaymentRequest paymentRequest) {
        System.out.println("CardPayment: Loading txn details in DB...");
    }

    @Override
    public void process(PaymentRequest paymentRequest) {
        System.out.println("CardPayment: Respective Bank Call for Card Txn...");
    }

    @Override
    public void postProcess(PaymentRequest paymentRequest) {
        System.out.println("CardPayment: Updating Response received Bank...");
    }
}
