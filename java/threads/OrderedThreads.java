/*
 * This example for showing how can be ordered threads 
 * by use lockObject(monitor) and wait/notifyAll methods.
 * */

public class OrderedThreads{
	
	public static void main(String arg[]) {
		Object lockObj = new Object();
		for (int q =0 ; q < 10 ; q++) {
			Runnable runn = new MyRunnable(q, lockObj);
			new Thread(runn).start();
		}
	}
	
}

class MyRunnable implements Runnable {

	private final int id;

	private static int current;

	private final Object lockObj; 

	MyRunnable (final int id, final Object lockObj) {
		this.id = id;
		this.lockObj = lockObj;
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
