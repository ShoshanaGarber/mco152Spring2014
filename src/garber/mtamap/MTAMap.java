package garber.mtamap;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.List;

import javax.swing.JComponent;

public class MTAMap extends JComponent {
	Routes routes;
	Shapes shapes;
	Trips trips;

	public MTAMap() throws IOException {
		routes = new Routes();
		shapes = new Shapes();
		trips = new Trips();

	}

	public double getMinLat() {
		List<Shape> shapeList = shapes.getShapes();
		Double min = Double.MAX_VALUE;
		for (Shape s : shapeList) {
			if (s.getLat() < min) {
				min = s.getLat();
			}

		}
		return min;
	}

	public double getMinLon() {
		List<Shape> shapeList = shapes.getShapes();
		Double min = Double.MAX_VALUE;
		for (Shape s : shapeList) {
			if (s.getLon() < min) {
				min = s.getLon();
			}

		}
		return min;
	}

	public double getMaxLon() {
		List<Shape> shapeList = shapes.getShapes();
		double max = shapeList.get(0).getLon();
		for (Shape s : shapeList) {
			if (s.getLon() > max) {
				max = s.getLon();
			}

		}
		return max;
	}

	public double getMaxLat() {
		List<Shape> shapesList = shapes.getShapes();
		double max = shapesList.get(0).getLat();
		for (Shape s : shapesList) {
			if (s.getLat() > max) {
				max = s.getLat();
			}

		}
		return max;
	}

	@Override
	public void paintComponent(Graphics g) {
		double maxLat = this.getMaxLat();
		double minLat = this.getMinLat();
		double maxLon = this.getMaxLon();
		double minLon = this.getMinLon();
		double mapWidth = this.getWidth() - 1;
		double mapHeight = this.getHeight() - 1;
		double latLength = maxLat - minLat;
		double lonLength = maxLon - minLon;
		List<String> shapeIDs = shapes.getShapeIds();
		List<Shape> shapeList;

		for (String shapeID : shapeIDs) {
			shapeList = shapes.getShapes(shapeID);
			Trip trip = trips.getTrip(shapeID);
			if (trip != null) {
				Color color = routes.getColor(trip.getRouteID());
				g.setColor(color);
				for (int i = 1; i < shapeList.size(); i++) {
					Shape shape1 = shapeList.get(i - 1);
					Shape shape2 = shapeList.get(i);

					int x1 = (int) (((shape1.getLat() - minLat) / latLength) * mapWidth);
					int y1 = (int) (((shape1.getLon() - minLon) / lonLength) * mapHeight);
					int x2 = (int) (((shape2.getLat() - minLat) / latLength) * mapWidth);
					int y2 = (int) (((shape2.getLon() - minLon) / lonLength) * mapHeight);

					g.drawLine(x1, y1, x2, y2);

				}
			}

		}

	}
}
