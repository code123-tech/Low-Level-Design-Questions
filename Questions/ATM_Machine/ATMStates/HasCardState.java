package Questions.ATM_Machine.ATMStates;

import Questions.ATM_Machine.models.ATM;
import Questions.ATM_Machine.models.Card;

public class HasCardState extends ATMState{

    public HasCardState(){
        System.out.println("Please enter your card PIN number.");
    }

    @Override
    public void authenticatePIN(ATM atm, Card card, int pin){

    
        if(card.isPINCorrect(pin)){
            atm.setState(new SelectOperationState());
        }
        else{
            System.out.println("PIN is incorrect.");
            exit(atm);
        }
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
