package ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	Stack stack;

	@Before public void setup(){
		stack=new Stack();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(stack.isEmpty());

	}

	@Test
	public void testPush() {
		stack.push(new Node(null, 1));
		assertFalse(stack.isEmpty());
		assertEquals(1, stack.peek());
	}

	@Test
	public void testPopOne() {
		stack.push(new Node(null, 1));
		assertEquals("[1]", stack.pop().toString());
	}
	
	@Test
	public void testPushTwoPopOne() {
		stack.push(new Node(null, 1));
		stack.push(new Node(null, 2));
		assertEquals("[2]", stack.pop().toString());
		assertFalse(stack.isEmpty());

	}
	
	@Test
	public void testPopNull() {
		assertNull(stack.pop());
	}

}
