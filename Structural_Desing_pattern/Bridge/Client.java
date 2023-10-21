package Structural_Desing_pattern.Bridge;

import Structural_Desing_pattern.Bridge.BankHierarchy.Bank;
import Structural_Desing_pattern.Bridge.BankHierarchy.Impl.AXISBank;
import Structural_Desing_pattern.Bridge.BankHierarchy.Impl.ICICIBank;
import Structural_Desing_pattern.Bridge.BankHierarchy.Impl.SBIBank;
import Structural_Desing_pattern.Bridge.PaymentPlatformsHierarchy.Impl.CardPaymentPlatform;
import Structural_Desing_pattern.Bridge.PaymentPlatformsHierarchy.Impl.NetBankingPaymentPlatform;
import Structural_Desing_pattern.Bridge.PaymentPlatformsHierarchy.Impl.UPIPaymentPlatform;
import Structural_Desing_pattern.Bridge.PaymentPlatformsHierarchy.PaymentPlatform;

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
