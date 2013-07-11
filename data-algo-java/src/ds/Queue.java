package ds;

public class Queue {
	Node first, last;
	
	public boolean isEmpty(){
		return first == null ? true : false;
	}

	public void enqueue(Node inNode){
		if(isEmpty()) first = inNode;
		else last.next = inNode;
		last = inNode;
		
	}
	
	public Node dequeue(){
		if(isEmpty()) return null;
		Node firstNode = first;
		first = first.next;
		return firstNode;	
	}
}
