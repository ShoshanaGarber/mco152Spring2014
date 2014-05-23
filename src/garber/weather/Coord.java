package garber.weather;

public class Coord {

	private double lon;
	private double lat;

	@Override
	public String toString() {
		return "Coord [lon=" + lon + ", lat=" + lat + "]";
	}

	public double getLon() {
		return lon;
	}

	public double getLat() {
		return lat;
	}

}
