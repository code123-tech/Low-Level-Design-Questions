package Questions.ATM_Machine.CashWithdrawlChaining;

import Questions.ATM_Machine.models.ATM;

public class OneHundredWithdrawlProcessor extends CashWithdrawlProcessor {

    public OneHundredWithdrawlProcessor(CashWithdrawlProcessor nexCashWithdrawlProcessor) {
        super(nexCashWithdrawlProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {

        int noOfOneHundredNotes = remainingAmount / 100;
        int remainingAmountAfterOneHundredNotes = remainingAmount % 100;

        if(noOfOneHundredNotes <= atm.getNoOfOneHundredNotes()){
            atm.deductOneHundredNotes(noOfOneHundredNotes);
        }

        else if(noOfOneHundredNotes > atm.getNoOfOneHundredNotes()){
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            remainingAmountAfterOneHundredNotes = (noOfOneHundredNotes - atm.getNoOfOneHundredNotes())*100;
        }

        if(remainingAmountAfterOneHundredNotes != 0){
            super.withdraw(atm, remainingAmountAfterOneHundredNotes);
        }
    }
}
