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
	public void simpleGetWithALotOfItemsTest() {
		MyLinkedList list = new MyLinkedList<Integer>();
		for(int q = 0; q <= 1000; q++){
			list.add(q);
		}

		assertThat(list.get(0), is(0));
		assertThat(list.get(10), is(10));
		assertThat(list.get(1000), is(1000));
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

		try{
			list.set(-1, 5);
			fail("method must throw exception!");
		}catch(IndexOutOfBoundsException e) {}

		try{
			list.set(5, 5);
			fail("method must throw exception!");
		}catch(IndexOutOfBoundsException e) {}

		try{
			list.remove(Integer.valueOf(5));
		}catch(IndexOutOfBoundsException e) {
			fail("method must throw exception!");
		}

		try{
			list.remove(5);
			fail("method must throw exception!");
		}catch(IndexOutOfBoundsException e) {}
	}

	@Test
	public void setTest() {
		MyLinkedList list = new MyLinkedList<Integer>();
		for(int q = 0; q <= 10; q++){
			list.add(q);
		}

		assertThat(list.get(0), is(0));
		assertThat(list.get(10), is(10));
		list.set(5, 11);
		assertThat(list.get(5), is(11));
	}
	
	@Test
	public void removeByObjectTest() {
		MyLinkedList list = new MyLinkedList<Integer>();
		for(int q = 0; q <= 10; q++){
			list.add(""+q);
		}

		assertThat(list.get(0), is("0"));
		assertThat(list.get(10), is("10"));
		assertThat(list.remove("not in collection"), is(false));
		assertThat(list.size(), is(11));
		assertThat(list.remove("5"), is(true));
		assertThat(list.size(), is(10));
		assertThat(list.get(5), is("6"));

		assertThat(list.remove("0"), is(true));
		assertThat(list.size(), is(9));
		assertThat(list.remove("10"), is(true));
		assertThat(list.size(), is(8));
	}
	
	@Test
	public void removeByIndexTest(){
		MyLinkedList list = new MyLinkedList<Integer>();
		for(int q = 0; q <= 10; q++){
			list.add(""+q);
		}

		assertThat(list.size(),is(11));
		assertThat(list.remove(5), is("5"));
		assertThat(list.size(),is(10));

		assertThat(list.remove(0), is("0"));
		assertThat(list.size(),is(9));

		assertThat(list.remove(list.size()-1), is("10"));
		assertThat(list.size(),is(8));
	}

	@Test
	public void indexOfTest(){
		MyLinkedList list = new MyLinkedList<Integer>();
		for(int q = 0; q <= 10; q++){
			list.add(""+q);
		}

		assertThat(list.indexOf("not in collection") ,is(-1));

		assertThat(list.indexOf("0") ,is(0));
		assertThat(list.indexOf("5") ,is(5));
		assertThat(list.indexOf("10") ,is(10));

		assertThat(list.indexOf("10") ,is(10));

	}

}
