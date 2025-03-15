package Questions.ATM_Machine.CashWithdrawlChaining;

import Questions.ATM_Machine.models.ATM;

public class FiveHundredWithdrawlProcessor extends CashWithdrawlProcessor {

    public FiveHundredWithdrawlProcessor(CashWithdrawlProcessor nexCashWithdrawlProcessor) {
        super(nexCashWithdrawlProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {

        int noOfFiveHundredNotes = remainingAmount / 500;
        int remainingAmountAfterFiveHundredNotes = remainingAmount % 500;

        if(noOfFiveHundredNotes <= atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(noOfFiveHundredNotes);
        }

        else if(noOfFiveHundredNotes > atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            remainingAmountAfterFiveHundredNotes = (noOfFiveHundredNotes - atm.getNoOfFiveHundredNotes())*500;
        }

        if(remainingAmountAfterFiveHundredNotes != 0){
            super.withdraw(atm, remainingAmountAfterFiveHundredNotes);
        }
    }
}
