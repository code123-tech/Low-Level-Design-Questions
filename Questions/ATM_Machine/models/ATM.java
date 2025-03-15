package Questions.ATM_Machine.models;

import Questions.ATM_Machine.ATMStates.ATMState;
import Questions.ATM_Machine.ATMStates.IdleState;

public class ATM {

    private static ATM atmObject = new ATM();

    ATMState state;
    private int atmBalance;
    int noOfTwoThousandNotes;
    int noOfFiveHundredNotes;
    int noOfOneHundredNotes;

    private ATM(){}

    public void setState(ATMState state){
        this.state = state;
    }

    public ATMState getState(){
        return state;
    }

    public static ATM getATMObject(){
        atmObject.setState(new IdleState());
        return atmObject;
    }

    public int getAtmBalance(){
        return atmBalance;
    }

    public void setAtmBalance(int atmBalance, int noOfTwoThousandNotes, int noOfFiveHundredNotes, int noOfOneHundredNotes){
        this.atmBalance = atmBalance;
        this.noOfTwoThousandNotes = noOfTwoThousandNotes;
        this.noOfFiveHundredNotes = noOfFiveHundredNotes;
        this.noOfOneHundredNotes = noOfOneHundredNotes;
    }


    public int getNoOfTwoThousandNotes() {
        return noOfTwoThousandNotes;
    }

    public int getNoOfFiveHundredNotes() {
        return noOfFiveHundredNotes;
    }

    public int getNoOfOneHundredNotes() {
        return noOfOneHundredNotes;
    }

    public void deductAtmBalance(int amount){
        this.atmBalance = Math.max(0, this.atmBalance - amount);
    }

    public void deductTwoThousandNotes(int noOfTwoThousandNotes){
        this.noOfTwoThousandNotes = Math.max(0, this.noOfTwoThousandNotes - noOfTwoThousandNotes);
    }

    public void deductFiveHundredNotes(int noOfFiveHundredNotes){
        this.noOfFiveHundredNotes = Math.max(0, this.noOfFiveHundredNotes - noOfFiveHundredNotes);
    }

    public void deductOneHundredNotes(int noOfOneHundredNotes){
        this.noOfOneHundredNotes = Math.max(0, this.noOfOneHundredNotes - noOfOneHundredNotes);
    }

    public void printCurrentATMStatus(){
        System.out.println("ATM Balance: " + atmBalance);
        System.out.println("No of 2000 notes: " + noOfTwoThousandNotes);
        System.out.println("No of 500 notes: " + noOfFiveHundredNotes);
        System.out.println("No of 100 notes: " + noOfOneHundredNotes);
    }

}
