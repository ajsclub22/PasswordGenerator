public class Alphabet {
    
	public static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
	public static final String NUMBERS = "1234567890";
	public static final String SYMBOLS = "!@#$%^&*()-_=+\\/~?";
    
    StringBuilder pool;
    public Alphabet(boolean uppercaseIncluded,boolean lowercaseIncluded,boolean numberIncluded,boolean symbolIncluded){
        pool=new StringBuilder("");
        if(uppercaseIncluded) pool.append(UPPERCASE_LETTERS);
        if(lowercaseIncluded) pool.append(LOWERCASE_LETTERS);
        if(numberIncluded)  pool.append(NUMBERS);
        if(symbolIncluded) pool.append(SYMBOLS);
    }
    public String getAlphabet(){
        return pool.toString();
    }
    
}
