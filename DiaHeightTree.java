//Find diameter and height of tree
public class DiaHeightTree {

	Node root;
	public void getDiameter(Node root) {
		
	}
	public int getHeight(Node root) {
		
		if(root==null)
			return 0;
		else {
			//System.out.println(root.data);
			int lheight=getHeight(root.left);
			int rheight=getHeight(root.right);			
			return(Math.max(lheight, rheight)+1);
	        }
		}
	
public int getOtherHeight(Node root) {
		
		if(root==null)
			return 0;
		else {
		//	System.out.println(root.data);
			int lheight=getHeight(root.left);
			int rheight=getHeight(root.right);			
			return(Math.min(lheight, rheight));
	        }
		}
	
	 public static void main(String args[])
	    {
	        /* creating a binary tree and entering the nodes */
		 	DiaHeightTree tree = new DiaHeightTree();
	        tree.root = new Node(1);
	        tree.root.left = new Node(2);
	        tree.root.right = new Node(3);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(5);
	        tree.root.left.right.left=new Node(21);
	        tree.root.left.right.left.right=new Node(31);
	        tree.root.right.left=new Node(8);
	        tree.root.right.right=new Node(9);
	        tree.root.right.left.right=new Node(10);
	        tree.root.right.left.right.left=new Node(11);
	     //   LevelTreePrint.printLevelOrder(tree.root);
	 //System.out.println(tree.getOtherHeight(tree.root));
	        System.out.println("The diameter of given binary tree is : "
	                           +( tree.getHeight(tree.root)+tree.getOtherHeight(tree.root)));
	    }
}
