package Questions.Auction_System.models;

import java.util.ArrayList;
import java.util.List;

public class Auction {

    private String auctionId;
    private AuctionItem item;
    private double startingPrice;
    private Bid currentHighestBid;
    private List<User> bidders;
    private long startTime;
    private long duration;
    private String status;

    public Auction(String auctionId, AuctionItem item, long duration) {
        this.auctionId = auctionId;
        this.item = item;
        this.startingPrice = item.getStartingPrice();
        this.currentHighestBid = null;
        this.bidders = new ArrayList<>();
        this.startTime = System.currentTimeMillis();
        this.duration = duration;
        this.status = "ACTIVE";
    }

    public String getAuctionId() {
        return auctionId;
    }

    public AuctionItem getItem() {
        return item;
    }

    public Bid getCurrentHighestBid() {
        return currentHighestBid;
    }

    public String getStatus() {
        return status;
    }

    public List<User> getBidders() {
        return bidders;
    }

    public void addBidder(User bidder) {
        bidders.add(bidder);
    }
    
    boolean isActive() {
        return status.equals("ACTIVE") && (System.currentTimeMillis() - startTime) < duration;
    }

    void placeBid(User bidder, double amount, AuctionMediator mediator) {
        if (!isActive()) {
            System.out.println("Auction " + auctionId + " is not active. Cannot place bid.");
            return;
        }
        double minBid = currentHighestBid == null ? startingPrice : currentHighestBid.getAmount();
        if (amount <= minBid) {
            System.out.println("Bid of " + amount + " by " + bidder.getName() + " is too low. Must be higher than " + minBid);
            return;
        }
        this.currentHighestBid = new Bid(bidder, amount, System.currentTimeMillis());
        mediator.notifyUsers(this, "New highest bid: " + amount + " by " + bidder.getName());
    }

    void closeAuction(AuctionMediator mediator) {
        if (status.equals("CLOSED")) {
            System.out.println("Auction " + auctionId + " is already closed.");
            return;
        }
        status = "CLOSED";
        String message = currentHighestBid != null
                ? "Auction closed! Winner: " + currentHighestBid.getBidder().getName() + " with bid " + currentHighestBid.getAmount()
                : "Auction closed! No bids placed.";
        mediator.notifyUsers(this, message);
    }

    @Override
    public String toString() {
        return "Auction{auctionId=" + auctionId + ", item=" + item + ", currentHighestBid=" + currentHighestBid + ", status=" + status + "}";
    }

}
