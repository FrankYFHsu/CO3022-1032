package tw.edu.ncu.ce.networkprogramming.guilab;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BorderLayoutDemo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorderLayoutDemo frame = new BorderLayoutDemo();
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
	public BorderLayoutDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
				
		JButton button = new JButton("Button 1 (PAGE_START)");
		contentPane.add(button, BorderLayout.PAGE_START);
				
		button = new JButton("Button 2 (CENTER)");
		button.setPreferredSize(new Dimension(200, 200));
		contentPane.add(button, BorderLayout.CENTER);

		button = new JButton("Button 3 (LINE_START)");
		contentPane.add(button, BorderLayout.LINE_START);

		button = new JButton("Long-Named Button 4 (PAGE_END)");
		contentPane.add(button, BorderLayout.PAGE_END);

		button = new JButton("5 (LINE_END)");
		contentPane.add(button, BorderLayout.LINE_END);


	}

}
