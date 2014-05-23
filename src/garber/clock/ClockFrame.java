package garber.clock;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class ClockFrame extends JFrame {

	private final ClockThread thread;
	private final Clock clock;
	private final JTextArea area;

	public ClockFrame() {

		this.setTitle("Time");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setLayout(new BorderLayout());

		// GregorianCalendar currentTime = (GregorianCalendar) Calendar
		// .getInstance();

		// clock = new Clock(currentTime);
		clock = new Clock();
		area = new JTextArea();
		this.add(clock);
		add(area, BorderLayout.SOUTH);

		thread = new ClockThread(clock);
		// area.setText(String.valueOf(currentTime.getTime().toString()));
		thread.start();
		this.setVisible(true);

	}

	public static void main(String[] args) {

		ClockFrame app = new ClockFrame();
		app.setVisible(true);

	}

}
