package controller;

import java.util.List;
import java.util.Map;

import model.Balance;
import model.Split;
import model.User;
import model.UserExpenseBalanceSheet;

public class BalanceSheetController {

    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splits, double totalExpenseAmount){
        
        UserExpenseBalanceSheet paidByUserExpenseSheet = expensePaidBy.getUserExpenseBalanceSheet();
        paidByUserExpenseSheet.setTotalPayment(paidByUserExpenseSheet.getTotalPayment() + totalExpenseAmount);

        for(Split split: splits){

            User userOwe = split.getUser();
            double amountOwe = split.getAmountOwe();
            UserExpenseBalanceSheet oweUserExpenseSheet = userOwe.getUserExpenseBalanceSheet();

            if(expensePaidBy.getUserId().equals(userOwe.getUserId())){
                paidByUserExpenseSheet.setTotalYourExpense(paidByUserExpenseSheet.getTotalYourExpense() + amountOwe);
                continue;
            }

            paidByUserExpenseSheet.setTotalYouGetBack(paidByUserExpenseSheet.getTotalYouGetBack() + amountOwe);

            Balance userOweBalance;
            if(paidByUserExpenseSheet.getUserBalance().containsKey(userOwe.getUserId())){
                userOweBalance = paidByUserExpenseSheet.getUserBalance().get(userOwe.getUserId());
            }
            else{
                userOweBalance = new Balance();
                paidByUserExpenseSheet.getUserBalance().put(userOwe.getUserId(), userOweBalance);
            }

            userOweBalance.setAmountGetBack(userOweBalance.getAmountGetBack() + amountOwe);

            oweUserExpenseSheet.setTotalYouOwe(oweUserExpenseSheet.getTotalYouOwe() + amountOwe);
            oweUserExpenseSheet.setTotalYourExpense(oweUserExpenseSheet.getTotalYourExpense() + amountOwe);

            Balance userPaidBalance;
            if(oweUserExpenseSheet.getUserBalance().containsKey(expensePaidBy.getUserId())){
                userPaidBalance = oweUserExpenseSheet.getUserBalance().get(expensePaidBy.getUserId());
            }
            else{
                userPaidBalance = new Balance();
                oweUserExpenseSheet.getUserBalance().put(expensePaidBy.getUserId(), userPaidBalance);
            }

            userPaidBalance.setAmountOwe(userPaidBalance.getAmountOwe() + amountOwe);
        }

    }

    public void showBalanceSheetOfUser(User user){
        
        System.out.println("--------------------------------------------------");

        System.out.println("Balance Sheet of User: " + user.getUserId());

        UserExpenseBalanceSheet userExpenseBalanceSheet = user.getUserExpenseBalanceSheet();
        System.out.println("Total Your Expense: " + userExpenseBalanceSheet.getTotalYourExpense());
        System.out.println("Total You Get Back: " + userExpenseBalanceSheet.getTotalYouGetBack());
        System.out.println("Total You Owe: " + userExpenseBalanceSheet.getTotalYouOwe());
        System.out.println("Total Payment Made: " + userExpenseBalanceSheet.getTotalPayment());

        for(Map.Entry<String, Balance> entry: userExpenseBalanceSheet.getUserBalance().entrySet()){
            String userId = entry.getKey();
            Balance balance = entry.getValue();
            System.out.println("UserID: " + userId + " YouGetBack: " + balance.getAmountGetBack() + " and YouOwe: " + balance.getAmountOwe());
        }

        System.out.println("--------------------------------------------------");
    }
}
