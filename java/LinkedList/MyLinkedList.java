
public class MyLinkedList<T> {
	private Item<T> first;
	private Item<T> last;

	public MyLinkedList(){

	}

	public void add(T item){
		if(first == null) {
			first = last = new Item<T>();
		}else{
			last = last.next = new Item<T>();
		}	
		last.value = item;
	}

	public int size(){
		int size = 0;
		Item item = first;
		while(item != null) {
			item = item.next;
			size++;
		}
		return size;
	}

	public T get(int index){
		if(index<0){
			throw new IndexOutOfBoundsException("Index " + index + " is out of bound!");
		}
		int i = 0;
		Item<T> item = first;
		while(i < index && item != null) {
			i++;
			item = item.next;
		}
		if(item == null) {
			throw new IndexOutOfBoundsException("Index " + index + " is out of bound!");
		}
		return item.value;
	}
	

	private static class Item<T>{
		private Item next;
		private T value;
	}

}
