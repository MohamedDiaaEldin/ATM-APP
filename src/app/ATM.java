package app;

public class ATM {

    private boolean userAuthenticated;
    private int currentAccountNumber;

    private Screen screen;
    private Keypad keypad;
    private DepositSlot depositSlot;
    private CashDispenser cashDispenser;
    private BankDatabase bankDatabase;

    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;


    public ATM() {
        userAuthenticated = false;
        currentAccountNumber = 0 ;
        screen = new Screen();
        keypad = new Keypad();
        depositSlot = new DepositSlot();
        cashDispenser = new CashDispenser();
        bankDatabase = new BankDatabase();
    }

    public void run() {
        while (true) {
            while (!userAuthenticated) {
                authenticateUser();
            }
            performTransaction(); // on the main menu
            userAuthenticated = false;
            currentAccountNumber = 0;
            screen.displayMessage("good bye thanks for using our ATM");
        }
    }




    public void performTransaction() {
        boolean exited = false ;
        while (! exited){
            int input  = displayMainMenu() ; // displaying main menu
            switch (input){
                case WITHDRAWAL:
                    createTransaction(new Withdrawal(currentAccountNumber, screen,bankDatabase, keypad, cashDispenser));
                    break;
                case DEPOSIT:
                    createTransaction(new Deposit(currentAccountNumber, screen, bankDatabase, depositSlot, keypad));
                    break;
                case BALANCE_INQUIRY:
                    createTransaction(new BalanceInquiry(currentAccountNumber, screen, bankDatabase));
                    break;
                case EXIT:
                    screen.displayMessage("System Exiting ...");
                    exited = true ;
                    break;
                default:
                    screen.displayMessage("wrong choice try again ");
            }
        }


    }

    public boolean authenticateUser() {
        screen.displayMessage("Welcome in our ATM \n please enter your account number");
        currentAccountNumber = keypad.getInput();
        screen.displayMessage("please enter your PIN");
        int PIN = keypad.getInput();
        if (bankDatabase.authenticateUser(currentAccountNumber, PIN)) {
            userAuthenticated = true;
            return true;
        }
        screen.displayMessage("wrong account number or PIN ");
        return false;
    }
    private void createTransaction(Transaction transaction){
        transaction.execute();
    }


    public int displayMainMenu() {
        screen.displayMessage("Main menu: ");
        screen.displayMessage("1- view my balance");
        screen.displayMessage("2- withdraw cash");
        screen.displayMessage("3- deposit funds");
        screen.displayMessage("4- Exit ");

        return keypad.getInput() ;
    }



}