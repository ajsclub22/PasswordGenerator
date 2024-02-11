public class Password{
    String Value;
    int Length;
    public Password(String s){
        Value=s;
        Length=s.length();
    }
    public int CharType(char ch){
        int val;

        if(ch>64 && ch<91)
          val=1;
        else if(ch>96 && ch<123)
          val=2;
        else if(ch>47 && ch<58)
          val=3;
        else  
           val=4;
        return val;

    }
    public int passwordStrength(){
        String pass=Value;
        int score=0;
        boolean usedUpper=false;
        boolean usedLower=false;
        boolean usedNum=false;
        boolean usedSym=false;

        for(int i=0;i<Length;i++){
            int val=CharType(pass.charAt(i));
            if(val==1)  usedUpper=true;
            else if(val==2) usedLower=true;
            else if(val==3) usedNum=true;
            else if(val==4) usedSym=true;
            
        }

        if(usedUpper) score++;
        if(usedLower) score++;
        if(usedNum)  score++;
        if(usedSym) score++;
        if(Length>=8) score++;
        if(Length>=16) score++;
        return score;

    }
    public String calculateScore(){
        int score=passwordStrength();
        if(score==6){
            return "This is a very good password :D check the Useful Information section to make sure it satisfies the guidelines";
        }
        else if(score>=4){
            return "This is a good password :) but you can still do better";
        }
        else if(score==3){
            return "This is a medium password :/ try making it better";
        }
        else 
           return "This is a weak password :( definitely find a new one";
    }
    @Override
    public String toString(){
        return Value;
    }
}