package Behavioral_Desing_pattern.State.gumball;

public class GumballMachineTestDrive {

    public static void main(String[] args) {

        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        gumballMachine.ejectQuarter();
        System.out.println(gumballMachine);

        // Burn through the rest
        while (gumballMachine.getCount() > 0) {
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
        }

        System.out.println(gumballMachine);

        // Try actions while sold out
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();

        // Refill and try again
        gumballMachine.refill(3);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        System.out.println(gumballMachine);
    }
}

