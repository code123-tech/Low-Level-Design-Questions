package Questions.VendingMachine.models;

import Questions.VendingMachine.enums.ItemType;

public class Item {

    private ItemType itemType;
    private int price;

    public ItemType getItemType() {
        return itemType;
    }

    public int getPrice() {
        return price;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
