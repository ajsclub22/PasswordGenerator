import java.util.Scanner;

/**
 * The Generator class facilitates password generation and strength checking.
 */
public class Generator{
    // Instance variables
    Alphabet alphabet;
    public static Scanner keyboard;

    /**
     * Constructor to initialize the Scanner object.
     * @param scanner The Scanner object for user input.
     */
    public Generator(Scanner scanner){
        keyboard=scanner;
    }

    /**
     * Constructor to initialize the alphabet based on user preferences.
     * @param IncludeUpper Whether to include uppercase letters.
     * @param IncludeLower Whether to include lowercase letters.
     * @param IncludeNum Whether to include numbers.
     * @param IncludeSym Whether to include special symbols.
     */
    public Generator(boolean IncludeUpper,boolean IncludeLower,boolean IncludeNum,boolean IncludeSym){
        alphabet=new Alphabet(IncludeUpper,IncludeLower,IncludeNum,IncludeSym);
    }

    /**
     * Main loop for user interaction.
     */
    public void mainLoop(){
        System.out.println("Welcome to Password Generator");
        printmenu();
        
        String userOption="-1";
        while(!userOption.equals("4")){
            userOption=keyboard.next();
            switch (userOption) {
                case "1":
                    requestPassword();
                    printmenu();
                    break;
                case "2":
                    checkPassword();
                    printmenu();
                    break;
                case "3":
                    printUsefulInfo();
                    printmenu();
                    break;
                case "4":
                    printQuitMessage();
                    break;
                default:
                    System.out.println("\nKindly select one of the available commands");
                    printmenu();
            }
        }

    }

    /**
     * Generates a password based on user preferences.
     * @param length Length of the password to be generated.
     * @return The generated password.
     */
    private Password GeneratePassword(int length){
        final StringBuilder pass=new StringBuilder("");
        final int alphabetlength=alphabet.getAlphabet().length();

        int  max=alphabetlength-1;
        int min=0;
        int range=max - min +1;
        for(int i=0;i<length;i++){
            int index=(int)(Math.random()*range)+min;
            pass.append(alphabet.getAlphabet().charAt(index));
        }
        return new Password(pass.toString());
    }

    /**
     * Prompts the user for password generation preferences and generates a password accordingly.
     */
    private void requestPassword(){
        boolean IncludeUpper=false;
        boolean IncludeLower=false;
        boolean IncludeNum=false;
        boolean IncludeSym=false;

        boolean correctParam=false;
        do{
            String  input;
            do{
                System.out.println("Do you want Lowercase letters \"abcd...\" to be used? ");
                input=keyboard.next();
                passwordRequestError(input);
            }while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            IncludeLower=isInclude(input);
            
            do{
                System.out.println("Do you want Uppercase letters \"ABCD...\" to be used ?");
                input=keyboard.next();
                passwordRequestError(input);
            }while(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"));
            IncludeUpper=isInclude(input);

            do{
                System.out.println("Do you want Numbers \"1234...\" to be used ?");
                input=keyboard.next();
                passwordRequestError(input);
            }while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) ;
            IncludeNum=isInclude(input);

            do{
                System.out.println("Do you want Special Symbols \"#*&%...\" to be used ?");
                input=keyboard.next();
                passwordRequestError(input);
            }while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) ;
            IncludeSym=isInclude(input);
            if(!IncludeLower && !IncludeNum && !IncludeSym  && !IncludeUpper){
                correctParam=true;
                System.out.println("You have selected no characters to generate your " +
                "password. At least one of your answers should be Yes\n");
            }
            
        }while(correctParam);
        System.out.print("Great! Now enter the length of the password : ");
        int length=keyboard.nextInt();
        final Generator generator=new Generator(IncludeUpper,IncludeLower,IncludeNum,IncludeSym);
        final Password password=generator.GeneratePassword(length);
        System.err.println("Your generated password -> "+password);

    }

    /**
     * Checks if the user input indicates inclusion.
     * @param input The user input.
     * @return true if the input indicates inclusion, false otherwise.
     */
    private boolean isInclude(String input){
        return input.equalsIgnoreCase("yes");
    }

    /**
     * Prints an error message for invalid password generation input.
     * @param input The user input.
     */
    private void passwordRequestError(String input){
        if(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))
           System.out.println("You have entered something incorrect. Let's go over it again.\n");
    }

    /**
     * Prompts the user to enter a password for strength checking.
     */
    private void checkPassword(){
        String input;
        System.out.print("Enter your Password : ");
        input=keyboard.next();
        final Password p=new Password(input);
        System.out.println(p.calculateScore());
    }

    /**
     * Prints useful information regarding password strength and security.
     */
    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers, and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }

    /**
     * Prints the menu options for the user.
     */
    private void printmenu(){
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice: ");
    }

    /**
     * Prints the closing message when the user quits the program.
     */
    private void printQuitMessage(){
        System.out.println("Closing the program");
        System.out.println("Tata bye bye!");
    }
}
