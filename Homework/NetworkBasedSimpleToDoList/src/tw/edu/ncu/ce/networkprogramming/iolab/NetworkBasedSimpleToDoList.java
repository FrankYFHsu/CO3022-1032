package tw.edu.ncu.ce.networkprogramming.iolab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.JPasswordField;

public class NetworkBasedSimpleToDoList extends JFrame {

	private static final long serialVersionUID = -176186259494030540L;
	private JPanel contentPane;
	private JList<String> tasksList;
	private DefaultListModel<String> taskListModel;
	private JTextField textField;
	private final Font PREFERRED_FONT = new Font("Arial", Font.PLAIN, 16);
	private JTextField userNameEntry;
	private String userName;
	private boolean isLogin = false;
	private JButton loginButton;
	private JPasswordField passwordField;
	//TODO Declare some variables

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NetworkBasedSimpleToDoList frame = new NetworkBasedSimpleToDoList();
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
	public NetworkBasedSimpleToDoList() {
		setTitle("Simple ToDoList");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		initialzeMenu();
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		taskListModel = new DefaultListModel<String>();
		tasksList = new JList<String>(taskListModel);
		tasksList.setFont(PREFERRED_FONT);
		scrollPane.setViewportView(tasksList);

		initialzeBottomPanel();
		initialzeUpperPanel();

	}

	private void initialzeBottomPanel() {
		JPanel bottomPanel = new JPanel();
		contentPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.LINE_AXIS));

		textField = new JTextField();
		textField.setFont(PREFERRED_FONT);
		textField.setColumns(10);

		JButton taskAdditionButton = new JButton("Add");
		taskAdditionButton.setFont(PREFERRED_FONT);
		taskAdditionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewTask();
			}
		});

		JButton taskDoneButton = new JButton("Done");
		taskDoneButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taskDone();
			}
		});
		taskDoneButton.setFont(PREFERRED_FONT);

		bottomPanel.add(textField);
		bottomPanel.add(taskAdditionButton);
		bottomPanel.add(taskDoneButton);
	}

	private void initialzeUpperPanel() {
		JPanel upperPanel = new JPanel();
		contentPane.add(upperPanel, BorderLayout.NORTH);
		upperPanel.setLayout(new BoxLayout(upperPanel, BoxLayout.X_AXIS));

		userNameEntry = new JTextField();
		upperPanel.add(userNameEntry);
		userNameEntry.setColumns(5);

		loginButton = new JButton("Log in");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login();
			}
		});

		passwordField = new JPasswordField();
		upperPanel.add(passwordField);
		upperPanel.add(loginButton);

		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				logout();
			}
		});
		upperPanel.add(logoutButton);
	}

	private void initialzeMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				saveTasks();
			}
		});
		KeyStroke key = KeyStroke.getKeyStroke(KeyEvent.VK_S,
				KeyEvent.CTRL_DOWN_MASK);
		mntmSave.setAccelerator(key);

		JMenuItem mntmLoad = new JMenuItem("Load");
		mntmLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearDisplayTasks();
				loadTasks();
			}
		});

		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JMenuItem mntmClearAll = new JMenuItem("Clear All");
		mntmClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearDisplayTasks();
			}
		});

		mnFile.add(mntmSave);
		mnFile.add(mntmLoad);
		mnFile.add(mntmClearAll);
		mnFile.add(mntmExit);
	}

	private void taskDone() {
		int selectedTaskIndex = tasksList.getSelectedIndex();
		if (selectedTaskIndex > -1) {

			taskListModel.remove(selectedTaskIndex);
		}

	}

	private void addNewTask() {
		String task = textField.getText();

		if (task.equals("") || task.replaceAll("\\s", "").equals("")) {
			Toolkit.getDefaultToolkit().beep();
			textField.requestFocusInWindow();
		} else {

			taskListModel.addElement(task);
			textField.setText("");
		}
	}

	private void login() {

		if (connect()) {
			isLogin = true;
			setUIEnabled(false);
			loadTasks();
		}

	}

	private boolean connect() {

		try {
			userName = userNameEntry.getText();
			if (userName.equals("")) {
				return false;
			}
			// TODO connect to server?

		} catch (Exception e) {
			JOptionPane
					.showMessageDialog(null, "Cannot connect to the server.");

			return false;
		}
		return true;
	}

	private void logout() {

		try {
			disConnect();
			isLogin = false;
			setUIEnabled(true);
			clearDisplayTasks();
			userName = null;
			userNameEntry.setText("");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void disConnect() throws IOException {
		// TODO
	}

	private void setUIEnabled(boolean enable) {
		loginButton.setEnabled(enable);
		passwordField.setEditable(enable);
		userNameEntry.setEditable(enable);
	}


	private void saveTasks() {

		if (!isLogin)
			return;
		// TODO

	}

	private void loadTasks() {

		if (!isLogin)
			return;
		clearDisplayTasks();
		// TODO

	}

	private void clearDisplayTasks() {

		taskListModel.clear();
	}

}
