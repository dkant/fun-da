package ds;

public class LinkedList<T> {
	private Node<T> firstNode;

	/* Methods */
	public LinkedList() {
		this.firstNode = null;
	}

	public void addFirst(T value) {
		Node<T> holder = this.firstNode; // Hold first node temporarily
		this.firstNode = new Node<T>(holder, value); // Point new node to first
														// node. New Node
														// becomes first node
	}

	public LinkedList<T> add(T value) {
		addLast(value);
		return this;
	}

	public boolean isEmpty() {
		return this.firstNode == null ? true : false;
	}

	public Node<T> getLast() {
		if (isEmpty())
			return null;
		else
			return theLastNode();

	}
	
	public Node<T> getFirst(){
		return this.firstNode;
	}
	
	public void addLast(T value) {
		if (isEmpty())
			addFirst(value);
		this.getLast().next = new Node<T>(null, value);
	}
	
	public void addAfter(Node currentNode,Node newNode){
		
	}
	
	public void removeFirst(){
		
	}
	
	public void removeLast(){
		
	}
	
	public void removeAfter(){
		
	}
	/* Overridden Methods */

	@Override
	public String toString() {
		StringBuffer outString = new StringBuffer();
		iterateUntilEnd(outString);
		return outString.toString();
	}

	/* Private Methods */

	private void iterateUntilEnd(StringBuffer outString) {
		Node<T> currentNode = this.firstNode;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
			outString.append(currentNode.toString()).append(".");
		}
	}

	private Node<T> theLastNode() {
		Node<T> currentNode = this.firstNode;
		while (currentNode.next != null) {
			currentNode = currentNode.next;
		}
		return currentNode;
	}

}
