package Questions.VendingMachine;

import Questions.VendingMachine.VendineMachineStates.State;
import Questions.VendingMachine.VendineMachineStates.Impl.HasMoneyState;
import Questions.VendingMachine.enums.Coin;
import Questions.VendingMachine.enums.ItemType;
import Questions.VendingMachine.models.Item;
import Questions.VendingMachine.models.ItemShelf;
import Questions.VendingMachine.models.VendingMachine;

public class Main {

    public static void main(String[] args) {
        
        VendingMachine vendingMachine = new VendingMachine();

        try{

            System.out.println("--------------- filling up the inventory ----------------");
            fillUpInventory(vendingMachine);
            displayInventory(vendingMachine);

            System.out.println("--------------- pressing insert cash button ----------------");
            State vendingMachineState = vendingMachine.getVendingMachineState();
            vendingMachineState.pressInsertCashButton(vendingMachine);

            vendingMachineState = vendingMachine.getVendingMachineState();
            
            
            while(vendingMachineState instanceof HasMoneyState){
                System.out.println("--------------- inserting coin ----------------");
                vendingMachineState.insertCoin(vendingMachine, Coin.PENNY);

                System.out.println("--------------- pressing productSelect button ----------------");
                vendingMachineState.pressSelectProductButton(vendingMachine);

                vendingMachineState = vendingMachine.getVendingMachineState();
                vendingMachineState.chooseProduct(vendingMachine, 1002);
                vendingMachineState = vendingMachine.getVendingMachineState();
            }

            displayInventory(vendingMachine);

        }catch(Exception e){
            displayInventory(vendingMachine);
        }
    }

    private static void fillUpInventory(VendingMachine vendingMachine) {

        ItemShelf[] slots = vendingMachine.getInventory().getItemInventory();

        for(int i = 0; i < slots.length; i++){
            
            Item item = new Item();
            
            if(i >= 0 && i < 3){
                item.setItemType(ItemType.PEPSI);
                item.setPrice(12);
            }
            else if(i >= 3 && i < 5){
                item.setItemType(ItemType.SODA);
                item.setPrice(9);
            }
            else if(i >= 5 && i < 7){
                item.setItemType(ItemType.WATER);
                item.setPrice(8);
            }else{
                item.setItemType(ItemType.JUICE);
                item.setPrice(15);
            }

            slots[i].setItem(item);
            slots[i].setItemSold(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getItemInventory();
        for(int i = 0; i < slots.length; i++){
            System.out.println("Code: " + slots[i].getCode() + 
            ", Item: " + slots[i].getItem().getItemType().name() + 
            ", Price: " + slots[i].getItem().getPrice() + 
            ", isAvailable: " + slots[i].isItemSold());
        }
    }

}
