package com.company;

public class NoQuarterState implements State {

    GumballMachine gumballMachine;   // encapsulate machine

    public NoQuarterState(GumballMachine machine) {
        this.gumballMachine = machine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Quarter inserted");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("There never was a quarter to eject");
    }

    @Override
    public void turnCrank() {
        System.out.println("Crank turned");
    }

    @Override
    public void dispense() {
        System.out.println("Please insert a quarter first");
    }
}
