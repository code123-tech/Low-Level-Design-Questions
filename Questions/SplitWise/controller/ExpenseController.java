package Questions.SplitWise.controller;

import java.util.List;

import Questions.SplitWise.Factory.SplitFactory;
import Questions.SplitWise.enums.ExpenseSplitType;
import Questions.SplitWise.model.Expense;
import Questions.SplitWise.model.Split;
import Questions.SplitWise.model.User;
import Questions.SplitWise.model.SplitTypes.ExpenseSplit;

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
