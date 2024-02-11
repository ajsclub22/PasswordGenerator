/**
 * The Alphabet class represents a collection of characters that can be used to generate passwords.
 */
public class Alphabet {
    // Constants defining different character sets
    public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    public static final String NUMBERS = "1234567890";
    public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
    
    StringBuilder pool; // StringBuilder to store the combined character pool

    /**
     * Constructs an Alphabet instance based on the specified inclusion of character sets.
     * @param uppercaseIncluded A boolean indicating whether uppercase letters are included
     * @param lowercaseIncluded A boolean indicating whether lowercase letters are included
     * @param numberIncluded A boolean indicating whether numbers are included
     * @param symbolIncluded A boolean indicating whether symbols are included
     */
    public Alphabet(boolean uppercaseIncluded, boolean lowercaseIncluded, boolean numberIncluded, boolean symbolIncluded) {
        pool = new StringBuilder("");
        // Append character sets based on inclusion flags
        if (uppercaseIncluded) pool.append(UPPERCASE_LETTERS);
        if (lowercaseIncluded) pool.append(LOWERCASE_LETTERS);
        if (numberIncluded) pool.append(NUMBERS);
        if (symbolIncluded) pool.append(SYMBOLS);
    }

    /**
     * Returns the combined character pool as a String.
     * @return The combined character pool
     */
    public String getAlphabet() {
        return pool.toString();
    }
}
