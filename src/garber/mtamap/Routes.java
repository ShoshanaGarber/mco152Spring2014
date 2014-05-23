package garber.mtamap;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Routes {

	private final List<Route> routes;

	public Routes() throws IOException {
		routes = new ArrayList<Route>();
		CSVReader reader = new CSVReader(new FileReader("routes.txt"), ',',
				'\"', 1);
		String[] nextLine;
		String routeID;
		Color color;

		while ((nextLine = reader.readNext()) != null) {
			routeID = nextLine[0];
			if ("".equals(nextLine[7])) {
				color = null;
			} else {
				color = Color.decode("#" + nextLine[7]);
			}
			Route route = new Route(routeID, color);
			routes.add(route);
		}
		reader.close();
	}

	public List<Route> getRoutes(String routeID) {
		return routes;
	}

	public Color getColor(String routeID) {
		Color color = null;
		for (Route r : routes) {
			if (routeID.equals(r.getRouteID())) {
				color = r.getColor();
				break;
			}
		}
		return color;
	}

}
