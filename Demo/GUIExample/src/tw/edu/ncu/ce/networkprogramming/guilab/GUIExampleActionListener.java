package tw.edu.ncu.ce.networkprogramming.guilab;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GUIExampleActionListener extends JFrame{


	public GUIExampleActionListener() {

		JButton button = new JButton("This is a button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Hi");
			}

		});

		this.add(button);
		this.setTitle("This is title.");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUIExampleActionListener();
			}
		});
	}
}
