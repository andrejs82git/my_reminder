
public class MyLinkedList<T> {
	private Item<T> first;
	private Item<T> last;

	private int size = 0;

	public MyLinkedList(){

	}

	public int size(){
		return size;
	}

	public boolean add(T object){
		Item<T> newItem = new Item<T>();
		newItem.value = object;

		if(first == null) {
			 first = last = newItem;
		}else{
			newItem.prev = last;
			last = last.next = newItem;
		}	
		size++;
		return true;
	}

	public T get(int index){
		if(index<0){
			throwOut(index);
		}
		int i = 0;
		Item<T> item = first;
		while(item != null && i < index) {
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
		while(item != null && i < index ) {
			i++;
			item = item.next;
		}
		if(item == null) {
			throwOut(index);
		}
		item.value = value;
	}

	public boolean remove(Object o){
		Item<T> item = first;
		while(item != null && !o.equals(item.value)) {
			item = item.next;
		}
		if(item == null) {
			return false;
		}

		spliceOne(item);
		size--;
		return true;
	}

	public T remove(int index){
		if(index<0){
			throwOut(index);
		}
		int i = 0;
		Item<T> item = first;
		while(item != null && i < index ) {
			i++;
			item = item.next;
		}
		if(item == null) {
			throwOut(index);
		}
		spliceOne(item);	
		size--;
		return item.value;
	}

	private void spliceOne(Item item){
		Item prev = item.prev;
		Item next = item.next;
		if(prev!=null){
			prev.next = next;
		} else {
			first = next;
		}
		if(next!=null){
			next.prev = prev;
		} else {
			last = prev;
		}
		first.prev = null;
		last.next = null;
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
