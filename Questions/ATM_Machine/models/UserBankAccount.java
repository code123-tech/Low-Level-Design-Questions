package Questions.ATM_Machine.models;

public class UserBankAccount {

    private int balance;

    public void withdrawBalance(int ammount){
        this.balance = Math.max(0, this.balance - ammount);
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }
}
