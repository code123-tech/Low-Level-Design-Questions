package Questions.ATM_Machine.ATMStates;

import Questions.ATM_Machine.models.ATM;
import Questions.ATM_Machine.models.Card;

public class CheckBalanceState extends ATMState {

    public CheckBalanceState(){}

    @Override
    public void displayBalance(ATM atm, Card card){
        System.out.println("Your balance is: " + card.getBalance());
        exit(atm);
    }

    @Override
    public void exit(ATM atm){
        returnCard();
        atm.setState(new IdleState());
        System.out.println("Exit happens.");
    }


    @Override
    public void returnCard(){
        System.out.println("Please collect your card.");
    }

}
