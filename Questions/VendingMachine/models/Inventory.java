package Questions.VendingMachine.models;

public class Inventory {

    private ItemShelf[] itemInventory;

    public Inventory(int itemCount) {

        itemInventory = new ItemShelf[itemCount];
        initializeEmptyInventory();
    }

    public ItemShelf[] getItemInventory() {
        return itemInventory;
    }

    private void initializeEmptyInventory() {
        
        int startCode = 1001;
        for(int i = 0; i < itemInventory.length; i++) {
            ItemShelf itemShelf = new ItemShelf();
            itemShelf.setCode(startCode++);
            itemShelf.setItemSold(true);
            itemInventory[i] = itemShelf;
        }
    }

    public void addItem(Item item, int code) throws Exception {
        
        for(ItemShelf itemShelf: itemInventory) {
            if(itemShelf.getCode() != code){
                continue;
            }

            if(itemShelf.isItemSold()){
                itemShelf.setItem(item);
                itemShelf.setItemSold(false);
                System.out.println("Item added successfully!!");
                return;
            } else {
                throw new Exception("Item already exists at code: " + code);
            }
        }
    }

    public Item getItem(int code) throws Exception {

        for(ItemShelf itemShelf: itemInventory) {
            if(itemShelf.getCode() != code){
                continue;
            }

            if(itemShelf.isItemSold()){
                throw new Exception("item already sold out!!");
            }

            return itemShelf.getItem();
        }

        throw new Exception("Item not exists at code: " + code);
    }

    public void updateSoldOutItem(int code){
        
        for(ItemShelf itemShelf: itemInventory) {    
            if(itemShelf.getCode() == code){
                itemShelf.setItemSold(true);
                return;
            }
        }
    }

}
