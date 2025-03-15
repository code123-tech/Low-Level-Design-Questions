package Questions.ATM_Machine.ATMStates;

import Questions.ATM_Machine.models.ATM;
import Questions.ATM_Machine.models.Card;

public class IdleState extends ATMState{

    @Override
    public void insertCard(ATM atm, Card card){
        System.out.println("Card is inserted.");
        atm.setState(new HasCardState());
    }
}
