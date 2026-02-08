package Behavioral_Desing_pattern.State.gumball;

/**
 * Context class for State Pattern.
 */
public class GumballMachine {

    private final State soldOutState;
    private final State noQuarterState;
    private final State hasQuarterState;
    private final State soldState;
    private final State winnerState;

    private State state;
    private int count = 0;

    public GumballMachine(int numberGumballs) {

        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);

        this.count = numberGumballs;
        this.state = (numberGumballs > 0) ? noQuarterState : soldOutState;
    }

    // Actions delegated to current state
    public void insertQuarter() {
        state.insertQuarter();
    }

    public void ejectQuarter() {
        state.ejectQuarter();
    }

    public void turnCrank() {
        state.turnCrank();
        state.dispense();
    }

    // Helper operations used by states
    public void setState(State state) {
        this.state = state;
    }

    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot");
        if (count != 0) {
            count--;
        }
    }

    public void refill(int numGumballs) {
        this.count += numGumballs;
        System.out.println("Machine refilled; new count = " + this.count);
        if (this.count > 0) {
            this.state = noQuarterState;
        } else {
            this.state = soldOutState;
        }
    }

    public int getCount() {
        return count;
    }

    // State getters (minimize direct dependencies between states)
    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    @Override
    public String toString() {
        return "\nMighty Gumball, Inc.\n"
                + "Java-enabled Standing Gumball Model #2004\n"
                + "Inventory: " + count + " gumball" + (count == 1 ? "" : "s") + "\n"
                + "Machine is " + stateName() + "\n";
    }

    private String stateName() {
        if (state == soldOutState) return "sold out";
        if (state == noQuarterState) return "waiting for quarter";
        if (state == hasQuarterState) return "waiting for turn of crank";
        if (state == soldState) return "dispensing a gumball";
        if (state == winnerState) return "dispensing a winner gumball";
        return "in an unknown state";
    }
}

