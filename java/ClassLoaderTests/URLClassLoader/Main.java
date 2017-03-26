import java.io.*;
import java.net.*;
/*
 * testing class loaders
 *
 * */
public class Main {

		private static  final String remoteUrl = "https://raw.githubusercontent.com/andrejs82git/my_reminder/master/java/ClassLoaderTests/URLClassLoader/RmCl/";

	public static void main(String arg[]) throws Exception {
		System.out.println("Network class loader is working now. Loaded from url = " + remoteUrl);
		URLClassLoader loader = new URLClassLoader(new URL[] {new URL (remoteUrl)});
		Class c = loader.loadClass("RemoteClass");
		Runnable runnable = (Runnable) c.newInstance();
		runnable.run();
	}
}
