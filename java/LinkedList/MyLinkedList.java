
public class MyLinkedList<T> {
	private Item<T> first;
	private Item<T> last;

	private int size = 0;

	public MyLinkedList(){

	}

	public void add(T object){
		Item<T> newItem = new Item<T>();
		newItem.value = object;

		if(first == null) {
			 first = last = newItem;
		}else{
			last = last.next = newItem;
			newItem.prev = newItem;
		}	
		size++;
	}

	public int size(){
		return size;
	}

	public T get(int index){
		if(index<0){
			throwOut(index);
		}
		int i = 0;
		Item<T> item = first;
		while(i < index && item != null) {
			i++;
			item = item.next;
		}
		if(item == null) {
			throwOut(index);
		}
		return item.value;
	}
	
	public void set(int index, T value) {
		if(index<0){
			throwOut(index);
		}
		int i = 0;
		Item<T> item = first;
		while(i < index && item != null) {
			i++;
			item = item.next;
		}
		if(item == null) {
			throwOut(index);
		}
		item.value = value;
	}

	private static void throwOut(int index){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bound!");
	}

	private static class Item<T>{
		private Item prev;
		private Item next;
		private T value;
	}

}
