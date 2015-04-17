package tw.edu.ncu.ce.networkprogramming.urllab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ImageShower extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel label;
	private JFrame mFrame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageShower frame = new ImageShower();
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
	public ImageShower() {
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
		contentPane.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		textField
				.setText("http://www.ce.ncu.edu.tw/ce/images/logo/logo_blue.jpg");
		JButton btnShow = new JButton("Show");
		btnShow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BufferedImage myPicture;
				try {
					URL url = new URL(textField.getText());

					myPicture = ImageIO.read(url);
					Thread.sleep(5000);// Simulate a long latency
					label.setIcon(new ImageIcon(myPicture));
					
					mFrame.pack();
					
				} catch (IOException e1) {

					e1.printStackTrace();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		contentPane.add(btnShow, BorderLayout.SOUTH);
	}

}
