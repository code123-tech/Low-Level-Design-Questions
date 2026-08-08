package Structural_Desing_pattern.Facade;

import Structural_Desing_pattern.Facade.model.PaymentMode;
import Structural_Desing_pattern.Facade.model.PaymentRequest;

public class Client {
    public static void main(String[] args) {
        TxnProcessorFacade txnProcessorFacade = new TxnProcessorFacade();
        testCardPayment(txnProcessorFacade);
        System.out.println("--------------------------");
        testUPIPayment(txnProcessorFacade);
        System.out.println("--------------------------");
        testWalletPayment(txnProcessorFacade);
    }

    private static void testWalletPayment(TxnProcessorFacade txnProcessorFacade) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setWalletData("PaytmWallet");
        paymentRequest.setAmount(300l);
        txnProcessorFacade.processTransaction(paymentRequest, PaymentMode.WALLET);
    }

    private static void testUPIPayment(TxnProcessorFacade txnProcessorFacade) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setUpiData("ABC@paytm.com");
        paymentRequest.setAmount(200l);
        txnProcessorFacade.processTransaction(paymentRequest, PaymentMode.UPI);
    }

    private static void testCardPayment(TxnProcessorFacade txnProcessorFacade) {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setCardData("ABC");
        paymentRequest.setAmount(100l);
        txnProcessorFacade.processTransaction(paymentRequest, PaymentMode.CARD);
    }
}
