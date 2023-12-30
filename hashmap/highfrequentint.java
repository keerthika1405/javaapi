import java.util.Arrays;

public class highfrequentint {
    
      static int mostFrequent(int arr[], int n)
    {
        // Sort the array
        Arrays.sort(arr);
  
        // find the max frequency using linear traversal
        int max_count = 1, res = arr[0];
        int curr_count = 1;
  
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]){
                curr_count++;
                System.out.println("curr count"+curr_count);}
            else{
                curr_count = 1;}
  
            if (curr_count > max_count) {
                max_count = curr_count;
                System.out.println("maximin= "+max_count);
                res = arr[i - 1];
                System.out.println("res= "+res);
            }
        }  
        return res;
    }
  
    // Driver program
    public static void main(String[] args)
    {
        int arr[] = { 40,50,30,40,50,30,30};
        int n = arr.length;
         System.out.println(n);
        System.out.println(mostFrequent(arr, n));
    }
}
