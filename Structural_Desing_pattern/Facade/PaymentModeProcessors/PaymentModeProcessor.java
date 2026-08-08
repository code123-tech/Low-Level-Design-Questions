package Structural_Desing_pattern.Facade.PaymentModeProcessors;

import Structural_Desing_pattern.Facade.model.PaymentRequest;

public interface PaymentModeProcessor {
    void validate(PaymentRequest paymentRequest);
    void preProcess(PaymentRequest paymentRequest);
    void process(PaymentRequest paymentRequest);
    void postProcess(PaymentRequest paymentRequest);
}
