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
	
	public void addAfter(Node<T> currentNode,Node<T> newNode){
		newNode.next=currentNode.next;
		currentNode.next=newNode;
	}
	
	public void removeFirst(){
		firstNode=firstNode.next;
		
	}
	
	public void removeLast(){
		Node<T> currentNode=this.firstNode;
		while(currentNode.next.next != null)
			currentNode=currentNode.next;
		currentNode.next=null;
		
		
	}
	
	public void removeAtIndex(int index){
		Node<T> nodeFollowingIndex=null;
		Node<T> currentNode=this.firstNode;
		for(int i=0; i < index && (nodeFollowingIndex = currentNode.next.next) != null; i++ )
			currentNode=currentNode.next;
		currentNode.next=nodeFollowingIndex.next;
		
		
	}
	
	
	public void removeFromLast(int n){
		Node<T> nPointer=movePointerByN(n);
		Node<T> nthLastNode=firstNode;
		while(nPointer.next != null){
			nPointer = nPointer.next;
			nthLastNode = nthLastNode.next;
		}
		nthLastNode.next=nthLastNode.next.next;
	}
	
	private Node<T> movePointerByN(int n) {
		Node<T> currentNode=this.firstNode;
		for(int i=0; i<= n && currentNode.next != null ; i ++ )
			currentNode=currentNode.next;
		return currentNode;
		}

	public void removeAfter(Node<T> currentNode){
		Node<T> obsoleteNode=currentNode.next;
		currentNode.next=currentNode.next.next;
		obsoleteNode.next=null;
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
