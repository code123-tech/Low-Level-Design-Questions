package Questions.SplitWise.model.SplitTypes;

import java.util.List;

import Questions.SplitWise.model.Split;

public interface ExpenseSplit {

    void validateSplitRequest(List<Split> splitList, double totalAmount);

}
