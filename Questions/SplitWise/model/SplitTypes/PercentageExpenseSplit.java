package model.SplitTypes;

import java.util.List;

import model.Split;

public class PercentageExpenseSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {

        // check if total amount of splits is equal to 100%
        double totalSplittedAmount = 0;
        for(Split split : splitList){
            totalSplittedAmount += split.getAmountOwe();
        }

        double totalPercentageAmount = 0;
        for(Split split : splitList){
            totalPercentageAmount += totalAmount * split.getPercentage() / 100;
        }

        if(totalSplittedAmount != totalPercentageAmount){
            throw new IllegalArgumentException("Total amount of splits is not equal to total amount");
        }
    }

}
