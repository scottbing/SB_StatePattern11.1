package com.company;

public class WinnerState implements State {
    GumballMachine gumballMachine;
    State nextState;
    State soldOutState;

    public WinnerState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
        this.nextState = gumballMachine.getNoQuarterState();
        this.soldOutState = gumballMachine.getSoldOutState();
    }

    @Override
    public void insertQuarter() {
        System.out.println("You can't insert a quarter, the machine is sold out");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("You can't eject, you haven't inserted a quarter yet");
    }

    @Override
    public void turnCrank() {
        System.out.println("Your turn, but there are no gumballs");
    }

    @Override
    public void dispense() {
        // handle winner
        System.out.println("YOU'RE A WINNER! - Horray!!! - You got two gumballs for your quarter");
        gumballMachine.releaseBall();
        if(gumballMachine.getCount() == 0) {
            gumballMachine.setState(soldOutState);
        } else {
            gumballMachine.releaseBall();
            if(gumballMachine.getCount() > 0) {
                gumballMachine.setState(nextState);
            } else {
                System.out.println("Oops, out of gumballs!");
                gumballMachine.setState(soldOutState);
            }
        }
    }
}