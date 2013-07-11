package ds;

public class Stack {
	Node top;
	
	public Stack(){
		this.top = null;
	}
	
	public boolean isEmpty(){
		return top == null ? true : false;
	}

	public void push(Node node){
		if (!isEmpty()) node.next = top;
		top = node;
		
	}
	
	public Node pop(){
		if(isEmpty()) return null;
		Node topNode = top;
		top = topNode.next;
		return topNode;
	}
	
	public int peek(){
		return top.value;
	}
}
