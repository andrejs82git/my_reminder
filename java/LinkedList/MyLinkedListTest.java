import java.util.*;
import org.junit.*;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class MyLinkedListTest{

	@Test
	public void simpleTest() {
		MyLinkedList list = new MyLinkedList<Integer>();
		list.add(1);
		list.add(2);

		assertThat(list.size(), is(2));
	}

	@Test
	public void simpleGetTest() {
		MyLinkedList list = new MyLinkedList<Integer>();
		list.add(1);
		list.add(2);

		assertThat(list.get(0), is(1));
		assertThat(list.get(1), is(2));
	}

	@Test
	public void assertException() {
		MyLinkedList list = new MyLinkedList<Integer>();
		list.add(1);
		list.add(2);

		try{
			list.get(3);
			fail("method must throw exception!");
		}catch(IndexOutOfBoundsException e) {}

		try{
			list.get(-1);
			fail("method must throw exception!");
		}catch(IndexOutOfBoundsException e) {}
	}

}
