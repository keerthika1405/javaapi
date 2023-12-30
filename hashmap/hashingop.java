
// import java.util.*;

//  class hashingop{
	
//     public static void main(String args[]) {    	

//     	// Hashtable = A data structure that stores unique keys to values ex.<Integer, String>
//     	//			   Each key/value pair is known as an Entry
//     	//			   FAST insertion, look up, deletion of key/value pairs
//     	// 			   Not ideal for small data sets, great with large data sets
    	
//     	// hashing = Takes a key and computes an integer (formula will vary based on key & data type)
//     	//		       In a Hashtable, we use the hash % capacity to calculate an index number 
    	
//     	//			key.hashCode() % capacity = index  
    	
//     	// bucket = an indexed storage location for one or more Entries
//     	//	            can store multiple Entries in case of a collision (linked similarly a LinkedList)
    	
//     	// collision = hash function generates the same index for more than one key
//     	//			less collisions = more efficiency
    	
//     	// Runtime complexity: Best Case O(1)
//     	//                                     Worst Case O(n)

//     	Hashtable<Integer> table = new Hashtable<>(7);
    	
//     	// table.put(100, "Spongebob");
//     	// table.put(123, "Patrick");
//     	// table.put(321, "Sandy");
//     	// table.put(555, "Squidward");
//     	// table.put(777, "Gary");

// 		table.put(100 );
//     	table.put(123 );
//     	table.put(321 );
//     	table.put(555 );
//     	table.put(777 );
    	  	
//     	for(Integer key : table.keySet()) {
//     		System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
//     	}
//     }
// }

  // {
		// 	 System.out.println("sub"+(target - nums[i]));    
        //     // check if pair (nums[i], target-nums[i]) exists // if the difference is seen before, print the pair
        //     if (map.containsKey(target - nums[i]))
        //     {
        //         System.out.printf("Pair found (%d, %d)", nums[map.get(target - nums[i])], nums[i]);
        //         return;
        //     }
		// 	 System.out.println(nums[i]+" "+ i);
		// 	 map.put(nums[i], i);    // store index of the current element in the map
        // } System.out.println("Pair not found");  
 
         // we reach here if the pair is not found
import java.util.HashMap;

 
class hashingop
{
    public static void findPair(int[] nums, int target)
    {
        
        HashMap<Integer, Integer> map = new HashMap<>();

       // do for each element
			for (int i = 0; i < nums.length; i++) 
			{
				System.out.println("data " +nums[i]);

            if (map.containsKey(target - nums[i])) {
				System.out.println("1");
                System.out.printf("Pair found (%d, %d) is sum of %d" , (target - nums[i]), nums[i],target);
				 System.out.println();
            }
            if (map.containsKey(nums[i])) {
				System.out.println("2");
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            else {
				System.out.println("3");
                map.put(nums[i], 0);
            }
        }
	}
    public static void main (String[] args)
    {
        int[] nums = { 1, 5, 7, -1};
		int size = 3;
        int target = 6;
 
        findPair(nums, target);

		 System.out.println();
		for(int i=0;i<nums.length;i++)
		{
			  System.out.println(nums[i]%size+" "+nums[i]); 
		}
		
    }
}

// import java.util.HashSet;


// public class hashingop 
// {
// 	public static void isPairSum(int n,int X,int input_array[])
// 	{
// 		HashSet <Integer>Set = new HashSet<> ();//Creating an hashset
// 		for (int i = 0;i < n; i++)
// 		{
// 			int difference = X - input_array[i];
// 			if (Set.contains(difference))//Checking whether the hashset contains the difference of sum and a
// 			{
// 				System.out.print("The two numbers are "+ difference +" and "+ input_array[i]);
// 				return;
// 			}
// 			Set.add(input_array[i]);//adding the values in array in hashset
// 		}
// 		System.out.print("There is no such pair");
// 	}
// 	public static void main(String args[])
// 	{
// 		int X = 7, input_array[]= {1, 5, 3, -2, 4, 7,2};
// 		int n = input_array.length;
// 		isPairSum (n, X, input_array);//calling the function
// 	}
// }

/*
 Brute force approach.
  All data is just a sequence of bits. Can treat key as a gigantic number and use it as an array index. Requires exponentially large amounts of memory.
Hashing.
 Instead of using the entire key, represent entire key by a smaller value. In Java, we hash objects with a hashCode() method that returns an integer (32 bit) representation of the object.
hashCode() 
to index conversion. To use hashCode() results as an index, we must convert the hashCode() to a valid index. Modulus does not work since hashCode may be negative. Taking the absolute value then the modulus also doesn't work since Math.abs(Integer.MIN_VALUE) is negative. We use hashCode & 0x7FFFFFFF instead before taking the modulus.
Hash function.
 Converts a key to a value between 0 and M-1. 
 In Java, this means calling hashCode(), setting the sign bit to 0, then taking the modulus.
Designing good hash functions. Requires a blending of sophisticated mathematics and clever engineering; beyond the scope of this course. Most important guideline is to use all the bits in the key. If hashCode() is known and easy to invert, adversary can design a sequence of inputs that result in everything being placed in one bin. Or if hashCode() is just plain bad, same thing can happen.
Uniform hashing assumption. For our analyses below, we assumed that our hash function distributes all input data evenly across bins. This is a strong assumption and never exactly satisfied in practice.
Collision resolution.
 Two philosophies for resolving collisions discussed in class: Separate chaining and 'open addressing'. We didn't use the term open addressing, but it's where you use empty array entries to handle collisions, e.g. linear probing.
Separate-chaining hash table.
 Key-value pairs are stored in a linked list of nodes of length M. Hash function tells us which of these linked lists to use. Get and insert both require potentially scanning through entire list.
Resizing separate chaining hash tables. 
Understand how resizing may lead to objects moving from one linked list to another. Primary goal is so that M is always proportional to N.
Performance of separate-chaining hash tables.
 Cost of a given get, insert, or delete is given by number of entries in the linked list that must be examined.
The expected amortized search and insert time (under uniform hashing assumption) is N / M, which is no larger than some constant (due to resizing).
We note that the expected length of the largest bin is log N / log log N. This is far beyond the scope of the class. Grows slowly, but is not quite constant.
Linear-probing hash tables.
 If the space that should be occupied by a key is already occupied by something else, try the space to the right. If that's occupied, go right more. Repeat. This philosophy works for get and insert.
Performance of linear-probing hash tables.
 As before, performance determined by number of entries in the key array that must be examined.
If N / M is a constant (bounded away from 1), then the expected amortized search and insert time (under uniform hashing assumption) is a constant. For N / M = 0.5, expected cost of a search hit is 3/2 and expected cost of a search miss is 5/2. If N / M approaches 1, the costs blow up; see Knuth's parking problem.
The expected length of the longest cluster is Theta(log N). This is beyond the scope of the course.
 */