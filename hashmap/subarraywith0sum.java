 public class subarraywith0sum {
 
public static boolean subArrayExists(int arr[], int n)
{
    for (int i = 0; i < n; i++) {
        int sum = arr[i];
        if (sum == 0)
            return true;

        for (int j = i + 1; j < n; j++) {
            sum += arr[j];
            if (sum == 0)
                return true;
        }
    }
    return false;
}
public static void main(String[] args)
{
    int arr[] = { -3, 2, 3, 1, 6 ,-9};
    int N = arr.length;
 
    if (subArrayExists(arr, N))
        System.out.println("Found a subarray with 0 sum");
    else
        System.out.println("No Such Sub Array Exists!");
 
}
}
