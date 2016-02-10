package tw.edu.ncu.ce.networkprogramming.guilab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoadImageExample extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4598360948068930982L;
	private JPanel contentPane;
	private JLabel mLabel;
	private JFrame mFrame;
	private JFileChooser fileChooser;
	private BufferedImage originalImage;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoadImageExample frame = new LoadImageExample();
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
	public LoadImageExample() {
		mFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		mLabel = new JLabel("");

		contentPane.add(mLabel, BorderLayout.CENTER);

		initialFileChooser();

		JButton btnOpen = new JButton("Open");

		contentPane.add(btnOpen, BorderLayout.SOUTH);
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					int returnVal = fileChooser
							.showOpenDialog(LoadImageExample.this);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File loadedFile = fileChooser.getSelectedFile();

						URL imageFileUrl = loadedFile.toURI().toURL();

						originalImage = ImageIO.read(imageFileUrl);

						mLabel.setIcon(new ImageIcon(originalImage));

						mFrame.pack();

					} else {
						System.out.println("Cancelled by user");
					}

				} catch (IOException e1) {

					e1.printStackTrace();
				}
			}
		});

		// resize image
		mFrame.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent evt) {

				int scaledHeight = (int) mLabel.getSize().getHeight();
				int scaledWidth = (int) mLabel.getSize().getWidth();

				//System.out.println("Label's dimension = " + scaledWidth + ","
				//		+ scaledHeight);

				if (originalImage != null) {

					BufferedImage scaledImage = new BufferedImage(scaledWidth,
							scaledHeight, BufferedImage.TYPE_INT_ARGB);

					scaledImage.getGraphics().drawImage(originalImage, 0, 0,
							scaledWidth, scaledHeight, null);
					mLabel.setIcon(new ImageIcon(scaledImage));
					scaledImage.getGraphics().dispose();

				}

			}
		});
	}

	private void initialFileChooser() {
		fileChooser = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter(
				"JPEG/png file", "jpg", "jpeg", "png");
		fileChooser.setFileFilter(filter);

	}
}
