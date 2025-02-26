package Questions.VendingMachine.VendineMachineStates.Impl;

import java.util.ArrayList;
import java.util.List;

import Questions.VendingMachine.VendineMachineStates.State;
import Questions.VendingMachine.enums.Coin;
import Questions.VendingMachine.models.Item;
import Questions.VendingMachine.models.VendingMachine;

public class IdleState implements State{

    public IdleState() {
        System.out.println("Vending Machine is in Idle State");
    }

    public IdleState(VendingMachine vendingMachine) {
        System.out.println("Vending Machine is in Idle State");
        vendingMachine.setCoins(new ArrayList<>());
    }

    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("can not insert cash in idle state");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("first need to click on insert cash button.");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("can not choose product in idle state");
    }

    @Override
    public int getChange(int returnChange) throws Exception {
        throw new Exception("can not be returned in idle state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("can not be dispensed in idle state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("can not be refunded in idle state");
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
        vendingMachine.getInventory().addItem(item, code);
    }

}
