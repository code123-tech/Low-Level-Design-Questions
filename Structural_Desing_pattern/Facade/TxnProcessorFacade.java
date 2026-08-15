package Structural_Desing_pattern.Facade;

import Structural_Desing_pattern.Facade.PaymentModeProcessors.PaymentModeProcessor;
import Structural_Desing_pattern.Facade.factory.PaymentModeProcessorFactory;
import Structural_Desing_pattern.Facade.model.PaymentMode;
import Structural_Desing_pattern.Facade.model.PaymentRequest;

public class TxnProcessorFacade {
    public void processTransaction(PaymentRequest paymentRequest, PaymentMode paymentMode){
        PaymentModeProcessor paymentModeProcessor = PaymentModeProcessorFactory.getPaymentModeProcessorBasedOnPaymentMode(paymentMode);
        paymentModeProcessor.validate(paymentRequest);
        paymentModeProcessor.preProcess(paymentRequest);
        paymentModeProcessor.process(paymentRequest);
        paymentModeProcessor.postProcess(paymentRequest);
    }
}
