package tw.edu.ncu.ce.networkprogramming.uithreadlab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LongRunningTaskWithProgressBar extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LongRunningTaskWithProgressBar frame = new LongRunningTaskWithProgressBar();
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
	public LongRunningTaskWithProgressBar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ImageLoader task = new ImageLoader();

				task.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent evt) {
						if ("progress".equals(evt.getPropertyName())) {
							progressBar.setValue((Integer) evt.getNewValue());
						}
					}
				});
				task.execute();
			}
		});
		contentPane.add(btnNewButton, BorderLayout.NORTH);

		label = new JLabel("");
		contentPane.add(label, BorderLayout.CENTER);

		progressBar = new JProgressBar();
		contentPane.add(progressBar, BorderLayout.SOUTH);
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

		ImageIcon icon = createImageIcon("light.png", "");
		return icon;
	}

	class ImageLoader extends SwingWorker<ImageIcon, Void> {

		@Override
		protected ImageIcon doInBackground() throws Exception {

			try {
				for (int i = 1; i <= 5; i++) {
					Thread.sleep(1000);// Simulate a long latency

					setProgress(i * 20);
				}

			} catch (InterruptedException e1) {

				e1.printStackTrace();
			}

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
