/* An Iterative Java program to print tree levels line by line */

import java.util.LinkedList;
import java.util.Queue;

public class LevelTreePrint 
{
	// A Binary Tree Node
	static class Node
	{
		int data;
		Node left;
		Node right;
		
		// constructor
		Node(int data){
			this.data = data;
			left = null;
			right =null;
		}
	}
	
	// Iterative method to do level order traversal line by line
	public static void printLevelOrder(Node root)
	{
		// Base Case
		if(root == null)
			return;
		
		// Create an empty queue for level order tarversal
		Queue<Node> q =new LinkedList<Node>();
		
		// Enqueue Root and initialize height
		q.add(root);
		
		
		while(true)
		{
			
			// nodeCount (queue size) indicates number of nodes
			// at current level.
			int nodeCount = q.size();
			if(nodeCount == 0)
				break;
			
			// Dequeue all nodes of current level and Enqueue all
			// nodes of next level
			while(nodeCount > 0)
			{
				Node node = q.peek();
				System.out.print(node.data + " ");
				q.remove();
				if(node.left != null)
					q.add(node.left);
				if(node.right != null)
					q.add(node.right);
				nodeCount--;
			}
			System.out.println();
		}
	}
	
	// Driver program to test above functions
	public static void main(String[] args) 
	{
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.right = new Node(6);
		
		printLevelOrder(root);
		System.out.println("Level Order traversal of binary tree is : ");
        reverseLevelOrder(root);

	}
	
	void reverseLevelOrder(Node node) 
    {
        int h = height(node);
        int i;
        for (i = h; i >= 1; i--) 
        //THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
        {
            printGivenLevel(node, i);
        }
    }
  
   
    void  printGivenLevel(Node node, int level) 
    {
        if (node == null)
            return;
        if (level == 1)
            System.out.print(node.data + " ");
        else if (level > 1) 
        {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
  
    
    int height(Node node) 
    {
        if (node == null)
            return 0;
        else
        {
            /* compute the height of each subtree */
            int lheight = height(node.left);
            int rheight = height(node.right);
  
            /* use the larger one */
            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }
  

}
//This code is contributed by Sumit Ghosh
