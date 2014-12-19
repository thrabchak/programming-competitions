import java.util.Iterator;


public class LinkedList<Item> implements Iterable<Item> {
	
	private class Node{
		@SuppressWarnings("unused")
		public Item item;
		@SuppressWarnings("unused")
		public Node next;
	}
	
	Node head;
	Node tail;
	int size = 0;
	
	public void addToTail(Item i){
		Node n = new Node();
		n.item = i;
		
		if(size < 1){
			head = n;
			tail = n;
		} else {
			tail.next = n;
			tail = n;
		}	
		size++;
	}
	

	@Override
	public Iterator<Item> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<Item>{

		Node n = head;
		
		@Override
		public boolean hasNext() {
			return size > 0 && n.next != null;
		}

		@Override
		public Item next() {
			Item i = n.item;
			n = n.next;
			return i;
		}
		
	}
	
	

}
