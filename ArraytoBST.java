<<<<<<< HEAD
// Convert a sorted array to Binary search tree.
=======
//Program to convert sorted array to Binary Search Tree
>>>>>>> e85b0af61c816e1a5dcdcfed77fae9de817be64d
public class ArraytoBST {

	static Node root;
		public static Node arraytoBST(int[] arr1,int start,int end) {
			if(start>end) {
				return null;
			}
			int mid=(start+end)/2;
			Node node=new Node(arr1[mid]);
			node.left=arraytoBST(arr1,start,mid-1);
			node.right=arraytoBST(arr1, mid+1, end);
			return node;
		}
		public static void main(String[] args) {
			int[] arr= {1,2,3,4,5,6,7,8};
			root=arraytoBST(arr,0,arr.length);
		}
}
