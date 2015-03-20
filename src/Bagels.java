
import java.util.Random;
import javax.swing.JOptionPane;

/**
 * A class to play the game of Bagels
 *
 * @author your name
 */
public class Bagels {

    int secret;
    int guess;
    int firstDigitSecret;
    int secondDigitSecret;
    int thirdDigitSecret;
    int firstDigitGuess;
    int secondDigitGuess;
    int thirdDigitGuess;
    boolean continuegame = false;
    int guesses = 0;

    // creates a random number generator object
    private static Random r = new Random();

    /**
     * Creates a Bagels object
     */
    public Bagels() {
        // NOTE: Since the secret number is initialized in a separate method,
        // the constructor body may be left empty (unless you have other
        // instance vars to initialize)
    }

    /**
     * Conducts a game and prints the results
     */
    public void play() {
        this.generateSecretNumber();

        JOptionPane.showMessageDialog(null, "Welcome to the game of Bagels!");

        do {

            String input = null;

            do {
                input = JOptionPane.showInputDialog("Please enter your guess as a 3 digit"
                        + " number");

                guess = Integer.parseInt(input);

            } while (guess < 100 || guess > 999);

            guesses++;

            this.evaluateGuess();

            if (!this.isWinner()) {

                input = JOptionPane.showInputDialog("Not quite!"
                        + " Continue? Type Y to keep playing or any other key to quit.");

                continuegame = input.equalsIgnoreCase("Y");

            }

        } while (!this.isWinner() && continuegame);

        if (this.isWinner()) {

            System.out.println("Congratulations! You won! And you only took "
                    + guesses + " guess(es) to do it!" + "\n");

        }

        if (continuegame == false && !this.isWinner()) {

            System.out.println("Aw, dude you quit! You made " + guesses + " guess(es). "
                    + "Sore loser...");
        }
    }

    // Generates three random single digit ints.  The first cannot be zero
    // and all three will be different. Called by public method play()
    private void generateSecretNumber() {
        do {
            secret = r.nextInt(886) + 102;

            firstDigitSecret = secret / 100;
            secondDigitSecret = ((secret - (firstDigitSecret * 100)) / 10);
            thirdDigitSecret = (secret - (firstDigitSecret * 100) - (secondDigitSecret * 10));

        } while (firstDigitSecret == 0 && (firstDigitSecret == secondDigitSecret
                || firstDigitSecret == thirdDigitSecret || secondDigitSecret == thirdDigitSecret));

    }

    // Evaluates the user's guess and prints the guess and hints to System.out.
    // Called by public method play()
    private void evaluateGuess() {
        firstDigitGuess = guess / 100;
        secondDigitGuess = ((guess - (firstDigitGuess * 100)) / 10);
        thirdDigitGuess = (guess - (firstDigitGuess * 100) - (secondDigitGuess * 10));

        if (firstDigitGuess == firstDigitSecret && secondDigitGuess == secondDigitSecret
                && thirdDigitGuess == thirdDigitSecret) {

            System.out.print("Winner! ");

        }

        if ((!(firstDigitGuess == firstDigitSecret)
                && !(secondDigitGuess == secondDigitSecret) && !(thirdDigitGuess == thirdDigitSecret))
                && !(firstDigitGuess == secondDigitSecret) && !(firstDigitGuess == thirdDigitSecret)
                && !(secondDigitGuess == thirdDigitSecret) && !(secondDigitGuess == firstDigitSecret)
                && !(thirdDigitGuess == firstDigitSecret) && !(thirdDigitGuess == secondDigitSecret)) {

            System.out.print("Bagels!");
        }

        if (firstDigitGuess == firstDigitSecret && (!(firstDigitGuess == firstDigitSecret
                && secondDigitGuess == secondDigitSecret && thirdDigitGuess == thirdDigitSecret))) {
            System.out.print("Fermi ");

        }

        if (secondDigitGuess == secondDigitSecret && (!(firstDigitGuess == firstDigitSecret
                && secondDigitGuess == secondDigitSecret && thirdDigitGuess == thirdDigitSecret))) {
            System.out.print("Fermi ");

        }

        if (thirdDigitGuess == thirdDigitSecret && (!(firstDigitGuess == firstDigitSecret
                && secondDigitGuess == secondDigitSecret && thirdDigitGuess == thirdDigitSecret))) {
            System.out.print("Fermi ");

        }

        if (firstDigitGuess == secondDigitSecret) {
            System.out.print("Pico ");
        }

        if (firstDigitGuess == thirdDigitSecret) {
            System.out.print("Pico ");
        }

        if (secondDigitGuess == firstDigitSecret) {
            System.out.print("Pico ");
        }

        if (secondDigitGuess == thirdDigitSecret) {
            System.out.print("Pico ");
        }

        if (thirdDigitGuess == firstDigitSecret) {
            System.out.print("Pico ");
        }

        if (thirdDigitGuess == secondDigitSecret) {
            System.out.print("Pico ");
        }
        System.out.println("\nYour guess was: " + guess + "\n");
    }

    // Returns a value of true or false indicating whether the current
    // guess is a winner. Called by public method play()
    private boolean isWinner() {
        boolean winner = (firstDigitGuess == firstDigitSecret
                && secondDigitGuess == secondDigitSecret && thirdDigitGuess == thirdDigitSecret);

        // NOTE: this return statement is here only so the class skeleton
        // will compile.  Feel free to use or discard
        return winner;
    }
}
