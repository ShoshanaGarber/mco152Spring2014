package garber.weather;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;

public class WeatherMain {
	public static void main(String[] args) throws IOException {

		URL url = new URL(
				"http://api.openweathermap.org/data/2.5/weather?q=London,uk");

		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));

		Gson gson = new Gson();
		WeatherConditions wc = gson.fromJson(reader, WeatherConditions.class);
		System.out.println(wc.toString());

	}

}
