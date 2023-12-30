/*valueOf() is a static method present in String class. It is used to convert any data type like int, double, char, char array to its string representation by creating a new String object. We can also use valueOf() to convert a
 char array to a String, or a subarray of a char array to a String*/

import java.util.*;
 
class longestconsecutivesubsequent {
 
    static int findLongestConseqSubseq(int arr[], int n)
    {
        HashSet<Integer> hashset = new HashSet<Integer>();
        int ans = 0;
 
        for (int i = 0; i < n; ++i)// Hash all the array elements
           hashset.add(arr[i]);
           /*HashSet doesn't allow duplicate values. HashMap stores key, value pairs and it does not allow duplicate keys */
 
        // check each possible sequence from the start then update optimal length
        for (int i = 0; i < n; ++i) {
            // if current element is the starting
            // element of a sequence
            if (!hashset.contains(arr[i] - 1)) {
             
                // Then check for next elements in the sequence
                int j = arr[i];
                 System.out.println("i1 "+i);
                    System.out.println("j1 "+j);

                while (hashset.contains(j)){
                       System.out.println("----");
                      hashset.remove(Integer.valueOf(j));//this will improve runtime by avoiding the repetitive counts of elements
                    
                      j++;
                      System.out.println("j2 "+j);
                    }
 
                // update  optimal length if this
                // length is more
                 System.out.println("*");
                System.out.println("i "+ i);
                System.out.println("j "+ j);
                if (ans < j - arr[i])
                {
                    ans = j - arr[i];
                    System.out.println("ans "+ans);
                }
            }
        }
        System.out.println("***");
        return ans;
    }
 
    // Driver Code
    public static void main(String args[])
    {
        int arr[] = { 1, 4, 3, 10, 6, 9, 2, 5, 30 };//non zero input
        int n = arr.length;
        System.out.println("Length of the Longest consecutive subsequence is "  + findLongestConseqSubseq(arr, n));
    }
}