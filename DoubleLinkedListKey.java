
public class DoubleLinkedListKey {
	int key;
	int data;
	DoubleLinkedListKey prev;
	DoubleLinkedListKey next;
	
	public DoubleLinkedListKey(int k,int d) {
		key=k;
		data=d;
		prev=next=null;
	}
}
