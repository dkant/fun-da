package ds;

public class Node{
	Node next=null;
	Integer value;
	
	public Node(Node next, Integer value) {
		this.next = next;
		this.value = value;
	}
	
	
	@Override
	public String toString() {
		return "[" +this.value.toString() + "]" ;
	}
}
