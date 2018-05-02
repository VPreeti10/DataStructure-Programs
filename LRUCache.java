import java.util.HashMap;

public class LRUCache {

	int capacity;
	int currentSize;
	DoubleLinkedListKey head;
	DoubleLinkedListKey end;
	HashMap<Integer,DoubleLinkedListKey> nodeMap;
	
	public LRUCache(int cap) {
		capacity=cap;
		currentSize=0;
		nodeMap=new HashMap<Integer,DoubleLinkedListKey>();
		head=end=null;
	}
	
	public void addNodeFront(DoubleLinkedListKey node) {
		node.next=head;
		node.prev=null;
		if(head!=null)
			head.prev=node;
		head=node;
		if(end==null) {
			end=node;
		}
		nodeMap.put(node.key, node);
	}
	public void set(int key,int value) {
		if(nodeMap.containsKey(key)) {
			DoubleLinkedListKey dnode=nodeMap.get(key);
			dnode.data=value;
			bringToFront(dnode);
		}
		else {
			DoubleLinkedListKey new_Node=new DoubleLinkedListKey(key,value);
			if(currentSize<capacity) {
				addNodeFront(new_Node);
				currentSize++;
			}
			else {
				removeLastNode();
				addNodeFront(new_Node);
			}
		}
	}
	public int get(int key) {
		if(nodeMap.containsKey(key)) {
			DoubleLinkedListKey node=nodeMap.get(key);
			bringToFront(node);
			return node.data;
		}
		else
			return -1;
		
	}
	public void removeLastNode() {
		DoubleLinkedListKey lnode=nodeMap.remove(end.key);
		end=end.prev;
		if(end!=null)
			end.next=null;
		lnode=null;
	}
	public void bringToFront(DoubleLinkedListKey node) {
		DoubleLinkedListKey pNode=node.prev;
		DoubleLinkedListKey nNode=node.next;
		if(pNode!=null) {
			pNode.next=nNode;
		}
		else
			head=nNode;
		if(nNode!=null) {
			nNode.prev=pNode;
		}
		else
			end=pNode;
		
		addNodeFront(node);
	}
	public void printLRUCache() {
		DoubleLinkedListKey traverseNode = head;
        while (traverseNode != null) {
            System.out.println(traverseNode.key + "  "+traverseNode.data + " ");
            traverseNode = traverseNode.next;
        }
        System.out.println();
    }
	public static void main(String[] args) {
		LRUCache lru = new LRUCache(5);
	    for (int i = 5; i < 11; i++) {
	        lru.set(i, i * 2);
	    }
	    System.out.println("LRU Cache after creation");
	    lru.printLRUCache();
	    lru.get(7);
	    System.out.println("LRU Cache after retrieving 7");
	    lru.printLRUCache();
	    lru.set(11, 11 * 2);
	    System.out.println("LRU cache on adding one more item. It will replace last one");
	    lru.printLRUCache();
	}
}
