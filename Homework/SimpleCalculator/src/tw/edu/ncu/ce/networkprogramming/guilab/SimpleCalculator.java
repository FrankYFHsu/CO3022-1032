package tw.edu.ncu.ce.networkprogramming.guilab;

import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class SimpleCalculator extends JFrame {

	private static final int PREFFER_FONT_SIZE = 24;
	private static final int PREFFER_FONT_SIZE_LARGE = 32;
	private final Font PREFFER_FONT = new Font("Arial", Font.PLAIN,
			PREFFER_FONT_SIZE);
	private final Font PREFFER_FONT_LARGE = new Font("Arial", Font.PLAIN,
			PREFFER_FONT_SIZE_LARGE);

	private JPanel contentPane;
	private JTextArea display;
	private JPanel upperPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator frame = new SimpleCalculator();
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
	public SimpleCalculator() {
		setTitle("Simple Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);

		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		mnSettings.add(mntmReset);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0 };
		gbl_contentPane.rowWeights = new double[] { 0.0, 1.0 };
		contentPane.setLayout(gbl_contentPane);

		initialUpperPanel();
		initialBottomPanel();

	}

	private void initialUpperPanel() {
		upperPanel = new JPanel();
		GridBagConstraints gbc_upperPanel = new GridBagConstraints();
		gbc_upperPanel.insets = new Insets(0, 0, 5, 0);
		gbc_upperPanel.fill = GridBagConstraints.BOTH;
		gbc_upperPanel.gridx = 0;
		gbc_upperPanel.gridy = 0;
		contentPane.add(upperPanel, gbc_upperPanel);

		upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));

		display = new JTextArea();
		display.setEditable(false);
		display.setFont(PREFFER_FONT_LARGE);
		display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		upperPanel.add(display);

		Component rigidArea = Box.createRigidArea(new Dimension(8, 20));
		upperPanel.add(rigidArea);

		JButton btnClearError = new JButton("CE");
		btnClearError.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				display.setText("");

			}
		});
		btnClearError.setFont(PREFFER_FONT);
		upperPanel.add(btnClearError);

		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});
		btnClear.setFont(PREFFER_FONT);
		upperPanel.add(btnClear);
	}

	private void initialBottomPanel() {
		JPanel bottomPanel = new JPanel();
		GridBagConstraints gbc_bottomPanel = new GridBagConstraints();
		gbc_bottomPanel.insets = new Insets(0, 0, 5, 0);
		gbc_bottomPanel.fill = GridBagConstraints.BOTH;
		gbc_bottomPanel.gridx = 0;
		gbc_bottomPanel.gridy = 1;
		contentPane.add(bottomPanel, gbc_bottomPanel);
		bottomPanel.setLayout(new GridLayout(4, 4, 0, 0));

		JButton btn7 = new JButton("7");

		btn7.setFont(PREFFER_FONT);
		bottomPanel.add(btn7);

		JButton btn8 = new JButton("8");

		btn8.setFont(PREFFER_FONT);
		bottomPanel.add(btn8);

		JButton btn9 = new JButton("9");

		btn9.setFont(PREFFER_FONT);
		bottomPanel.add(btn9);

		JButton btnDivide = new JButton("/");

		btnDivide.setFont(PREFFER_FONT);
		bottomPanel.add(btnDivide);

		JButton btn4 = new JButton("4");

		btn4.setFont(PREFFER_FONT);
		bottomPanel.add(btn4);

		JButton btn5 = new JButton("5");

		btn5.setFont(PREFFER_FONT);
		bottomPanel.add(btn5);

		JButton btn6 = new JButton("6");

		btn6.setFont(PREFFER_FONT);
		bottomPanel.add(btn6);

		JButton btnMultiply = new JButton("X");

		btnMultiply.setFont(PREFFER_FONT);
		bottomPanel.add(btnMultiply);

		JButton btn1 = new JButton("1");

		btn1.setFont(PREFFER_FONT);
		bottomPanel.add(btn1);

		JButton btn2 = new JButton("2");

		btn2.setFont(PREFFER_FONT);
		bottomPanel.add(btn2);

		JButton btn3 = new JButton("3");

		btn3.setFont(PREFFER_FONT);
		bottomPanel.add(btn3);

		JButton btnSubtract = new JButton("-");

		btnSubtract.setFont(PREFFER_FONT);
		bottomPanel.add(btnSubtract);

		JButton btnDot = new JButton(".");

		btnDot.setFont(PREFFER_FONT);
		bottomPanel.add(btnDot);

		JButton btn0 = new JButton("0");

		btn0.setFont(PREFFER_FONT);
		bottomPanel.add(btn0);

		JButton btnEqual = new JButton("=");

		btnEqual.setForeground(Color.RED);
		btnEqual.setFont(PREFFER_FONT);
		bottomPanel.add(btnEqual);

		JButton btnAdd = new JButton("+");

		btnAdd.setFont(PREFFER_FONT);
		bottomPanel.add(btnAdd);

	}

}
