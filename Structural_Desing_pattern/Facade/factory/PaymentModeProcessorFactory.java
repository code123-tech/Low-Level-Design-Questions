package Structural_Desing_pattern.Facade.factory;

import Structural_Desing_pattern.Facade.PaymentModeProcessors.Impl.CardPaymentModeProcessor;
import Structural_Desing_pattern.Facade.PaymentModeProcessors.Impl.UPIPaymentModeProcessor;
import Structural_Desing_pattern.Facade.PaymentModeProcessors.Impl.WalletPaymentModeProcessor;
import Structural_Desing_pattern.Facade.PaymentModeProcessors.PaymentModeProcessor;
import Structural_Desing_pattern.Facade.model.PaymentMode;

public class PaymentModeProcessorFactory {

    public static PaymentModeProcessor getPaymentModeProcessorBasedOnPaymentMode(PaymentMode paymentMode){
        switch (paymentMode){
            case CARD:
                return new CardPaymentModeProcessor();
            case UPI:
                return new UPIPaymentModeProcessor();
            case WALLET:
                return new WalletPaymentModeProcessor();
            default:
                throw new RuntimeException("Given Payment Mode is not integrated now!!");
        }
    }
}
