package garber.mtamap;

public class Shape {

	private final String shapeID;
	private final double lat;
	private final double lon;

	public Shape(String shapeID, double lat, double lon) {
		this.shapeID = shapeID;
		this.lat = lat;
		this.lon = lon;

	}

	public String getShapeID() {
		return shapeID;
	}

	public double getLat() {
		return lat;
	}

	public double getLon() {
		return lon;
	}

}
