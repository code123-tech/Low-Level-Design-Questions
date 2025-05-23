package Questions.Auction_System;

import Questions.Auction_System.models.Auction;
import Questions.Auction_System.models.AuctionItem;
import Questions.Auction_System.models.ConcreteAuctionMediator;
import Questions.Auction_System.models.User;

public class OnlineAuctionSystem {

    public static void main(String[] args) {
        
        ConcreteAuctionMediator mediator = new ConcreteAuctionMediator();

        AuctionItem item = new AuctionItem("item1", "Antique Vase", "A rare 18th-century vase", 100.0);

        Auction auction = new Auction("auction1", item, 60_000);
        mediator.addAuction(auction);

        User alice = new User("user1", "Alice", "alice@example.com", mediator);
        User bob = new User("user2", "Bob", "bob@example.com", mediator);
        User charlie = new User("user3", "Charlie", "charlie@example.com", mediator);

        auction.addBidder(alice);
        auction.addBidder(bob);
        auction.addBidder(charlie);

        System.out.println("=== Placing Bids ===");
        alice.placeBid(auction, 120.0);
        bob.placeBid(auction, 110.0); // Too low, should fail
        charlie.placeBid(auction, 150.0);

        System.out.println("\n=== Closing Auction ===");
        mediator.closeAuction(auction);

        System.out.println("\n=== Trying to Bid After Auction Closes ===");
        bob.placeBid(auction, 200.0);

    }

}
