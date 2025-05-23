package Questions.Auction_System.models;

public class Bid {

    private User bidder;
    private double amount;
    private long timeStamp;

    public Bid(User bidder, double amount, long timeStamp) {
        this.bidder = bidder;
        this.amount = amount;
        this.timeStamp = timeStamp;
    }

    public User getBidder() {
        return bidder;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Bid{" +
                "bidder=" + bidder +
                ", amount=" + amount +
                ", timeStamp=" + timeStamp +
                '}';
    }

}
