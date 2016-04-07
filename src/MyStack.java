
public class MyStack<T> {
	
	private Node myTop;
	private int mySize;
	
	public MyStack() {
		mySize = 0;
	}
	
	private class Node {
		T myItem;
		Node myNext;
	}
	
	public boolean isEmpty() {
		boolean empty = true;
		
		if (mySize != 0) {
			empty = false;
		}
		
		return empty;
	}
	
	public void push(T item) {
		Node current = myTop;
		
		myTop = new Node();
		myTop.myItem = item;
		myTop.myNext = current;
		
		mySize++;
	}
	
	public T pop() {
		Node current = myTop;
		
		T itemToPop = myTop.myItem;
		
		myTop = myTop.myNext;
		mySize--;
		
		return itemToPop;
	}
	
	public T peek() {
		T item = myTop.myItem;
		return item;
	}
	
	public int size() {
		return mySize;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		
		Node current = myTop;
		T item;
		
		if (current != null) {
			item = current.myItem;
			sb.append(item);
			current = current.myNext;
		}
		
		while(current != null) {
			item = current.myItem;
			sb.append(", " + item);
			current = current.myNext;
		}
		
		sb.append("]");
		
		return sb.toString();
	}
}
