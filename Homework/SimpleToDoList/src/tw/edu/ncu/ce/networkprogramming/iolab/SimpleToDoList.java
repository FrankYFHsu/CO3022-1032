package tw.edu.ncu.ce.networkprogramming.iolab;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.KeyStroke;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SimpleToDoList extends JFrame {

	private JPanel contentPane;
	private JList<String> tasksList;
	private DefaultListModel<String> taskListModel;
	private JTextField textField;
	private final Font PREFERRED_FONT = new Font("Arial", Font.PLAIN, 16);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleToDoList frame = new SimpleToDoList();
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
	public SimpleToDoList() {
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

		JLabel taskLabel = new JLabel("Todo tasks");
		taskLabel.setFont(PREFERRED_FONT);
		upperPanel.add(taskLabel);
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
			// TODO 刪除選擇的task, 請操作 taskListModel
		}

	}

	private void addNewTask() {
		String task = textField.getText();

		if (task.equals("") || task.replaceAll("\\s", "").equals("")) {
			Toolkit.getDefaultToolkit().beep();
			textField.requestFocusInWindow();
		} else {
			// TODO 在list上新增一筆task, 請操作 taskListModel

		}
	}

	private void saveTasks() {
		// TODO 存檔, 使用I/O類即可

	}

	private void loadTasks() {
		// TODO 讀檔, 使用I/O類即可

	}

	private void clearDisplayTasks() {
		// TODO 清除taskslist, 請操作 taskListModel

	}

}
