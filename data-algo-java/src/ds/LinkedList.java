package ds;

public class LinkedList {
	private Node firstNode;

	/* Methods */
	public LinkedList() {
		this.firstNode = null;
	}

	public void addFirst(Integer value) {
		Node holder = firstNode; 
		this.firstNode = new Node(holder, value); 
	}

	public LinkedList add(Integer value) {
		addLast(value);
		return this;
	}

	public boolean isEmpty() {
		return this.firstNode == null ? true : false;
	}

	public Node getLast() {
		if (isEmpty())
			return null;
		else
			return theLastNode();

	}
	
	public Node getFirst(){
		return this.firstNode;
	}
	
	public void addLast(Integer value) {
		if (isEmpty())
			addFirst(value);
		else this.getLast().next = new Node(null, value);
	}
	
	public void addAfter(Node currentNode,Node newNode){
		newNode.next=currentNode.next;
		currentNode.next=newNode;
	}
	
	
	public void addBefore(Node currentNode,Node newNode){
		Integer newNodeValue = newNode.value;
		newNode.next=currentNode.next;
		newNode.value=currentNode.value;
		currentNode.next = newNode;
		currentNode.value=newNodeValue;
	}
	
	public void removeFirst(){
		firstNode=firstNode.next;
		
	}
	
	public void removeLast(){
		Node currentNode=this.firstNode;
		while(currentNode.next.next != null)
			currentNode=currentNode.next;
		currentNode.next=null;
		
		
	}
	
	public void removeAtIndex(int index){
		Node nodeFollowingIndex=null;
		Node currentNode=this.firstNode;
		for(int i=1; i < index && (nodeFollowingIndex = currentNode.next.next) != null; i++ )
			currentNode=currentNode.next;
		currentNode.next=nodeFollowingIndex.next;
	}
	
	
	public void removeFromLast(int n){
		Node nPointer=movePointerByN(n);
		Node nthLastNode=firstNode;
		while(nPointer.next != null){
			nPointer = nPointer.next;
			nthLastNode = nthLastNode.next;
		}
		nthLastNode.next=nthLastNode.next.next;
	}
	
	private Node movePointerByN(int n) {
		Node currentNode=this.firstNode;
		for(int i=0; i<= n && currentNode.next != null ; i ++ )
			currentNode=currentNode.next;
		return currentNode;
		}

	public void removeAfter(Node currentNode){
		Node obsoleteNode=currentNode.next;
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

	@Override public boolean equals(Object obj) {	
		if(this == null && obj == null) return true;
		else if ( (this == null && obj != null) || (this != null && obj == null)) return false;
		else return this.compareIntegero((LinkedList)obj);
		
	};
	/* Private Methods */

	private boolean compareIntegero(LinkedList inComingList){
		Node thisFirstNode= this.firstNode;
		Node incomingFirstNode= inComingList.getFirst();
		boolean isEquals = false;
		
		while (thisFirstNode.next != null) {
			if(thisFirstNode.value == incomingFirstNode.value) 
			{
				thisFirstNode = thisFirstNode.next;
				incomingFirstNode = incomingFirstNode.next;
				isEquals=true;
			}
			else {
				isEquals = false;
				break;
			}

		}
		
		return isEquals;
	}
	
	private void iterateUntilEnd(StringBuffer outString) {
		Node currentNode = this.firstNode;
		while (currentNode != null) {
			outString.append(currentNode.toString()).append(".");
			currentNode = currentNode.next;
		}
	}

	private Node theLastNode() {
		Node currentNode = this.firstNode;
		currentNode = goToEndOfList(currentNode);
		return currentNode;
	}

	public void removeDuplicates() {
		if(firstNode == null) return;
		
		Node slowPointer = firstNode;
		while(slowPointer != null){
			Node runner = slowPointer;
			while(runner.next != null){
				if(slowPointer.value == runner.next.value) {
					runner.next=runner.next.next;
				}else{
				runner = runner.next;
				}
			}
			slowPointer = slowPointer.next;
		}
		
	}

	
	public void lowerBeforeAndLargerAfterX(Node interimNode){
		
		Node beforeList = null;
		Node afterList = null;
		Node currentList = null;
		Node currentNode = firstNode;
		
		while(currentNode != null){
			
			Node next=currentNode.next;
			
			if(currentNode.value < interimNode.value){
				beforeList = addBeforeHead(beforeList, currentNode);
			}else if(currentNode.value > interimNode.value){
				afterList = addBeforeHead(afterList, currentNode);
			}else{
				currentList = addBeforeHead(currentList, currentNode);
			}
			
			currentNode=next;
		}
		
		if(beforeList == null) firstNode = afterList;
		
		Node head=beforeList;
		goToEndOfList(beforeList).next = currentList;
		goToEndOfList(currentList).next = afterList;
		firstNode=head;
	}

	private Node addBeforeHead(Node beforeList, Node currentNode) {
		currentNode.next=beforeList;
		beforeList=currentNode;
		return beforeList;
	}

	private Node goToEndOfList(Node currentList) {
		while(currentList.next !=null){
			currentList=currentList.next;
		}
		return currentList;
	}
	
	

}
