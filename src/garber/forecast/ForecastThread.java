package garber.forecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.JTextField;

import com.google.gson.Gson;

public class ForecastThread extends Thread {

	private final ForecastGraph forecastGraph;
	private Forecast forecast;
	JTextField textField;

	public ForecastThread(ForecastGraph forecastGraph, Forecast forecast,
			JTextField textField) {
		this.forecastGraph = forecastGraph;
		this.forecast = forecast;
		this.textField = textField;

	}

	@Override
	public void run() {
		super.run();
		URL url;
		try {
			url = new URL("http://api.openweathermap.org/data/2.5/forecast?q="
					+ textField.getText() + "&mode=json&units=imperial");
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			Gson gson = new Gson();
			forecast = gson.fromJson(reader, Forecast.class);

			List[] list = forecast.getList();
			ArrayList<Double> dayTemps = new ArrayList<Double>();
			for (int i = 0; i < list.length; i++) {
				dayTemps.add(list[i].getMain().getTemp());
			}

			forecastGraph.setForecastGraph(dayTemps);
			forecastGraph.repaint();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
