// Stack implementation using doubly linked list

public class StackOperations {
	 DLLNode head;
	 int count;
	 DLLNode middle;
	
	public void push(int data) {
		DLLNode node=new DLLNode(data);
		node.prev=null;
		node.next=head;
		count++;
		if(count==1) {
			middle=node; 
		}
		else {
			head.prev=node;
			if(count%2!=0) {
				middle=middle.prev;
			}
		}
		head=node;
	}
	public void appendData(int data) {
		DLLNode node=new DLLNode(data);
		if(head==null) {
			head=node;
			node.prev=null;
			return;
		}
		DLLNode temp=head;
		while(temp.next!=null)
			temp=temp.next;
		temp.next=node;
		node.prev=temp;
		node.next=null;
		
	}
	public void pop() {
		int item=head.data;
		head=head.next;
		if(head!=null)
			head.prev=null;
		count--;
		if(count%2==0)
			middle=middle.next;
	}
	public int findMiddle() {
		if(count==0) {
			System.out.println("Stack empty!");
			return -1;
		}
		else
			return middle.data;
	}
	public void printList() {
		DLLNode temp=head;
	//	System.out.println(temp.data);
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}			
	}
	public static void main(String[] args) {
		StackOperations st=new StackOperations();
		st.push(4);	
		st.push(5);
		/*st.push(67);
		st.push(35);
		st.push(647);
		st.pop();
		st.pop();*/
		/*st.appendData(5);
		st.appendData(45);
		st.appendData(35);*/
		st.printList();
		System.out.println("Middle"+st.findMiddle());
	}
	
}
