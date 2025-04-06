package model.SplitTypes;

import java.util.List;

import model.Split;

public interface ExpenseSplit {

    void validateSplitRequest(List<Split> splitList, double totalAmount);

}
