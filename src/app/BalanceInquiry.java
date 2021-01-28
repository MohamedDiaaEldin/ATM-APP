package app;

public class BalanceInquiry extends Transaction{

    public BalanceInquiry(int accountNumber , Screen screen , BankDatabase bankDatabase) {
        super(accountNumber, screen, bankDatabase);
    }

    @Override
    public void execute(){
        getScreen().displayMessage("Balance Inquiry");
        int accountNumber = getAccountNumber() ;
        getScreen().displayDollarMessage("Available balance: " , getBankDatabase().getAvailableBalance(accountNumber));
        getScreen().displayDollarMessage("Total balance", getBankDatabase().getTotalBalance(accountNumber));
    }

}
