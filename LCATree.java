//Find least common ancestor of 2 nodes in a tree

import java.util.ArrayList;
import java.util.List;

public class LCATree {
	Node root;
	
	List<Integer> path1=new ArrayList<Integer>();
	List<Integer> path2=new ArrayList<Integer>();
	
	public int findLCA(int n1,int n2) {
		path1.clear();
		path2.clear();
		return findLCAInternal(root, n1, n2);
	}
	
	public int findLCAInternal(Node m,int n1,int n2) {
		
		if (!findPath(root, n1, path1) || !findPath(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }
 
		int i;
		for(i=0;i<path1.size()&&i<path2.size();i++) {
			if(path1.get(i)!=path2.get(i))
				break;
		}
		return(path1.get(i-1));
	}
	
	public boolean findPath(Node root,int n,List<Integer> path) {
		if(root==null) {
		   return false;
		}
		path.add(root.data);
		
		if(root.data==n) {
			return true;
		}
		if(root.left!=null && findPath(root.left, n, path)) {
			return true;
		}
		if(root.right!=null && findPath(root.right, n, path)) {
			return true;
		}
		path.remove(path.size()-1);
		return false;
	}
	
	public static void main(String[] args)
    {
		LCATree tree = new LCATree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
 
        System.out.println("LCA(4, 5): " + tree.findLCA(4,5));
        System.out.println("LCA(4, 6): " + tree.findLCA(4,6));
        System.out.println("LCA(3, 4): " + tree.findLCA(3,4));
        System.out.println("LCA(2, 4): " + tree.findLCA(2,4));
       
    }
	
}
