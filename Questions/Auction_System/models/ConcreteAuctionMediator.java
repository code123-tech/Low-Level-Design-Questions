package Questions.Auction_System.models;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAuctionMediator implements AuctionMediator{

    private List<Auction> auctions;

    public ConcreteAuctionMediator() {
        this.auctions = new ArrayList<>();
    }

    public void addAuction(Auction auction) {
        auctions.add(auction);
    }

    @Override
    public void placeBid(Auction auction, User bidder, double amount) {
        if (!auctions.contains(auction)) {
            System.out.println("Auction not managed by this mediator.");
            return;
        }
        auction.placeBid(bidder, amount, this);
    }

    @Override
    public void notifyUsers(Auction auction, String message) {
        for (User bidder : auction.getBidders()) {
            bidder.receiveNotification(message);
        }
    }

    @Override
    public void closeAuction(Auction auction) {
        if (!auctions.contains(auction)) {
            System.out.println("Auction not managed by this mediator.");
            return;
        }
        auction.closeAuction(this);
    }

}
