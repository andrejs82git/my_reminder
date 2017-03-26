public class Main{

	public static void main(String arg[]){
		System.out.println("Info: Call with param: java Main 10");
		System.out.println("result is " + fibonacci(new Integer(arg[0])));
	}

	static long fibonacci(int n) {
		return n < 2 ? n : fibonacci(n-1) + fibonacci(n-2);
	}

}
