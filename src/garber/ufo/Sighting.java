package garber.ufo;

import com.google.gson.annotations.SerializedName;

public class Sighting {

	private String description;
	private String location;

	@SerializedName("sighted_at")
	private String sightedAt;
	@SerializedName("reported_at")
	private String reportedAt;
	private String duration;
	private String shape;

	public String getDescription() {
		return description;
	}

	public String getLocation() {
		return location;
	}

	public String getSightedAt() {
		return sightedAt;
	}

	public String getReportedAt() {
		return reportedAt;
	}

	public String getDuration() {
		return duration;
	}

	public String getShape() {
		return shape;
	}

	@Override
	public String toString() {
		return "Sighting [location=" + location + ", datesightedAt="
				+ sightedAt + ", shape=" + shape + "]";
	}

}
