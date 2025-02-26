package Questions.VendingMachine.VendineMachineStates.Impl;

import java.util.List;

import Questions.VendingMachine.VendineMachineStates.State;
import Questions.VendingMachine.enums.Coin;
import Questions.VendingMachine.models.Item;
import Questions.VendingMachine.models.VendingMachine;

public class HasMoneyState implements State{

    public HasMoneyState() {
        System.out.println("Vending Machine is in HasMoney State");
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) throws Exception {
        System.out.println("Already in collecting money state...");
        return;
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        System.out.println("Accepted the coin: " + coin.getValue());
        vendingMachine.getCoins().add(coin);
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("you need to click on start product selection button first...");
    }

    @Override
    public int getChange(int returnChange) throws Exception {
        throw new Exception("can not be changed in HasMoney state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("can not be dispensed in HasMoney state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {

        System.out.println("Refunding full money in coin dispense tray...");
        List<Coin> coins = vendingMachine.getCoins();
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return coins;
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
        throw new Exception("can not update inventory in HasMoney state");
    }

}
