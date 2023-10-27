package Structural_Desing_pattern.Facade.model;

public class PaymentRequest {
    private String upiData;
    private String cardData;
    private String walletData;
    private Long amount;

    public String getUpiData() {
        return upiData;
    }

    public void setUpiData(String upiData) {
        this.upiData = upiData;
    }

    public String getCardData() {
        return cardData;
    }

    public void setCardData(String cardData) {
        this.cardData = cardData;
    }

    public String getWalletData() {
        return walletData;
    }

    public void setWalletData(String walletData) {
        this.walletData = walletData;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
