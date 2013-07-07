package ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListTest {
	LinkedList integerList;
	
	@Before public void setup(){
		integerList=new LinkedList();
		integerList.add(1).add(2).add(4).add(5).add(6).add(3);
	}


	@Test
	public void testAdd() {
		assertEquals("[1].[2].[4].[5].[6].[3].[8].", integerList.add(8).toString());
	}
	
	@Test
	public void testAddFirst() {
		integerList.addFirst(7);
		assertEquals("[7].[1].[2].[4].[5].[6].[3].", integerList.toString());
	}

	@Test
	public void testAddFirstToEmptyList() {
		LinkedList emptyList=new LinkedList();
		emptyList.addFirst(7);
		assertEquals("[7].", emptyList.toString());

	}

	@Test
	public void testIsEmpty() {
		assertTrue(new LinkedList().isEmpty());
	}

	@Test
	public void testGetLast() {
		assertEquals("[3]", integerList.getLast().toString());
	}

	@Test
	public void testGetFirst() {
		assertEquals("[1]", integerList.getFirst().toString());
	}

	@Test
	public void testAddLast() {
		integerList.addLast(8);
		assertEquals("[1].[2].[4].[5].[6].[3].[8].", integerList.toString());	}

	@Test
	public void testAddAfter() {
		Node interimNode=integerList.getLast();
		integerList.add(10);
		integerList.addAfter(interimNode, new Node(null, 4));
		assertEquals("[1].[2].[4].[5].[6].[3].[4].[10].", integerList.toString());	
	}

	@Test
	public void testRemoveFirst() {
		integerList.removeFirst();
		assertEquals("[2].[4].[5].[6].[3].", integerList.toString());	
	}

	@Test
	public void testRemoveLast() {
		integerList.removeLast();
		assertEquals("[1].[2].[4].[5].[6].", integerList.toString());	
	}

	@Test
	public void testRemoveAtIndex() {
		integerList.removeAtIndex(2);
		assertEquals("[1].[2].[5].[6].[3].", integerList.toString());
	}

	@Test
	public void testRemoveFromLast() {
		integerList.removeFromLast(2);
		assertEquals("[1].[2].[4].[6].[3].", integerList.toString());
	}

	@Test
	public void testRemoveAfter() {
		Node interimNode=integerList.getLast();
		integerList.add(10).add(11);
		integerList.removeAfter(interimNode);
		assertEquals("[1].[2].[4].[5].[6].[3].[11].", integerList.toString());	
	}

	@Test
	public void testToString() {
		assertEquals("[1].[2].[4].[5].[6].[3].", integerList.toString());
	}

	@Test public void duplicateShouldBeRemoved(){
		integerList.add(1).add(5);
		integerList.removeDuplicates();
		assertEquals("[1].[2].[4].[5].[6].[3].",integerList.toString());
	}
	
	
	@Test
	public void testAddBefore() {
		Node interimNode=integerList.getLast();
		integerList.add(10);
		integerList.addBefore(interimNode, new Node(null, 4));
		assertEquals("[1].[2].[4].[5].[6].[4].[3].[10].", integerList.toString());	
	}
	
	@Test public void testLowerBeforeAndLargerAfterX(){
		Node interimNode=integerList.getLast();
		integerList.add(10).add(3);
		integerList.lowerBeforeAndLargerAfterX(interimNode);
		assertEquals("[2].[1].[3].[3].[10].[6].[5].[4].", integerList.toString());	

	}
}
