package app;
/*
this class is responsible for talking inputs from keyboard
it simulate the real key pad in the ATM
 */

import java.util.Scanner;

public class Keypad {

    private Scanner scanner;

    public Keypad() {
        scanner = new Scanner(System.in);
    }

    public int getInput() {
        return scanner.nextInt();
    }
}
