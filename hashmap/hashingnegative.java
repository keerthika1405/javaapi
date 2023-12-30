class hashingnegative
{
 
final static int MAX = 1000;
 
// Since array is global, it
// is initialized as 0.
static boolean[][] has = new boolean[MAX + 1][2];
 
// searching if X is Present in
// the given array or not.
static boolean search(int X)
{
    if (X >= 0)
    {
        if (has[X][0] == true)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    // if X is negative take the absolute value of X.
    X = Math.abs(X);
    if (has[X][1] == true)
    {
        return true;
    }
 
    return false;
}
 
static void insert(int a[], int n)
{
    for (int i = 0; i < n; i++)
    {
        if (a[i] >= 0)
        {
            has[a[i]][0] = true;

        }
        else
        {
            int abs_i = Math.abs(a[i]);
            has[abs_i][1] = true;
        }
    }
}
static void printhash(int a[], int n){
     for(int i=0;i<a.length;i++)
		{
            int x=Math.abs(a[i]);
			  System.out.println(x%n+" "+x); 
		}
}
 
// Driver code
public static void main(String args[])
{
    int a[] = {-1, 9, -5, -8, -5, -2};
    int n = a.length;
  

    // for(int i=0;i<a.length;i++)
	// 	{
	// 		  System.out.println(a[i]%n+" "+a[i]); 
	// 	}

    insert(a, n);
    printhash(a, n);
    int X = -5;
    if (search(X) == true)
    {
        System.out.println("Present");
    }
    else
    {
        System.out.println("Not Present");
    }
}
}