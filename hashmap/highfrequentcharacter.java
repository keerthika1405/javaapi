

public class highfrequentcharacter {
     public static void main(String[] args)
    {
        String st=("aabdabcdbacbddddddddddddddddddddddddd");
        System.out.println("maximum occuring character : "+maxfreq(st));
    }
    static final int ASCII_SIZE = 256;
    static char maxfreq(String st)
    {
        int count[] = new int[ASCII_SIZE];
        int len = st.length();  
        for (int i = 0; i < len; i++){
            count[st.charAt(i)]++;
        System.out.println("count:"+count[st.charAt(i)]+"-->"+st.charAt(i));}

        int max = -1; // Initialize max count
        char result = ' '; // Initialize result
 
        for (int i = 0; i < len; i++) {
            if (max < count[st.charAt(i)]) {
                max = count[st.charAt(i)];
                    System.out.println("max: "+max);
                result = st.charAt(i);
                 System.out.println("result: "+result);
            }
        }
        return result;
    }
}
  
   
   

