package common;

import ds.LinkedList;

//import java.util.LinkedList;


public class GitTest {
	
	public static void main(String[] args) {
		out("Hello Git!");
		LinkedList<Integer> integerList=new LinkedList<Integer>();
		integerList.add(1);//.add(2).add(3);
		out(integerList.toString());
		out(integerList.getLast());
	}

	private static void out(Object value){
		System.out.println(value.toString());
		
	}
}
