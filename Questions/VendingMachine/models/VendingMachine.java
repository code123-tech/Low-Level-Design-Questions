package Questions.VendingMachine.models;

import java.util.ArrayList;
import java.util.List;

import Questions.VendingMachine.VendineMachineStates.State;
import Questions.VendingMachine.VendineMachineStates.Impl.IdleState;
import Questions.VendingMachine.enums.Coin;

public class VendingMachine {
    
    private State vendingMachineState;
    private Inventory inventory;
    private List<Coin> coins;


    public VendingMachine() {
        this.vendingMachineState = new IdleState();
        this.inventory = new Inventory(10);
        this.coins = new ArrayList<>();
    }

    public State getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(State vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }   

    public Inventory getInventory() {
        return inventory;
    }

    public List<Coin> getCoins() {
        return coins;
    }
}
