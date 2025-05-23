package Questions.Auction_System.models;

public class User {

    private String userId;
    private String name;
    private String email;
    private AuctionMediator auctionMediator;

    public User(String userId, String name, String email, AuctionMediator auctionMediator) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.auctionMediator = auctionMediator;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void placeBid(Auction auction, double amount) {

        System.out.println(name + " is placing bid of " + amount + " on auction " + auction.getAuctionId());
        auctionMediator.placeBid(auction, this, amount);
    }

    public void receiveNotification(String message){
        System.out.println(name + " received notification: " + message);
    }

}
