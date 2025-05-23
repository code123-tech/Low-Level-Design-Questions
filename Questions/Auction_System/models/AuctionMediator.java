package Questions.Auction_System.models;

public interface AuctionMediator {

    void placeBid(Auction auction, User user, double amount);
    void notifyUsers(Auction auction, String message);
    void closeAuction(Auction auction);

}
