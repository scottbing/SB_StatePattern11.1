package com.company;

import java.util.Random;

public class HasQuarterState implements State {
    GumballMachine gumballMachine;   // encapsulate machine

    // randomly select a winner
    Random randomWinner = new Random(System.currentTimeMillis());

    public HasQuarterState(GumballMachine machine) {
        this.gumballMachine = machine;
    }

    @Override
    public void insertQuarter () {
        System.out.println("You cannot insert a second qurter");
    }

    @Override
    public void ejectQuarter () {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank Turned");

        // is this a winner?
        int winner = randomWinner.nextInt(10);
        if(winner == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getGumballSoldState());
        }

    }

    @Override
    public void dispense () {
        System.out.println("Cannot dispense without a crank");
    }
}
