package Facade.factory;

import Facade.PaymentModeProcessors.Impl.CardPaymentModeProcessor;
import Facade.PaymentModeProcessors.Impl.UPIPaymentModeProcessor;
import Facade.PaymentModeProcessors.Impl.WalletPaymentModeProcessor;
import Facade.PaymentModeProcessors.PaymentModeProcessor;
import Facade.model.PaymentMode;

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
