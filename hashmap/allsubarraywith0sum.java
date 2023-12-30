
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
public class allsubarraywith0sum {
    //insert <key, value> into the multimap //Both the keys and values stored in the collection and considered as an alternative to Map<K, List<V>> or Map<K, Set<V>
    
    private static<K, V> void insert(Map<K, List<V>> hashMap, K key, V value)
    {
        // if the key is seen for the first time, initialize the list
        /*
         The putIfAbsent(K key, V value) method of HashMap class is used to map the specified key with the specified value, only if no such key exists (or is mapped to null) in this HashMap
         */
        System.out.println("*");
        hashMap.putIfAbsent(key, new ArrayList<>());
        hashMap.get(key).add(value);
    }

    public static void printAllSubarrays(int[] nums)
    {
        // create an empty multimap to store the ending index of all subarrays having the same sum
       HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        System.out.println("insert1");
        // insert (0, -1) pair into the map to handle the case when subarray with zero-sum starts from index 0
        insert(hashMap, 0, -1);//inicialize
 

        int sum = 0;
        for (int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
             System.out.println("sum  "+sum);
            // if the sum is seen before, there exists at least one subarray with zero-sum


            if (hashMap.containsKey(sum))
            {  System.out.println("----");

                System.out.println("storeinlist "+hashMap.get(sum));

                List<Integer> list = hashMap.get(sum);
                System.out.println("list "+list);

 
                // find all subarrays with the same sum
                for (Integer value: list)
                {
                    System.out.println("Subarray of index [" + (value + 1) + " to  " +i + "]");
                }
            }
            // insert (sum so far, current index) pair into the multimap\
            System.out.println("insert2");
            System.out.println("sum "+sum);
            System.out.println("i "+i);
            insert(hashMap, sum, i);
        }
    }
    public static void main (String[] args)
    {
        int[] nums = { 3, 4, -7, 3, 1, 3, 1, -4, -2, -2 };
 
        printAllSubarrays(nums);
    }
}

