package app;

/*
this class is responsible for displaying messages at screen or console
 it simulate the ATM's screen
 */
public class Screen {

    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayDollarMessage(String messageBefore, double amount) {
        System.out.println(String.format("%s  %,.2f $", messageBefore, amount));
    }
    public void displayCancelingMessage() {
        System.out.println("canceling...");
    }
    public void displayWrongChoiceMessage(){
        System.out.println("wrong choice try again");
    }


}
