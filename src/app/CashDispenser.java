package app;

/*
this class simulate the cash dispenser which is initialized with amount of money
every time run this app
it is responsible for checking if the ATM contains the current chosen amount of money
 , dispense cash outside and calculate the current amount of money after every successful operation
 */
public class CashDispenser {
    // 500 unit of  20 %   which is 10000 $
    private static final int INITIAL_VALUE = 20;
    private int count;

    public CashDispenser() {
        this.count = INITIAL_VALUE;
    }


    public boolean isSufficientCashAvailable(double amount) {
        return amount / 20 <= this.count;
    }

    public void dispenseCash(double amount) {
        this.count -= amount / 20;
    }

}
