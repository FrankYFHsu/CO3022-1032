package tw.edu.ncu.ce.networkprogramming.urllab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingWorker;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImageShowerWithSwingWorker extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JFrame mFrame;

	class ImageDownloader extends SwingWorker<BufferedImage, Void> {

		private URL url;

		public ImageDownloader(URL url) {
			this.url = url;
		}

		@Override
		protected BufferedImage doInBackground() throws Exception {
			Thread.sleep(5000);// Simulate a long latency

			return ImageIO.read(url);
		}

		@Override
		protected void done() {
			try {
				label.setIcon(new ImageIcon(get()));
				mFrame.pack();
			} catch (Exception ignore) {
			}
		}

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageShowerWithSwingWorker frame = new ImageShowerWithSwingWorker();
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
	public ImageShowerWithSwingWorker() {
		mFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		label = new JLabel("");

		contentPane.add(label, BorderLayout.CENTER);

		textField = new JTextField();
		textField.setText("http://www.ce.ncu.edu.tw/ce/images/logo/logo_blue.jpg");
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);

		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				URL url = null;
				try {
					url = new URL(textField.getText());

				} catch (MalformedURLException e1) {
				}

				new ImageDownloader(url).execute();

			}
		});
		contentPane.add(btnShow, BorderLayout.SOUTH);
	}

}
