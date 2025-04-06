package model.SplitTypes;

import java.util.List;

import model.Split;

public class UnequalExpenseSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {

        // check all the unequal split amount is equal to total amount
        double totalSplitAmount = 0;
        for(Split split : splitList){
            totalSplitAmount += split.getAmountOwe();
        }

        if(totalSplitAmount != totalAmount){
            throw new IllegalArgumentException("Total amount of splits is not equal to total amount");
        }
    }

}
