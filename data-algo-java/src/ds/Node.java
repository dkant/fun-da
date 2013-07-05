package ds;

public class Node<T> {
	Node<T> next=null;
	T value;
	
	public Node(Node<T> next, T value) {
		this.next = next;
		this.value = value;
	}
	@Override
	public String toString() {
		return "[" +this.value.toString() + "]" ;
	}
}
