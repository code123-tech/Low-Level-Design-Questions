package Questions.VendingMachine.VendineMachineStates;

import java.util.List;

import Questions.VendingMachine.enums.Coin;
import Questions.VendingMachine.models.Item;
import Questions.VendingMachine.models.VendingMachine;

public interface State {

    void pressInsertCashButton(VendingMachine vendingMachine) throws Exception;

    void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;

    void pressSelectProductButton(VendingMachine vendingMachine) throws Exception;

    void chooseProduct(VendingMachine vendingMachine, int code) throws Exception; 

    int getChange(int returnChange) throws Exception;

    Item dispenseProduct(VendingMachine vendingMachine, int code) throws Exception;

    List<Coin> refundFullMoney(VendingMachine vendingMachine) throws Exception;

    void updateInventory(VendingMachine vendingMachine, Item item, int code) throws Exception;

}
