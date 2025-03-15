package Questions.ATM_Machine.ATMStates;

import Questions.ATM_Machine.CashWithdrawlChaining.CashWithdrawlProcessor;
import Questions.ATM_Machine.CashWithdrawlChaining.FiveHundredWithdrawlProcessor;
import Questions.ATM_Machine.CashWithdrawlChaining.OneHundredWithdrawlProcessor;
import Questions.ATM_Machine.CashWithdrawlChaining.TwoThousandWithdrawlProcessor;
import Questions.ATM_Machine.models.ATM;
import Questions.ATM_Machine.models.Card;

public class CashWithdrawlState extends ATMState {

    private CashWithdrawlProcessor cashWithdrawlProcessor;

    public CashWithdrawlState(){
        System.out.println("Please enter the amount you want to withdraw.");
        cashWithdrawlProcessor = new TwoThousandWithdrawlProcessor(new FiveHundredWithdrawlProcessor(new OneHundredWithdrawlProcessor(null)));
    }

    public void cashWithdrawl(ATM atm, Card card, int withdrawlAmmount){
        
        if(atm.getAtmBalance() < withdrawlAmmount){
            System.out.println("ATM doesn't have enough balance.");
            exit(atm);
        }
        else if(card.getBalance() < withdrawlAmmount){
            System.out.println("You don't have enough balance.");
            exit(atm);
        }
        else{

            card.deductBankBalance(withdrawlAmmount);
            atm.deductAtmBalance(withdrawlAmmount);

            cashWithdrawlProcessor.withdraw(atm, withdrawlAmmount);
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
