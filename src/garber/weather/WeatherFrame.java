package garber.weather;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class WeatherFrame extends JFrame {

	private final JButton button;
	private final JTextArea area;

	public WeatherFrame() {
		this.setTitle("Weather");
		this.setSize(800, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		button = new JButton("Enter");
		area = new JTextArea();

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		WeatherFrame app = new WeatherFrame();
		app.setVisible(true);
	}

}
