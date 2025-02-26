package Questions.VendingMachine.VendineMachineStates.Impl;

import java.util.List;

import Questions.VendingMachine.VendineMachineStates.State;
import Questions.VendingMachine.enums.Coin;
import Questions.VendingMachine.models.Item;
import Questions.VendingMachine.models.VendingMachine;

public class DispenseState implements State{

    public DispenseState(VendingMachine vendingMachine, int code) throws Exception {
        System.out.println("Vending Machine is in Dispense State");
        dispenseProduct(vendingMachine, code);
    }


    @Override
    public void pressInsertCashButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("can not click on insert cash button in selection state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new Exception("can not insert coin in Dispense state");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new Exception("can not click select product button in Dispense state");
    }

    @Override
    public void chooseProduct(VendingMachine vendingMachine, int code) throws Exception {
        throw new Exception("can not choose product in Dispense state");
    }

    @Override
    public int getChange(int returnChange) throws Exception {
        throw new Exception("can not return change in Dispense state");
    }

    @Override
    public List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception {
        throw new Exception("can not refund in Dispense state");
    }

    @Override
    public Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception {

        System.out.println("Product has been dispensed");
        Item item = vendingMachine.getInventory().getItem(code);
        vendingMachine.getInventory().updateSoldOutItem(code);
        vendingMachine.setVendingMachineState(new IdleState(vendingMachine));
        return item;
    }

    @Override
    public void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception {
        throw new Exception("can not update inventory in Dispense state");
    }
}
