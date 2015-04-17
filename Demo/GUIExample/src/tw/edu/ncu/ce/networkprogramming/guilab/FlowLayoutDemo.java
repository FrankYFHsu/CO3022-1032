package tw.edu.ncu.ce.networkprogramming.guilab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FlowLayoutDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlowLayoutDemo frame = new FlowLayoutDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FlowLayoutDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 200);
		contentPane = new JPanel();

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new FlowLayout());
		setContentPane(contentPane);
		contentPane.add(new JButton("Button 1"));
		contentPane.add(new JButton("Button 2"));
		contentPane.add(new JButton("Button 3"));
		contentPane.add(new JButton("Long-Named Button 4"));
		contentPane.add(new JButton("5"));

	}

}
