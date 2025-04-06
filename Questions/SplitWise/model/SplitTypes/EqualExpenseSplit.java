package model.SplitTypes;

import java.util.List;

import model.Split;

public class EqualExpenseSplit implements ExpenseSplit{

    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {

        // check each split is equal
        double amountToBePaid = totalAmount/splitList.size();

        for(Split split : splitList){
            if(split.getAmountOwe() != amountToBePaid){
                throw new IllegalArgumentException("Split amount is not equal");
            }
        }
    }

}
