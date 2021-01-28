package app;

public class CashDispenser {
    // 500 unit of  20 %   which is 10000 $
    private static final int INITIAL_VALUE = 20 ;
    private int count ;

    public CashDispenser() {
        this.count = INITIAL_VALUE;
    }


    public boolean isSufficientCashAvailable(double amount){
        return amount/20 <= this.count ;
    }

    public void dispenseCash(double amount){
        this.count -= amount /20 ;
    }

}
