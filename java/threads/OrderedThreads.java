/*
 * This example for showing how can be ordered threads 
 * by use lockObject(monitor) and wait/notifyAll methods.
 * */

public class OrderedThreads{
	
	public static void main(String arg[]) {
		for (int q =0 ; q < 10 ; q++) {
			Runnable runn = new MyRunnable(q);
			new Thread(runn).start();
		}
	}
	
}

class MyRunnable implements Runnable {

	private final int id;

	private static int current;

	private static Object lockObj = new Object();

	MyRunnable (final int id) {
		this.id = id;
	}
	
	public void run() {

		synchronized(lockObj){
			while(true){
				if(id > current){
					try{
						lockObj.wait();
 					} catch(Exception e){
						e.printStackTrace();
					}
				}else{
					break;
				}
			}	
		
			System.out.println("Runnable" + id );
			current++;
			lockObj.notifyAll();

		}

	}


}
