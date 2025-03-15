package Questions.ATM_Machine.CashWithdrawlChaining;

import Questions.ATM_Machine.models.ATM;

public class TwoThousandWithdrawlProcessor extends CashWithdrawlProcessor {

    public TwoThousandWithdrawlProcessor(CashWithdrawlProcessor nexCashWithdrawlProcessor) {
        super(nexCashWithdrawlProcessor);
    }

    @Override
    public void withdraw(ATM atm, int remainingAmount) {

        int noOfTwoThousandNotes = remainingAmount / 2000;
        int remainingAmountAfterTwoThousandNotes = remainingAmount % 2000;

        if(noOfTwoThousandNotes <= atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(noOfTwoThousandNotes);
        }

        else if(noOfTwoThousandNotes > atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            remainingAmountAfterTwoThousandNotes = (noOfTwoThousandNotes - atm.getNoOfTwoThousandNotes())*2000;
        }

        if(remainingAmountAfterTwoThousandNotes != 0){
            super.withdraw(atm, remainingAmountAfterTwoThousandNotes);
        }
    }
}
