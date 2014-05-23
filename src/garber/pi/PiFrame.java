package garber.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class PiFrame extends JFrame implements ActionListener, Runnable {

	private final JButton button;
	private final JTextArea area;

	public PiFrame() {
		this.setTitle("Pi");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("Start");
		area = new JTextArea();
		button.addActionListener(this);

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);

		this.setVisible(true);

	}

	public static void main(String[] args) {
		PiFrame app = new PiFrame();
		app.setVisible(true);
	}
                                                                                                              
	@Override
	public void run() {
		double pi = 0;
		for (int i = 1; i < 1000000000; i++) {
			pi += 4 * (Math.pow(-1, i + 1) / (2 * i - 1));
			area.setText(String.valueOf(pi));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();
	}

}
