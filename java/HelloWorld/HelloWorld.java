public class HelloWorld {
	
	public static void main(String arg[]){
		String name = "World";
		if(arg.length>0){
			name = arg[0];
		}
		System.out.format("Hello %s!\n", name);
	}

}
