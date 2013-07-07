package common;

import ds.LinkedList;
import ds.Node;

//import java.util.LinkedList;


public class GitTest {
	
	public static void main(String[] args) {
		out("Hello Git!");
		LinkedList integerList=new LinkedList();
		integerList.add(1).add(2).add(3).add(9);
		out(integerList.toString());
		out(integerList.getLast());
		Node interimNode=integerList.getLast();
		integerList.add(5).add(6).add(8);
		integerList.addAfter(interimNode, new Node(null, 4)); 		out(integerList);
		integerList.removeFirst();		out(integerList);
		integerList.removeAfter(interimNode); 		out(integerList);
		integerList.removeFromLast(1); 		out(integerList);
		integerList.removeAtIndex(2); 		out(integerList);



	}

	private static void out(Object value){
		System.out.println(value.toString());
		
	}
}
