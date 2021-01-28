package app;

public class Account {
    private int accountNumber ;
    private int PIN;
    private double availableBalance ;
    private double totalBalance ;

    public Account(int accountNumber, int PIN, double availableBalance, double totalBalance) {
        this.accountNumber = accountNumber;
        this.PIN = PIN;
        setAvailableBalance(availableBalance);
        setTotalBalance(totalBalance);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void credit(double amount ){
        this.totalBalance += amount;
   }

   public void debit(double amount){
        this.availableBalance -= amount ;
        this.totalBalance -= amount ;
   }

    public boolean validatePIN(int PIN) {
        return this.PIN == PIN ;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    private void setAvailableBalance(double availableBalance) {
        if(availableBalance < 0){
         throw new  IllegalArgumentException("there is no negative balance ") ;
        }
        else{
            this.availableBalance = availableBalance ;
        }

    }

    private void setTotalBalance(double totalBalance) {
        if (totalBalance < 0){
            throw new IllegalArgumentException("the is no negative balance ") ;
        }
        else{
            this.totalBalance = totalBalance;
        }
    }
}
