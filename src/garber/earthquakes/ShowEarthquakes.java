package garber.earthquakes;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class ShowEarthquakes extends JFrame {

	private final ListEarthquakes listEarthquakes;

	public ShowEarthquakes() {
		this.setSize(400, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());

		listEarthquakes = new ListEarthquakes();
		this.add(listEarthquakes, BorderLayout.CENTER);

		EarthquakesThread et = new EarthquakesThread(listEarthquakes);
		et.start();
	}

	public static void main(String[] args) {
		ShowEarthquakes app = new ShowEarthquakes();
		app.setVisible(true);

	}

}
