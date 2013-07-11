package ds;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class QueueTest {
	Queue queue;

	@Before public void setup(){
		queue=new Queue();
	}

	@Test
	public void testIsEmpty() {
		assertTrue(queue.isEmpty());

	}

	@Test
	public void testEnQ() {
		queue.enqueue(new Node(null, 1));
		assertFalse(queue.isEmpty());
	}

	@Test
	public void testDequeueOne() {
		queue.enqueue(new Node(null, 1));
		assertEquals("[1]", queue.dequeue().toString());
	}
	
	@Test
	public void testPushTwoPopOne() {
		queue.enqueue(new Node(null, 1));
		queue.enqueue(new Node(null, 2));
		assertEquals("[1]", queue.dequeue().toString());
		assertFalse(queue.isEmpty());

	}
	
	@Test
	public void testPopNull() {
		assertNull(queue.dequeue());
	}

}
