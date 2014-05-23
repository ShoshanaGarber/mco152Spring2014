package garber.weather;

import java.util.Arrays;

public class WeatherConditions {

	private final Coord coord;
	private final Sys sys;
	private final Weather[] weather;
	private final String base;
	private final Main main;
	private final Wind wind;
	private final Rain rain;
	private final Clouds clouds;
	private final int dt;
	private final int id;
	private final String name;
	private final int cod;

	public WeatherConditions(Coord coord, Sys sys, Weather[] weather,
			String base, Main main, Wind wind, Rain rain, Clouds clouds,
			int dt, int id, String name, int cod) {
		this.coord = coord;
		this.sys = sys;
		this.weather = weather;
		this.base = base;
		this.main = main;
		this.wind = wind;
		this.rain = rain;
		this.clouds = clouds;
		this.dt = dt;
		this.id = id;
		this.name = name;
		this.cod = cod;
	}

	public Coord getCoord() {
		return coord;
	}

	public Rain getRain() {
		return rain;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public int getDt() {
		return dt;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCod() {
		return cod;
	}

	@Override
	public String toString() {
		return "WeatherConditions [coord=" + coord + ", sys=" + sys
				+ ", weather=" + Arrays.toString(weather) + ", base=" + base
				+ ", main=" + main + ", wind=" + wind + ", rain=" + rain
				+ ", clouds=" + clouds + ", dt=" + dt + ", id=" + id
				+ ", name=" + name + ", cod=" + cod + "]";
	}

	public Sys getSys() {
		return sys;
	}

	public Weather[] getWeather() {
		return weather;
	}

	public String getBase() {
		return base;
	}

	public Main getMain() {
		return main;
	}

	public Wind getWind() {
		return wind;
	}

}
