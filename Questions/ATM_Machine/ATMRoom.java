package Questions.ATM_Machine;

import Questions.ATM_Machine.models.ATM;
import Questions.ATM_Machine.models.Card;
import Questions.ATM_Machine.models.TransactionType;
import Questions.ATM_Machine.models.User;
import Questions.ATM_Machine.models.UserBankAccount;

public class ATMRoom {

    ATM atm;
    User user;

    public static void main(String[] args) {
        
        ATMRoom atmRoom = new ATMRoom();
        atmRoom.initialize();

        // run program
        atmRoom.atm.printCurrentATMStatus();
        atmRoom.atm.getState().insertCard(atmRoom.atm, atmRoom.user.getCard());
        atmRoom.atm.getState().authenticatePIN(atmRoom.atm, atmRoom.user.getCard(), 112211);
        atmRoom.atm.getState().selectOperation(atmRoom.atm,atmRoom.user.getCard(), TransactionType.CASH_WITHDRAWL);
        atmRoom.atm.getState().cashWithdrawl(atmRoom.atm, atmRoom.user.getCard(), 2700);
        atmRoom.atm.printCurrentATMStatus();
    }


    private void initialize(){

        this.atm = ATM.getATMObject();
        this.atm.setAtmBalance(3500, 1, 2, 5);

        this.user = createUser();
    }

    private User createUser(){
        User user = new User();
        user.setCard(createCard());
        return user;
    }

    private Card createCard(){
        Card card = new Card();
        card.setBankAccount(createBankAccount());
        return card;
    }

    private UserBankAccount createBankAccount(){

        UserBankAccount bankAccount = new UserBankAccount();
        bankAccount.setBalance(3000);
        return bankAccount;
    }

}
