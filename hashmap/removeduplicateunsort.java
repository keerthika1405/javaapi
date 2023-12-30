import java.util.HashMap;

public class removeduplicateunsort {
    static void removeDups(int[] arr, int n)
    {
        HashMap<Integer,Boolean> mp = new HashMap<>();
        for (int i = 0; i < n; ++i)
        {
            if (mp.get(arr[i]) == null)//  System.out.println("get: "+mp.get(arr[i]));
            System.out.println(arr[i] + " ");
            mp.put(arr[i], true);// System.out.println("put: "+mp.put(arr[i],true));
        }
    }
    public static void main(String[] args)
    {
        int[] arr = { 1, 2, 5, 1, 7, 2, 4, 2 };
        int n = arr.length;
        removeDups(arr, n);
    }
    
}
