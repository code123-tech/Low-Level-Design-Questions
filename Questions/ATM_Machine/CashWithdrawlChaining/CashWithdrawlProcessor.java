package Questions.ATM_Machine.CashWithdrawlChaining;

import Questions.ATM_Machine.models.ATM;

public abstract class CashWithdrawlProcessor {

    CashWithdrawlProcessor nexCashWithdrawlProcessor;

    CashWithdrawlProcessor(CashWithdrawlProcessor nexCashWithdrawlProcessor){
        this.nexCashWithdrawlProcessor = nexCashWithdrawlProcessor;
    }

    public void withdraw(ATM atm, int remainingAmount){
        if(nexCashWithdrawlProcessor != null){
            nexCashWithdrawlProcessor.withdraw(atm, remainingAmount);
        }
    }

}
