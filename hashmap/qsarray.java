import java.util.Arrays;

class qsarray {
 
 // method to find the partition position
 static int partition(int array[], int low, int high) {
  
   int pivot = array[high];//    selecting the rightmost element as pivot
   
   int left = low;//setting the left pointer to point at the lowest index initially
 
   int right = high - 1; //setting the left pointer to point at the lowest index initially
 
   while(left <= right){ //running a loop till left is smaller than right
 
       //incrementing the value of left until the value at left'th index is smaller than pivot
       while(array[left] < pivot){
           left++;
       }
 
       //decrementing the value of right until the value at right'th index is greater than pivot
       while(array[right] > pivot){
           right--;
       }
 
       if(left < right){
         
           int temp = array[left];  //swapping the elements at left & right index
           array[left] = array[right];
           array[right] = temp;
       }
   } 
   
   
   int temp = array[left];// swapping pivot with the element where left and right meet
   array[left] = array[high];
   array[high] = temp;
    
   return (left); // return the partition point
 }
 
 static void qs(int array[], int low, int high) {
   if (low < high) {
 
       int pi = partition(array, low, high);
 
       System.out.println("left");
       qs(array, low, pi - 1);// recursively calling the function on left subarray
 
        System.out.println("right"); // recursively calling the function on right subarray
        qs(array, pi + 1, high);
   }
 }
 public static void main(String args[]) {

    int[] data = { 8, 7, 2, 1, 0, 9, 6 };
    System.out.println("Unsorted Array");
    System.out.println(Arrays.toString(data));

    int size = data.length;

 
    qsarray.qs(data, 0, size - 1);

    System.out.println("Sorted Array in Ascending Order ");
    System.out.println(Arrays.toString(data));
}
}