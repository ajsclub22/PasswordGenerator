import java.util.Scanner;

/**
 * The Main class contains the main method to run the password generator program.
 */
public class Main {
    static Scanner keyboard;

    /**
     * The main method creates a Scanner object for user input, initializes a Generator instance,
     * and starts the main loop of the password generator program.
     * @param args The command-line arguments (not used in this program)
     */
    public static void main(String[] args) {
        keyboard = new Scanner(System.in);
        Generator generator = new Generator(keyboard);
        generator.mainLoop();
        keyboard.close();
    }
}
