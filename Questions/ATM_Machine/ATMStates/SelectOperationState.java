package Questions.ATM_Machine.ATMStates;

import Questions.ATM_Machine.models.ATM;
import Questions.ATM_Machine.models.Card;
import Questions.ATM_Machine.models.TransactionType;

public class SelectOperationState extends ATMState {

    public SelectOperationState(){
        showOperations();
    }

    @Override
    public void selectOperation(ATM atm, Card card, TransactionType operation){

        switch (operation) {
            case CASH_WITHDRAWL:
                atm.setState(new CashWithdrawlState());
                break;

            case CHECK_BALANCE:
                atm.setState(new CheckBalanceState());
                break;
        
            default:
                System.out.println("Invalid operation.");
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


    private void showOperations(){
        System.out.println("Please select the operation you want to perform.");
        TransactionType.showAllTransactionTypes();
    }
}
