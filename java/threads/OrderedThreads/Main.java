/*
 * This example for showing how can be ordered threads 
 * by use lockObject(monitor) and wait/notifyAll methods.
 * */

public class Main{
	
	public static void main(String arg[]) {
		ContextThreadOrder lockObj = new ContextThreadOrder(); 
		for (int q =0 ; q < 10 ; q++) {
			Runnable runn = new MyRunnable(q, lockObj);
			new Thread(runn).start();
		}
	}
	
}

class ContextThreadOrder{
	private int current;

	int get(){
		return current;
	}

	void increment(){
		current++;
	}
}

class MyRunnable implements Runnable {

	private final int id;

	private final ContextThreadOrder lockObj; 

	MyRunnable (final int id, final ContextThreadOrder lockObj) {
		this.id = id;
		this.lockObj = lockObj;
	}
	
	public void run() {

		synchronized(lockObj){
			while(true){
				if(id > lockObj.get()){
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
			lockObj.increment();
			lockObj.notifyAll();
		}

	}


}
