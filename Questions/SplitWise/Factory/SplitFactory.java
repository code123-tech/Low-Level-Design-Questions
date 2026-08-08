package Questions.SplitWise.Factory;

import Questions.SplitWise.enums.ExpenseSplitType;
import Questions.SplitWise.model.SplitTypes.EqualExpenseSplit;
import Questions.SplitWise.model.SplitTypes.ExpenseSplit;
import Questions.SplitWise.model.SplitTypes.PercentageExpenseSplit;
import Questions.SplitWise.model.SplitTypes.UnequalExpenseSplit;

public class SplitFactory {

    private static final ExpenseSplit equalExpenseSplit = new EqualExpenseSplit();
    private static final ExpenseSplit unEqualExpenseSplitWithGroup = new UnequalExpenseSplit();
    private static final ExpenseSplit percentageExpenseSplit = new PercentageExpenseSplit();

    public static ExpenseSplit getSplitObject(ExpenseSplitType splitType){

        switch (splitType) {
            
            case EQUAL:
                return equalExpenseSplit;

            case UNEQUAL:
                return unEqualExpenseSplitWithGroup;
            
            case PERCENTAGE:
                return percentageExpenseSplit;
        }

        throw new IllegalArgumentException("Invalid split type");

    }

}
