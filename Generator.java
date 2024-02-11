import java.util.Scanner;


public class Generator{
    Alphabet alphabet;
    public static Scanner keyboard;
    public Generator(Scanner scanner){
        keyboard=scanner;
    }
    public Generator(boolean IncludeUpper,boolean IncludeLower,boolean IncludeNum,boolean IncludeSym){
        alphabet=new Alphabet(IncludeUpper,IncludeLower,IncludeNum,IncludeSym);
    }
    public void mainLoop(){
        System.out.println("Welcome to password Generator");
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
                    System.out.println("\nKindly select one of available coomand");
                    printmenu();
            }
        }

    }
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
                System.out.println("Do you want Sepcial Symbol \"#*&%...\" to be used ?");
                input=keyboard.next();
                passwordRequestError(input);
            }while (!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no")) ;
            IncludeSym=isInclude(input);
            if(!IncludeLower && !IncludeNum && !IncludeSym  && !IncludeUpper){
                correctParam=true;
                System.out.println("You have selected no characters to generate your " +
                "password, at least one of your answers should be Yes\n");
            }
            
        }while(correctParam);
        System.out.print("Great! Now enter the length of the password : ");
        int length=keyboard.nextInt();
        final Generator generator=new Generator(IncludeUpper,IncludeLower,IncludeNum,IncludeSym);
        final Password password=generator.GeneratePassword(length);
        System.err.println("Your generated password -> "+password);

    }
    private boolean isInclude(String input){
        if(input.equalsIgnoreCase("yes"))
          return true;
        return false;
    }
    private void passwordRequestError(String input){
        if(!input.equalsIgnoreCase("yes") && !input.equalsIgnoreCase("no"))
           System.out.println("You have entered something incoorect let's go over it again \n");
    }


    private void checkPassword(){
        String input;
        System.out.print("Enter your Password : ");
        input=keyboard.next();
        final Password p=new Password(input);
        System.out.println(p.calculateScore());

    }
    private void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, keyboard patterns, dictionary words, letter or number sequences," +
                "\nusernames, relative or pet names, romantic links (current or past) " +
                "and biographical information (e.g., ID numbers, ancestors' names or dates).");
        System.out.println("Avoid using information that the user's colleagues and/or " +
                "acquaintances might know to be associated with the user");
        System.out.println("Do not use passwords which consist wholly of any simple combination of the aforementioned weak components");
    }
    private void printmenu(){
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Informtion");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice: ");
    }
    private void printQuitMessage(){
        System.out.println("Closing the program");
        System.out.println("Tata bye bye!");
    }
}
