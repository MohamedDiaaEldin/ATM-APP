package app;

public abstract class Transaction {

    private int accountNumber ;

    private Screen screen ;
    private BankDatabase bankDatabase;

    public Transaction(int accountNumber , Screen screen, BankDatabase bankDatabase){
        this.accountNumber = accountNumber;
        this.screen = screen ;
        this.bankDatabase = bankDatabase ;
    }

    public abstract void execute() ;

    public Screen getScreen() {
        return screen;
    }

    public BankDatabase getBankDatabase() {
        return bankDatabase;
    }

    public int getAccountNumber(){
        return this.accountNumber ;
    }
}
