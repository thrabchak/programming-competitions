import java.util.ArrayList;
import java.util.Iterator;

public class CircularList<Item> implements Iterable<Item> {
	
	private class Node{
		public Item item;
		public Node next;
		public Node prev;
	}
	
	Node head;
	Node tail;
	int size = 0;
	
	public CircularList(ArrayList<Item> items) {
		for(int i = 0; i < items.size(); i++){
			Node n = new Node();
			n.item = items.get(i);
			if(i == 0){
				head = n;
				tail = n;
				n.next = n;
				n.prev = n;
			} else {
				tail.next = n;
				n.prev = tail;
				n.next = head;
				tail = n;
			}
			size++;
		}
	}	

	@Override
	public Iterator<Item> iterator() {
		return new CircularListIterator();
	}
	
	private class CircularListIterator implements Iterator<Item>{

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
		
		public Item prev() {
			Item i = n.item;
			n = n.prev;
			return i;
		}
		
		public void remove() {
			if(size < 1){
				head = null;
				tail = null;
				n = null;
			} else {
				n.prev = n.next;
				n.next = n.prev;
				n = n.next;
			}
		}
				
	}
	
	public String toString(){
		String output = "";
		for(Item i : this)
			output += i + "\n";
		return output;
	}
	
	

}
