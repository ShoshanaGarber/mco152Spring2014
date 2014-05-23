package garber.weather;

public class Weather {

	private String id;
	private String main;
	private String description;
	private String icon;

	@Override
	public String toString() {
		return "Weather [id=" + id + ", main=" + main + ", description="
				+ description + ", icon=" + icon + "]";
	}

}
