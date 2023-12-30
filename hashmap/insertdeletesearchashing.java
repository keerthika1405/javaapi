
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
 
public class insertdeletesearchashing {
 
    private ArrayList<Integer> arr; // A resizable array to hold the elements
    private Map<Integer, Integer> map; // A hash map to store the indexes of elements in arr
 
    // Constructor to initialize the array and hash map
    public insertdeletesearchashing() {
        arr = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
 
   
    public void add(int x) {
        // If element is already present, do nothing
        if (!map.containsKey(x)) {
            int index = arr.size();
            System.out.println(x+" "+index);

            arr.add(x); // Else add element to the end of the array
            map.put(x, index); // And store its index in the hash map
        }
    }
 
    public void remove(int x) {
        // If element is not present, do nothing
        if (map.containsKey(x)) {
            // Else remove element from the hash map and get its index in the array
            int index = map.get(x);
            map.remove(x);
            // Swap the element with the last element in the array and remove the last element
            int last = arr.size() - 1;
            arr.set(index, arr.get(last));
            arr.remove(last);
            // Update the hash map with the new index of the element that was swapped with the last element
            map.put(arr.get(index), index);
        }
    }
 
  
    public int search(int x) {
       
        if (map.containsKey(x)) { // If element is present, return its index in the array from the hash map
            return map.get(x);
        }
        return -1;     // Else return -1
    }
 
    
    public int getRandom() {
        Random rand = new Random();
        // Generate a random index from 0 to size - 1 of the array
        int randomIndex = rand.nextInt(arr.size());
        // Return the element at the randomly picked index
        return arr.get(randomIndex);
    }
 
    
    public static void main(String[] args) {
        insertdeletesearchashing ds = new insertdeletesearchashing();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);

        System.out.println(ds.search(30)); // Output: 2
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50)); // Output: 3
        System.out.println(ds.getRandom()); // Output: A random element from the array
    }
}

