package garber.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes {

	private final List<Shape> shapes;

	public Shapes() throws IOException {
		shapes = new ArrayList<Shape>();
		CSVReader reader = new CSVReader(new FileReader("shapes.txt"), ',',
				'\"', 1);
		String[] nextLine;
		String shapeID;
		double lat;
		double lon;
		Shape shape;

		while ((nextLine = reader.readNext()) != null) {
			shapeID = nextLine[0];
			lat = Double.valueOf(nextLine[1]);
			lon = Double.valueOf(nextLine[2]);
			shape = new Shape(shapeID, lat, lon);
			shapes.add(shape);
		}
		reader.close();
	}

	public List<Shape> getShapes() {
		return shapes;
	}

	public List<Shape> getShapes(String shapeID) {
		List<Shape> shapesList = new ArrayList<Shape>();
		for (Shape s : shapes) {
			if (shapeID.equals(s.getShapeID())) {
				shapesList.add(s);
			}
		}
		return shapesList;
	}

	public List<String> getShapeIds() {
		List<String> shapeIDs = new ArrayList<String>();
		for (Shape shape : shapes) {
			if (!shapeIDs.contains(shape.getShapeID())) {
				shapeIDs.add(shape.getShapeID());
			}
		}
		return shapeIDs;
	}

}
