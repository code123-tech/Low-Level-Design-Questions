package controller;

import java.util.List;

import Factory.SplitFactory;
import enums.ExpenseSplitType;
import model.Expense;
import model.Split;
import model.User;
import model.SplitTypes.ExpenseSplit;

public class ExpenseController {

    BalanceSheetController balanceSheetController;

    public ExpenseController(){
        this.balanceSheetController = new BalanceSheetController();
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails){

        ExpenseSplit expenseSplit = SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitDetails, expenseAmount);

        Expense newExpense = new Expense(expenseId, description, expenseAmount, paidByUser, splitType, splitDetails);
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser, splitDetails, expenseAmount);

        return newExpense;
    }

}
