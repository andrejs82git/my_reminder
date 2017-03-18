import java.util.Map;

public class Main {

	public static void main(String arg[]){

		System.out.println("For use this test you cat use that:");
		System.out.println("java -Dtest=\"Hello World\"  Main Hello Andrej");

		System.out.println();
		System.out.println("Parameters by argument");
		for(String a :arg){
			System.out.println(a);
		}

		System.out.println();
		System.out.println("Parameters by -Dtest");
		System.out.println(System.getProperty("test"));

		System.out.println();
		System.out.println("Parameters from OS environment - PWD");
		System.out.println(System.getenv("PWD"));
	}

}
