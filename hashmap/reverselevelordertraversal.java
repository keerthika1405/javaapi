
    import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
 
// A class to store a binary tree node
class Node
{
    int key;
    Node left = null, right = null;
 
    Node(int key) {
        this.key = key;
    }
}
 
public class reverselevelordertraversal {

    public static void insertIntoMultiMap(Map<Integer, List<Integer>> map, Integer key, Integer value) {
        map.putIfAbsent(key, new ArrayList<>());
        map.get(key).add(value);
    }
 
    public static void preorder(Node root, int level, Map<Integer, List<Integer>> map)
    {
        if (root == null) {
            return;
        }
 
        insertIntoMultiMap(map, level, root.key);
        
        preorder(root.left, level + 1, map);
        preorder(root.right, level + 1, map);
    }
 
    public static void levelOrderTraversal(Node root)
    {
        Map<Integer, List<Integer>> map = new HashMap<>();
        preorder(root, 1, map);
 
        for (int i = map.size(); i > 0; i--) {
            System.out.println("Level " + i + ": " + map.get(i));
        }
        System.out.println();
         for (int i = map.size(); i > 0; i--) {
            System.out.print( map.get(i)+" ");
        }
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
        root.right.right.right = new Node(30);
 
        levelOrderTraversal(root);
    }
}

