package app;

/*
this class is responsible for deposit operations
it takes the deposit amount of money from the user
and update the BankDatabase
, it should rely on other external service (making sure about deposit money) but it's not available for this system
 */
public class Deposit extends Transaction {
    private double amount;

    private Keypad keypad;
    private DepositSlot depositSlot;

    public Deposit(int accountNumber, Screen screen, BankDatabase bankDatabase, DepositSlot depositSlot, Keypad keypad) {
        super(accountNumber, screen, bankDatabase);
        this.depositSlot = depositSlot;
        this.keypad = keypad;

    }

    @Override
    public void execute() {

        amount = takeAmount();
        if (amount != 0) {
            getScreen().displayMessage("insert envelope containing  " + amount + " $");
            // it will always true for now because no such service in current system
            if (depositSlot.isEnvelopeReceived()) {
                getBankDatabase().credit(getAccountNumber(), amount);
                getScreen().displayMessage("we have received your money");
            } else {
                getScreen().displayMessage(String.format("you didn't insert the envelope \n canceling... "));
            }
        } else {
            getScreen().displayMessage("canceling... ");
        }

    }


    private double takeAmount() {
        getScreen().displayMessage("Enter the deposit amount in cents or 0 to Exit");
        return keypad.getInput() / 100.0; // returning the amount in dollar
    }


}
