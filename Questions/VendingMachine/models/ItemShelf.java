package Questions.VendingMachine.models;

public class ItemShelf {

    private Item item;
    private int code;
    private boolean isItemSold;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isItemSold() {
        return isItemSold;
    }

    public void setItemSold(boolean itemSold) {
        isItemSold = itemSold;
    }
}
