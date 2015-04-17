package tw.edu.ncu.ce.networkprogramming.guilab;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class GUIExample {
	public GUIExample() {
		JFrame frame = new JFrame();
		JButton button = new JButton("我是按鈕");

		frame.add(button);// 將按鈕加到jframe上
		frame.setTitle("This is title.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack(); // 調整視窗大小，自動適應大小，使frame能正好顯示所有元件
		frame.setVisible(true);// 顯示視窗
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUIExample();
			}
		});
	}
}
