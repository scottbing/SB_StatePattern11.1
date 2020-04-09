package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GumballMachine gumballMachine = new GumballMachine(2);
        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.ejectQuarter();
        gumballMachine.turnCrank();
        gumballMachine.dispense();
        gumballMachine.insertQuarter();
        gumballMachine.ejectQuarter();

        gumballMachine.insertQuarter();
        gumballMachine.turnCrank();
        gumballMachine.dispense();
    }
}
