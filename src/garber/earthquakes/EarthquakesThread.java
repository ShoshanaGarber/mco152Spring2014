package garber.earthquakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class EarthquakesThread extends Thread {

	private final ListEarthquakes listEarthquakes;
	private Earthquake earthquake;

	public EarthquakesThread(ListEarthquakes listEarthquakes) {
		this.listEarthquakes = listEarthquakes;

	}

	@Override
	public void run() {
		super.run();

		URL url;
		try {
			url = new URL("http://earthquake-report.com/feeds/recent-eq?json");
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			Gson gson = new Gson();
			earthquake = gson.fromJson(reader, Earthquake.class);

			listEarthquakes.repaint();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
