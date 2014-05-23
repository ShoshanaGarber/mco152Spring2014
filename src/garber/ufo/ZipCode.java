package garber.ufo;

public class ZipCode {

	private final String zipCode;
	private final String lat;
	private final String lon;
	private final String city;
	private final String state;

	public ZipCode(String zipCode, String lat, String lon, String city,
			String state) {
		this.zipCode = zipCode;
		this.lat = lat;
		this.lon = lon;
		this.city = city;
		this.state = state;

	}

	@Override
	public String toString() {
		return "ZipCode [zipCode=" + zipCode + ", lat=" + lat + ", lon=" + lon
				+ ", city=" + city + ", state=" + state + "]";
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getLat() {
		return lat;
	}

	public String getLon() {
		return lon;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

}
