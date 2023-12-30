
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int data) {
        this.key = data;
    }
}
 
public class spiralordertraveral {
    // Function to print all nodes of a given level from left to right
    public static boolean printLevelLeftToRight(Node root, int level)
    {
        if (root == null) {
            return false;
        }
        if (level == 1)
        {
            System.out.print(root.key + " ");
            return true;
        }
        // System.out.println("level1 "+level);
        //   System.out.println("left1");
 
        // process left child before the right child
        boolean left = printLevelLeftToRight(root.left, level - 1);
        //   System.out.println("right1");
        boolean right = printLevelLeftToRight(root.right, level - 1);
 
        return left || right;
    }
 
    // Function to print all nodes of a given level from right to left
    public static boolean printLevelRightToLeft(Node root, int level)
    {
        if (root == null) {
            return false;
        }
        if (level == 1)
        {
            System.out.print(root.key + " ");
            return true;
        }
        //  System.out.println("level "+level);
        // System.out.println("right");
        // process right child before the left child
        boolean right = printLevelRightToLeft(root.right, level - 1);
        //   System.out.println("level "+level);
        // System.out.println("left");

        boolean left = printLevelRightToLeft(root.left, level - 1);
      
        return right || left;
    }
 
    // Function to print level order traversal of a given binary tree
    public static void spiralOrderTraversal(Node root)
    {
        if (root == null) {
            return;
        }

        int level = 1;
        // run till either function returns false
        while (printLevelRightToLeft(root, level++) &&   printLevelLeftToRight(root, level++));
    }
 
    public static void main(String[] args)
    {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);
 
        spiralOrderTraversal(root);
    }
}

