import javax.swing.*;
import java.awt.*;

/*
 * Simple example swing app
 * */

public class Main{

	public static void main(String arg[]){
		JFrame fr = new JFrame("Example JTree");
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setContentPane(createUserInterface());
		fr.setSize(new Dimension(250, 250));	
	
		fr.show();
	}

	private static JComponent createUserInterface(){
		JTree jt = new JTree();
		jt.expandRow(1);
		return new JScrollPane(jt);
	}
}
