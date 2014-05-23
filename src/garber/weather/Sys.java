package garber.weather;

public class Sys {

	private double message;
	private String country;
	private double sunrise;

	@Override
	public String toString() {
		return "Sys [message=" + message + ", country=" + country
				+ ", sunrise=" + sunrise + ", sunset=" + sunset + "]";
	}

	public double getMessage() {
		return message;
	}

	public String getCountry() {
		return country;
	}

	public double getSunrise() {
		return sunrise;
	}

	public double getSunset() {
		return sunset;
	}

	private double sunset;

}
