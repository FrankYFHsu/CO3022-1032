package tw.edu.ncu.ce.networkprogramming.uithreadlab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

public class LongRunningTaskWithThread extends JFrame {

	private JPanel contentPane;
	private JLabel label;
	private JTextField txtInput;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LongRunningTaskWithThread frame = new LongRunningTaskWithThread();
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
	public LongRunningTaskWithThread() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnStart = new JButton("Load image");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				 * may function correctly most of the time, but are subject to
				 * unpredictable errors
				 */
				new Thread(new Runnable() {
					public void run() {
						try {
							if (!SwingUtilities.isEventDispatchThread()) {
								System.out.println("no");
							}
							ImageIcon icon = loadImage();
							label.setIcon(icon);
							pack();
						} catch (Exception e) {
							e.printStackTrace();
						}
					};
				}).start();
			}
		});
		contentPane.add(btnStart, BorderLayout.NORTH);

		label = new JLabel();
		contentPane.add(label, BorderLayout.CENTER);

		txtInput = new JTextField();
		txtInput.setText("try to key something in");
		contentPane.add(txtInput, BorderLayout.SOUTH);
		txtInput.setColumns(10);
	}

	/** Returns an ImageIcon, or null if the path was invalid. */
	protected ImageIcon createImageIcon(String path, String description) {
		URL imgURL = getClass().getResource(path);
		if (imgURL != null) {
			return new ImageIcon(imgURL, description);
		} else {
			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	private ImageIcon loadImage() {
		try {
			if (SwingUtilities.isEventDispatchThread()) {
				System.out.println("in EDT");
			}
			Thread.sleep(5000);// Simulate a long latency
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		ImageIcon icon = createImageIcon("light.png", "");
		return icon;
	}

}
