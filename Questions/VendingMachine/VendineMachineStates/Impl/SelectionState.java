package Questions.VendingMachine.VendineMachineStates.Impl;

import java.util.List;
import java.util.Scanner;

import Questions.VendingMachine.VendineMachineStates.State;
import Questions.VendingMachine.enums.Coin;
import Questions.VendingMachine.models.Item;
import Questions.VendingMachine.models.VendingMachine;

public class SelectionState implements State{

    public SelectionState() {
        System.out.println("Vending Machine is in Selection State");
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("can not click on insert cash button in selection state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("can not insert coin in selection state");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) throws Exception {
        System.out.println("Already in selection state...");
        return;
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int code) throws Exception {
        
        Item item = vendingMachine.getInventory().getItem(code);
        
        int totalMoneyPaid = vendingMachine.getCoins().stream().mapToInt(Coin::getValue).sum();

        if(totalMoneyPaid == item.getPrice()){
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, code));
            return;
        }

        if(totalMoneyPaid > item.getPrice()){
            int returnChange = totalMoneyPaid - item.getPrice();
            vendingMachine.setVendingMachineState(new DispenseState(vendingMachine, code));
            getChange(returnChange);
            return;
        }

        System.out.println("Insufficient money!! product price: " + item.getPrice() + " you paid: " + totalMoneyPaid);
        
        // Ask user if he wants to add more money if he selects 1 then he can add more money
        // if he selects other than 1 then refund the full money

        System.out.println("Do you want to add more money?");
        System.out.println("Press 1 to add more money");
        System.out.println("Press any other key to get refund");

        try (Scanner scanner = new Scanner(System.in)) {
            String choice = scanner.nextLine();

            if(choice.equals("1") ){
                vendingMachine.setVendingMachineState(new HasMoneyState());
                return;
            }

            refundFullMoney(vendingMachine);
            throw new Exception("Insufficient money!!");
        }

    }

    @Override
    public int getChange(int returnChange) throws Exception {
        System.out.println("Returning the change money in coin dispense tray: " + returnChange);
        return returnChange;
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {

        System.out.println("Refunding full money in coin dispense tray...");
        List<Coin> coins = vendingMachine.getCoins();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return coins;
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("can not be dispensed in Selection state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
        throw new Exception("can not update inventory in Selection state");
    }

}
