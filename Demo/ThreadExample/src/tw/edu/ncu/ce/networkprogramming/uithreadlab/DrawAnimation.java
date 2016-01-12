package tw.edu.ncu.ce.networkprogramming.uithreadlab;

import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DrawAnimation {

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.add(new ArchimedeanSpiralPanel());
				frame.setSize(500, 500);
				frame.pack();
				frame.setVisible(true);
			}
		});
	}
}

class ArchimedeanSpiralPanel extends JPanel {

	private Timer timer;
	private BufferedImage surface;

	private JLabel view;

	private int lastX = 0;
	private int lastY = 0;

	private int centerX;
	private int centerY;

	private int time = 0;

	public ArchimedeanSpiralPanel() {

		initialSurface();
		initialTimer();

	}

	private void initialSurface() {
		surface = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		view = new JLabel(new ImageIcon(surface));
		add(view);
		lastX = centerX = 500 / 2;
		lastY = centerY = 500 / 2;

	}

	private void initialTimer() {

		/*
		 * The action event handlers for Timers execute on the event-dispatching
		 * thread.
		 */
		ActionListener taskPerformer = new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				paintSurface();
			}
		};

		timer = new Timer(100, taskPerformer);
		timer.start();
	}

	private void paintSurface() {
		Graphics2D g2d = (Graphics2D) surface.getGraphics();

		double r = 0.5 * (1 + time);
		int x = (int) (r * Math.cos(10 * time * Math.PI / 180)) + centerX;
		int y = (int) (r * Math.sin(10 * time * Math.PI / 180)) + centerY;

		g2d.drawLine(lastX, lastY, x, y);
		lastX = x;
		lastY = y;
		time++;

		view.repaint();

	}

}