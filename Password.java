/**
 * The Password class represents a password and provides methods to analyze its strength.
 */
public class Password {
    String Value; // The password string
    int Length; // The length of the password

    /**
     * Constructs a Password instance with the specified string value.
     * @param s The password string
     */
    public Password(String s) {
        Value = s;
        Length = s.length();
    }

    /**
     * Determines the type of character (uppercase, lowercase, number, symbol).
     * @param ch The character to check
     * @return An integer representing the type of character:
     *         1 for uppercase, 2 for lowercase, 3 for number, 4 for symbol
     */
    public int CharType(char ch) {
        int val;
        if (ch > 64 && ch < 91)
            val = 1;
        else if (ch > 96 && ch < 123)
            val = 2;
        else if (ch > 47 && ch < 58)
            val = 3;
        else
            val = 4;
        return val;
    }

    /**
     * Calculates the strength score of the password based on various criteria.
     * @return The strength score of the password
     */
    public int passwordStrength() {
        String pass = Value;
        int score = 0;
        boolean usedUpper = false;
        boolean usedLower = false;
        boolean usedNum = false;
        boolean usedSym = false;

        for (int i = 0; i < Length; i++) {
            int val = CharType(pass.charAt(i));
            if (val == 1) usedUpper = true;
            else if (val == 2) usedLower = true;
            else if (val == 3) usedNum = true;
            else if (val == 4) usedSym = true;
        }

        if (usedUpper) score++;
        if (usedLower) score++;
        if (usedNum) score++;
        if (usedSym) score++;
        if (Length >= 8) score++;
        if (Length >= 16) score++;
        return score;
    }

    /**
     * Calculates the strength score of the password and returns a descriptive message.
     * @return A descriptive message indicating the strength of the password
     */
    public String calculateScore() {
        int score = passwordStrength();
        if (score == 6) {
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        } else if (score >= 4) {
            return "This is a good password :) but you can still do better";
        } else if (score == 3) {
            return "This is a medium password :/ try making it better";
        } else {
            return "This is a weak password :( definitely find a new one";
        }
    }

    /**
     * Returns the password string representation.
     * @return The password string
     */
    @Override
    public String toString() {
        return Value;
    }
}
