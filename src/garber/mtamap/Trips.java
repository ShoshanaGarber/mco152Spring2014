package garber.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Trips {

	private final List<Trip> trips;

	public Trips() throws IOException {
		trips = new ArrayList<Trip>();
		CSVReader reader = new CSVReader(new FileReader("trips.txt"), ',',
				'\"', 1);
		String[] nextLine;
		String routeID;
		String tripID;
		String shapeID;
		Trip trip;
		reader.readNext();
		while ((nextLine = reader.readNext()) != null) {
			routeID = nextLine[0];
			tripID = nextLine[2];
			shapeID = nextLine[6];

			trip = new Trip(tripID, routeID, shapeID);
			trips.add(trip);
		}
		reader.close();
	}

	public List<Trip> getTrips(String tripID) {
		return trips;
	}

	public Trip getTrip(String shapeID) {
		Trip trip = null;
		for (Trip t : trips) {
			if (t.getShapeID().equals(shapeID)) {
				trip = t;

			}
		}
		return trip;

	}

}
