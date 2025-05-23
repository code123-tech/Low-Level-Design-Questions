package Questions.Auction_System.models;

public class AuctionItem {

    private String itemId;
    private String name;
    private String description;
    private double startingPrice;

    public AuctionItem(String itemId, String name, String description, double startingPrice) {
        this.itemId = itemId;
        this.name = name;
        this.description = description;
        this.startingPrice = startingPrice;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    @Override
    public String toString() {
        return "AuctionItem{" +
                "itemId='" + itemId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startingPrice=" + startingPrice +
                '}';
    }

}
