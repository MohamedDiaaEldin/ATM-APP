package app;
/*
this class is responsible for getting the current total and available balance from BankDatabase
 */


public class BalanceInquiry extends Transaction {

    public BalanceInquiry(int accountNumber, Screen screen, BankDatabase bankDatabase) {
        super(accountNumber, screen, bankDatabase);
    }

    @Override
    public void execute() {
        Screen screen = getScreen() ;
        screen.displayMessage("Balance Inquiry\n");
        screen.displayDollarMessage("Available balance: ", getBankDatabase().getAvailableBalance(getAccountNumber()));
        screen.displayDollarMessage("Total balance", getBankDatabase().getTotalBalance(getAccountNumber()));
        screen.displayMessage("");// next line
    }

}
