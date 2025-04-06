package model;

import java.util.ArrayList;
import java.util.List;

import controller.ExpenseController;
import enums.ExpenseSplitType;

public class Group {

    String groupId;
    String groupName;
    List<User> groupMembers;

    List<Expense> expenseList;
    ExpenseController expenseController;

    public Group(){
        groupMembers = new ArrayList<>();
        expenseList  = new ArrayList<>();
        expenseController = new ExpenseController();
    }

    public void addMember(User user){
        groupMembers.add(user);
    }

    public String getGroupId(){
        return groupId;
    }

    public void setGroupId(String groupId){
        this.groupId = groupId;
    }

    public void setGroupName(String groupName){
        this.groupName = groupName;
    }

    public Expense createExpense(String expenseId, String description, double expenseAmount, User paidByUser, ExpenseSplitType splitType, List<Split> splitDetails){

        Expense expense = expenseController.createExpense(expenseId, description, expenseAmount, paidByUser, splitType, splitDetails);
        expenseList.add(expense);
        return expense;
    }

}
