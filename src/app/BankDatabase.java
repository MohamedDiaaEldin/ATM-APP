package app;

public class BankDatabase {

    private Account[] accounts;


    public BankDatabase() {
        accounts = new Account[2] ;
        accounts[0] = new Account(1234,2222, 1000 , 1200 ) ;
        accounts[1] = new Account(1235,4444, 100, 200) ;
    }

    public boolean authenticateUser(int accountNumber, int PIN){
        Account account = getAccount(accountNumber) ;
        return account != null && account.validatePIN(PIN) ;
    }

    /* there is more efficient ways to do this step but it's ok for current data
    /* ex if the account number is unique so hashMash will be good choice fo this function
     */
    private Account getAccount(int accountNumber){
        for (Account account : accounts){
            if (account.getAccountNumber() == accountNumber){
                return account;
            }
        }
        return null ; // there is no account
    }

    public double getAvailableBalance(int accountNumber){
        return getAccount(accountNumber).getAvailableBalance();
    }
    public double getTotalBalance(int accountNumber){
        return getAccount(accountNumber).getTotalBalance();
    }
    public void credit(int accountNumber, double amount){
        getAccount(accountNumber).credit(amount);
    }

    public void debit(int accountNumber, double amount){
        getAccount(accountNumber).debit(amount);
    }


}
