package za.co.wethinkcode.mastermind;

import java.io.InputStream;
import java.util.Scanner;

public class Player {
    private final Scanner inputScanner;

    public Player(){
        this.inputScanner = new Scanner(System.in);
    }

    public Player(InputStream inputStream) {
        this.inputScanner = new Scanner(inputStream);
    }

    /**
     * Gets a guess from user via text console.
     * This must prompt the user to re-enter a guess until a valid 4-digit string is entered, or until the user enters `exit` or `quit`.
     *
     * //@return the value entered by the user
     */

    private boolean quit = false;

    public String getGuess() {
        /**
         *Loop statement to make sure the count doesn't pernalise user for entering invalid digits, e,g 12q3, 123, 12343
         * Returns the correct a valid input as string
         */
        String text;
        while (true) {
            System.out.println("Input 4 digit code:");
            text = inputScanner.nextLine();
            this.quit = text.equalsIgnoreCase("quit")
                    || text.equalsIgnoreCase("exit");
            if (this.quit) {
                System.exit(0);
            }
            if ((text.length() == 4)
                    && Character.isDigit(text.charAt(0))
                    && Character.isDigit(text.charAt(1))
                    && Character.isDigit(text.charAt(2))
                    && Character.isDigit(text.charAt(3))) {

                if( checkValidity(text)) {
                    return text;
                }else{
                    inputMessage();
                    continue;
                }


            } else {
                inputMessage();
            }
        }
    }

    public boolean checkValidity(String text) {
        /**
         * Checks if the numbers entered by user falls within the range of 1-8
         * returns true they do
         */
        for (int i = 0; i < 4; i++) {
            if (!(49 <= (int) text.charAt(i) && (int) text.charAt(i) <= 56)) {
                return false;
            }
        }
        return true;
    }


    public boolean wantsToQuit() {
        /**
         * Returns a boolean to determine if user wants to quit or exit game
         * True if player wants to quit or exit
         */
        return this.quit;
    }

    public int[] evaluateCode(String code) {
        /**
         * returns an array of integers {countCorrectDigitsInCorrectPlace, countCorrectDigitsNotInCorrectPlace}
         * used to check if the code entered is the correct one
         */
        int countCorrectDigitsInCorrectPlace = 0;
        int countCorrectDigitsNotInCorrectPlace = 0;
        String userInput = getGuess();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                boolean charactersInCodeAndUserInput = (code.charAt(i) == userInput.charAt(j));
                if (charactersInCodeAndUserInput && i == j) {
                    countCorrectDigitsInCorrectPlace++;
                }
                if (charactersInCodeAndUserInput && i != j) {
                    countCorrectDigitsNotInCorrectPlace++;
                }
            }
        }
        int[] arr = {countCorrectDigitsInCorrectPlace, countCorrectDigitsNotInCorrectPlace};
        return arr;
    }
    public void inputMessage() {
        /**
         * Prints message asking user to input correct digits
         * "Please enter exactly 4 digits (each from 1 to 8)."
         */
        System.out.println("Please enter exactly 4 digits (each from 1 to 8).");
    }

    public void gamePlayOutput(int countCorrectDigitsInCorrectPlace, int countCorrectDigitsNotInCorrectPlace) {
        /**
         * Takes two arguments (int countCorrectDigitsInCorrectPlace, int countCorrectDigitsNotInCorrectPlace)
         * Prints Number of correct digits in correct place and Number of correct digits not in correct place
         */
        System.out.println(String.format("Number of correct digits in correct place: %d\nNumber of correct digits not in correct place: %d",
                countCorrectDigitsInCorrectPlace, countCorrectDigitsNotInCorrectPlace));
    }

    public void gameWonMessage(String generateCode) {
        /**
         * Prints the congradulations statement and the generated code
         * "Congratulations! You are a codebreaker!\nThe code was: %s", generateCode
         */
        System.out.println(String.format("Congratulations! You are a codebreaker!\nThe code was: %s", generateCode));
    }

    public void printTurnsLeft(int count) {
        /**
         * Prints the statement and the returned count
         * "Turns left: %d", count
         */
        System.out.println(String.format("Turns left: %d", count));
    }
    public int turnsLeftCounter(int count) {
        /**
         * Returns the number of turns left, if the number of turns is 0 the game ends
         */
        if (count > 0 || count < 13) {
            return count;
        } else if (count == 0 ) {
            count = 0;
        }
        return count;
    }
    public void printIntro() {
        /**
         * Prints the statement
         * "4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it."
         */
        System.out.println("4-digit Code has been set. Digits in range 1 to 8. You have 12 turns to break it.");
    }
}
