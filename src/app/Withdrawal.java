package app;
/*
this class is responsible for all withdrawal operations

it responsible for displaying the current choices of withdraw money using displayMenu()
and checks first if the user choice is available in the available balance in user account from the fake database
then checks if the cash dispenser have the chosen amount of money .
alerting the user if with wrong message if there is no money in dispenser or user's account , or entering a invalid choice from the menu
 */

public class Withdrawal extends Transaction
{

    private double amount;
    private Keypad keypad;
    private CashDispenser cashDispenser;

    public Withdrawal(int accountNumber , Screen screen , BankDatabase bankDatabase, Keypad keypad, CashDispenser dispenser) {
        super(accountNumber, screen, bankDatabase);
        this.keypad = keypad ;
        this.cashDispenser = dispenser;
    }

    @Override
    public void execute(){
        boolean done = false ;
        // amounts of money in the screen
        /// the firs is here to be able access the array in order
        int[] amounts = {0, 20, 40, 60, 100, 200} ;
        while (!done){
            int input = displayMenu() ;
            switch (input){
                case 1 :
                case 2 :
                case 3 :
                case 4 :
                case 5 :
                    amount = amounts[input] ;

                    // checking if there is enough money in cash dispenser to do this operation
                    if (getBankDatabase().getAvailableBalance(getAccountNumber()) >= amount ){
                        if(!cashDispenser.isSufficientCashAvailable(amount)){
                            getScreen().displayMessage("the ATM doesn't have current amount");
                        }
                        else{  // there is enough money in the account
                            cashDispenser.dispenseCash(amount);
                            getScreen().displayMessage("take your money from cash dispenser");
                            getBankDatabase().debit(getAccountNumber(), amount);
                            done = true ;
                        }
                    }else{
                        getScreen().displayMessage("your account doesn't have current amount");
                    }
                    break;
                case 6 :
                    // breaking out of the loop and returning back to main menu
                    done = true ;
                    break;
                default:
                    getScreen().displayMessage("wrong choice try again");
                    break;
            }
        }
    }


    // displaying withdrawal menu and take choice from the user
    private int displayMenu(){
        getScreen().displayMessage("1-  20$");
        getScreen().displayMessage("2-  40$");
        getScreen().displayMessage("3-  60$");
        getScreen().displayMessage("4-  100$");
        getScreen().displayMessage("5-  200$");
        getScreen().displayMessage("6-  cancel transaction");
        return keypad.getInput() ;
    }




}
