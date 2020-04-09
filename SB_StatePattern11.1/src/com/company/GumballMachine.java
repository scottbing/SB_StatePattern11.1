package com.company;

public class GumballMachine {
    // all possible states as instances
    private State noQuarterState;
    private State hasQuarterState;
    private State gumballSoldState;
    private State soldOutState;
    private State winnerState;

    State state = soldOutState;     // set initial state
    int count = 0;                  // initialize count

    public GumballMachine (int numberGumballs) {
        soldOutState = new SoldOutState (this);
        noQuarterState = new NoQuarterState (this);
        hasQuarterState = new HasQuarterState(this);
        gumballSoldState = new SoldState (this);
        winnerState = new WinnerState (this);

        this.count = numberGumballs;
        if (numberGumballs > 0) {
            state = noQuarterState;
        }
    }

    public void releaseGumball() {
        if (count != 0) {
            System.out.println("One gumball dispensed");
            count--;
        }
        // System.out.println("count = "+String.valueOf(count));
    }

    // generate all 'State' getters
    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getGumballSoldState() {
        return gumballSoldState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getCount() {
        return count;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public void insertQuarter () {
        state.insertQuarter ();
    }
    public void ejectQuarter () {
        state.ejectQuarter ();
    }
    public void dispense () {
        state.dispense ();
    }
    public void turnCrank () {
        state.turnCrank ();
        //state.dispense();
    }
    public void setState (State state) {
        this.state = state;
    }
    void releaseBall () {
        System.out.println ("A gumball comes rolling out of the slot….");
        if (count != 0 ) { count --; } }
}
