import java.util.Scanner;
public class Main{
    static Scanner keyboard;
    public static void main(String[] args){
        keyboard=new Scanner(System.in);
        Generator generator=new Generator(keyboard);
        generator.mainLoop();
        keyboard.close();
    }
}