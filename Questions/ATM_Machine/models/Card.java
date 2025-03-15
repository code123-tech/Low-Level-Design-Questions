package Questions.ATM_Machine.models;

public class Card {

    private int cardNumber;
    private int cvv;
    private int expiryDate;
    private String holderName;
    private int PIN_NUMBER = 112211;
    private UserBankAccount bankAccount;

    public boolean isPINCorrect(int pin){

        if (pin == PIN_NUMBER){
            return true;
        }

        return false;
    }


    public int getBalance(){
        return bankAccount.getBalance();
    }

    public void deductBankBalance(int ammount){
        bankAccount.withdrawBalance(ammount);
    }

    public void setBankAccount(UserBankAccount bankAccount){
        this.bankAccount = bankAccount;
    }

}
