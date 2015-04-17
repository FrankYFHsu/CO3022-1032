package tw.edu.ncu.ce.networkprogramming.guilab;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class GridBagLayoutDemo extends JFrame {

	private JPanel contentPane;
	private JPanel panel ;
	private JPanel panel_1;

	private JTextField textField;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GridBagLayoutDemo frame = new GridBagLayoutDemo();
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
	public GridBagLayoutDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				//lblNewLabel.setText(btnNewButton.getBounds().getWidth()+","+btnNewButton.getBounds().getHeight());
				//lblNewLabel_1.setText(btnNewButton2.getBounds().getWidth()+","+btnNewButton2.getBounds().getHeight());
				System.out.println("contentPane height = "+contentPane.getBounds().getHeight());
				System.out.println("Panel1 height = "+panel.getBounds().getHeight());
				System.out.println("Panel2 height = "+panel_1.getBounds().getHeight());
				
			}
		});
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0,};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0};
		gbl_contentPane.rowWeights = new double[]{1.0, 4.0};
		contentPane.setLayout(gbl_contentPane);
		
		panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setPreferredSize(new Dimension(0,0));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setPreferredSize(new Dimension(0,0));
		
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		
		
		
	}

}
