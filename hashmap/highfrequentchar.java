import java.util.HashMap;

public class highfrequentchar {
    public static void main(String[]args){
    String st=("aabdabcdbacbddd");
    System.out.println("maximum frequent character is : "+maxfreq(st));
       
    }
    public static char maxfreq(String st){
    HashMap<Character,Integer> hmap=new HashMap<>();//creat a hash table
    int n=st.length();//15
    for(int i=0;i<n;i++) //hashtable
    {
        Character ch=st.charAt(i);
        if(hmap.containsKey(ch)==true){
            int cfreq=hmap.get(ch);
            hmap.put(ch,cfreq+1);
        }
        else{
            hmap.put(ch,1);
        }
    }
    // for (Map.Entry entry : hmap.entrySet()) {
    //         System.out.println(entry.getKey() + " " + entry.getValue());
    //    }

     int maxvalue=0;
     char maxchar=' ';
     for(char c: hmap.keySet()){
         if(hmap.get(c)>maxvalue){
            System.out.println("get: "+hmap.get(c));
             maxvalue=hmap.get(c);
             maxchar=c;
        }
    }return maxchar;
    } 
}

