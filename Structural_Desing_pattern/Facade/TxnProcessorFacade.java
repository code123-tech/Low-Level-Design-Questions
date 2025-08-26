package Facade;

import Facade.PaymentModeProcessors.PaymentModeProcessor;
import Facade.factory.PaymentModeProcessorFactory;
import Facade.model.PaymentMode;
import Facade.model.PaymentRequest;

public class TxnProcessorFacade {
    public void processTransaction(PaymentRequest paymentRequest, PaymentMode paymentMode){
        PaymentModeProcessor paymentModeProcessor = PaymentModeProcessorFactory.getPaymentModeProcessorBasedOnPaymentMode(paymentMode);
        paymentModeProcessor.validate(paymentRequest);
        paymentModeProcessor.preProcess(paymentRequest);
        paymentModeProcessor.process(paymentRequest);
        paymentModeProcessor.postProcess(paymentRequest);
    }
}
