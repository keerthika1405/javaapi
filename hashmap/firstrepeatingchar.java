

import java.util.HashSet;

public class firstrepeatingchar {
       public static void main(String[]args){
        // String st="zmonpqdmny";
        // firstrepeatchar(st);

        String st1="abdcefzceab";
        firstrepeatchar(st1);
       }
       
    public static void firstrepeatchar(String st1){
        HashSet<Character> set= new HashSet<>();

        for(int i=0;i<st1.length();i++){
            char ch=st1.charAt(i);
            if(set.contains(ch)){
                System.out.print(ch);
                return;
            }
            else{
                set.add(ch);
            }
        }
           System.out.print("-1");

    }
}
