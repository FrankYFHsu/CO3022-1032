package tw.edu.ncu.ce.networkprogramming.guilab;

import javax.swing.JButton;
import javax.swing.JFrame;

public class GUIExampleExtendJFrame extends JFrame {

	public GUIExampleExtendJFrame() {

		JButton button = new JButton("This is a button");
		this.add(button);
		this.setTitle("This is title.");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUIExampleExtendJFrame();
			}
		});
	}

}
