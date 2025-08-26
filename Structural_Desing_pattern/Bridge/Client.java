package Bridge;

import Bridge.BankHierarchy.Bank;
import Bridge.BankHierarchy.Impl.AXISBank;
import Bridge.BankHierarchy.Impl.ICICIBank;
import Bridge.BankHierarchy.Impl.SBIBank;
import Bridge.PaymentPlatformsHierarchy.Impl.CardPaymentPlatform;
import Bridge.PaymentPlatformsHierarchy.Impl.NetBankingPaymentPlatform;
import Bridge.PaymentPlatformsHierarchy.Impl.UPIPaymentPlatform;
import Bridge.PaymentPlatformsHierarchy.PaymentPlatform;

public class Client {
    public static void main(String[] args) {
        Bank sbiBank = new SBIBank();
        Bank iciciBank = new ICICIBank();
        Bank axisBank = new AXISBank();

        PaymentPlatform upiPaymentPlatformSbiBank = new UPIPaymentPlatform(sbiBank);
        PaymentPlatform upiPaymentPlatformIciciBank = new UPIPaymentPlatform(iciciBank);
        PaymentPlatform cardPaymentPlatformSbiBank = new CardPaymentPlatform(sbiBank);
        PaymentPlatform netBankingPaymentPlatformSbiBank = new NetBankingPaymentPlatform(axisBank);

        upiPaymentPlatformSbiBank.makePayment(100L);
        System.out.println("------");
        upiPaymentPlatformIciciBank.makePayment(200L);
        System.out.println("------");
        cardPaymentPlatformSbiBank.makePayment(300L);
        System.out.println("------");
        netBankingPaymentPlatformSbiBank.makePayment(400L);
    }
}
