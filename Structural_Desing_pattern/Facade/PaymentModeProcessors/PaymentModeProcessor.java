package Facade.PaymentModeProcessors;

import Facade.model.PaymentRequest;

public interface PaymentModeProcessor {
    void validate(PaymentRequest paymentRequest);
    void preProcess(PaymentRequest paymentRequest);
    void process(PaymentRequest paymentRequest);
    void postProcess(PaymentRequest paymentRequest);
}
