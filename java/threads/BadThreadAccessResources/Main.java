/*
 * That bad way to use resource from multiple threads
 * */
public class Main{

	static final int ACCESS_COUNT = 100_000;

	static volatile int countOfAccess = 0;

	public static void main(String arg[]){
		for(int q = 0; q < ACCESS_COUNT ; q++) {
			new Thread(new MyRunnable(q)).start();
		}
		System.out.format("Should be count %d is %d", ACCESS_COUNT, countOfAccess);
	}
}

class MyRunnable implements Runnable{

	private final int id;

	MyRunnable(final int id){
		this.id = id;
	}

	public void run(){
		Main.countOfAccess++;
	}
}
