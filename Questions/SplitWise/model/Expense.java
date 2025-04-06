package model;

import java.util.ArrayList;
import java.util.List;

import enums.ExpenseSplitType;

public class Expense {

    String expenseId;
    String description;
    double expenseAmount;
    User paidByUser;
    ExpenseSplitType splitType;
    List<Split> splitDetails = new ArrayList<>();

    public Expense(String expenseId, String description, double expenseAmount, User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails){

        this.expenseId = expenseId;
        this.description = description;
        this.expenseAmount = expenseAmount;
        this.paidByUser = paidByUser;
        this.splitType = splitType;
        this.splitDetails.addAll(splitDetails);
    }

}
