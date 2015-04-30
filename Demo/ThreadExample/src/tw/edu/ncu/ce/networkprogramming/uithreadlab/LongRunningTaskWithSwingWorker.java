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
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;



public class LongRunningTaskWithSwingWorker extends JFrame {

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
					LongRunningTaskWithSwingWorker frame = new LongRunningTaskWithSwingWorker();
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
	public LongRunningTaskWithSwingWorker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnStart = new JButton("Load image");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ImageLoader().execute();
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
			if(SwingUtilities.isEventDispatchThread()){
				System.out.println("in EDT");
			}
			Thread.sleep(5000);// Simulate a long latency
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}
		ImageIcon icon = createImageIcon("light.png", "");
		return icon;
	}

	class ImageLoader extends SwingWorker<ImageIcon, Void> {

		@Override
		protected ImageIcon doInBackground() throws Exception {

			return loadImage();
		}

		@Override
		protected void done() {
			try {

				label.setIcon(get());
				pack();
			} catch (Exception ignore) {
			}
		}

	}

}
