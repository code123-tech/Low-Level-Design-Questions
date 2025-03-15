package Questions.ATM_Machine.ATMStates;

import Questions.ATM_Machine.models.ATM;
import Questions.ATM_Machine.models.Card;
import Questions.ATM_Machine.models.TransactionType;

public abstract class ATMState {

    public void insertCard(ATM atm, Card card){
        System.out.println("You can't insert the card right now.");
    }

    public void authenticatePIN(ATM atm, Card card, int pin){
        System.out.println("You can't authenticate the PIN right now.");
    }

    public void selectOperation(ATM atm, Card card, TransactionType operation){
        System.out.println("You can't select the operation right now.");
    }

    public void cashWithdrawl(ATM atm, Card card, int withdrawlAmmount){
        System.out.println("You can't withdraw cash right now.");
    }

    public void displayBalance(ATM atm, Card card){
        System.out.println("You can't display balance right now.");
    }

    public void returnCard(){
        System.out.println("You can't return the card right now.");
    }

    public void exit(ATM atm){
        System.out.println("You can't exit right now.");
    }
    
}
